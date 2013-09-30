package pn2sc.jobs

import PetriNet.NamedElement
import PetriNet.Net
import PetriNet.PetriNetPackage
import PetriNet.Place
import PetriNet.Transition
import java.util.ArrayList
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.viatra2.emf.runtime.modelmanipulation.IModelManipulations
import org.eclipse.viatra2.emf.runtime.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra2.emf.runtime.rules.TransformationRuleGroup
import org.eclipse.viatra2.emf.runtime.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra2.emf.runtime.rules.batch.BatchTransformationStatements
import org.eclipse.viatra2.emf.runtime.transformation.batch.BatchTransformation
import pn2sc.queries.AndPrecondMatcher
import pn2sc.queries.EmptyOrMatcher
import pn2sc.queries.EquivContainsMatcher
import pn2sc.queries.EquivMatch
import pn2sc.queries.EquivMatcher
import pn2sc.queries.NextStateMatcher
import pn2sc.queries.OrPrecondMatcher
import pn2sc.queries.PlaceMatcher
import pn2sc.queries.TopOrMatcher
import pn2sc.queries.TraceElementMatch
import pn2sc.queries.TraceElementMatcher
import pn2sc.queries.TransitionMatcher
import pn2sctrace.MapTrace
import pn2sctrace.PN2SCTracemodel
import pn2sctrace.Pn2sctracePackage
import statecharts.AND
import statecharts.Basic
import statecharts.HyperEdge
import statecharts.OR
import statecharts.State
import statecharts.Statechart
import statecharts.StatechartsPackage

class Pn2ScJobs {
	PN2SCTracemodel traceModel
	Statechart stateChart
	Net petriNet
	Resource stateChartResource
	
	extension BatchTransformationRuleFactory ruleFactory = new BatchTransformationRuleFactory
	extension BatchTransformation transformation
	extension BatchTransformationStatements statements
	extension IModelManipulations manipulation 
	extension PetriNetPackage petriPackage = PetriNetPackage.eINSTANCE
	extension StatechartsPackage chartPackage = StatechartsPackage.eINSTANCE
	extension Pn2sctracePackage tracePackage = Pn2sctracePackage.eINSTANCE
	
	
	new(Resource petriNetResource, Resource stateChartResource, Resource traceModelResource) {
		this.stateChartResource = stateChartResource
		this.petriNet = petriNetResource.contents.head as Net
		this.stateChart = stateChartResource.contents.head as Statechart
		this.traceModel = traceModelResource.contents.head as PN2SCTracemodel
		
		transformation = new BatchTransformation(petriNetResource.resourceSet)
		statements = new BatchTransformationStatements(transformation)
		manipulation = new SimpleModelManipulations(transformation.iqEngine)
	}
	
	/**
	 * Map a PetriNet place to a base state in the StateChart with an "or" container.
	 */
	val createMapPlaceRuleSpecification = createRule(PlaceMatcher::querySpecification) [
		// create base b with b.name=p.name; and the state or, where or.contains={b}
		var or = stateChartResource.create(OR) as OR
		var basic = or.createChild(compound_Contains, basic) as Basic 
		basic.set(state_Name, p.name)///name = p.name
		// create trace from place to or
		createTrace(p, or)
	]
	
	/**
	 * Map a PetriNet transition to a hyperedge state in the StateChart without an "or" container.
	 */
	val createMapTransitionRuleSpecification = createRule(TransitionMatcher::querySpecification) [
		// create hyperEdge h with h.name=t.name (without an or container)
		var hyperEdge = stateChartResource.create(hyperEdge) as HyperEdge
		hyperEdge.name = t.name
		// create trace from transition to hyperEdge
		createTrace(t, hyperEdge)
	]
	
	/**
	 * Create "next" edges in the StateChart between elements connected in the PetriNet. 
	 */
	val createNextStateRuleSpecification = createRule(NextStateMatcher::querySpecification) [
		state1.addTo(state_Next, state2)
	]
	
	/**
	 * Get rules for performing initial mapping
	 */
	def getInitialisationRules() {
		new TransformationRuleGroup(
			createMapPlaceRuleSpecification,
			createMapTransitionRuleSpecification,
			createNextStateRuleSpecification
		)
	}
	
	/**
	 * Rule specification of (both) "and" rule
	 */
	val createAndRuleSpecification = createRule(AndPrecondMatcher::querySpecification) [
		val place = p
		// collect places (pre places if the transition is a post transition, post places otherwise)
		val EList<Place> placesSet = if (place.postt.contains(t))
				t.prep
			else
				t.postp
			
		// add new OR and AND to the StateChart
		val newP = stateChartResource.create(OR) as OR
		val newA = newP.createChild(compound_Contains, AND) as AND
		
		// add children of AND (equiv(p)) to the new AND state (newA)
		placesSet.forEach[equiv(it).moveTo(newA, compound_Contains)]
		// remove traces of places from TraceModel
		placesSet.forEach[removeTrace]
		// add new place --> OR (newP) to TraceModel
		createTrace(place, newP)
		// remove places from PetriNet, except one
		val placeSetIt = new ArrayList(placesSet)
		placeSetIt.forEach [
			if(it != place) deletePlace
		]
	]
	
	/**
	 * Rule specification of the OR rule
	 */
	val createOrRuleSpecification = createRule(OrPrecondMatcher::querySpecification) [
		// get the only pre-place (q) and post-place (r)
		val q = t.prep.head
		val r = t.postp.head
		// merge transitions of post-place (r) into pre-place (q)
		q.addTo(place_Pret, r.pret)
		q.addTo(place_Postt, r.postt)
		// add new OR to the StateChart
		val newP = stateChartResource.create(OR) as OR 
		//stf.createOR()
		newP.moveTo(stateChartResource)
		
		val moveChildrenRule = createRule(EquivContainsMatcher::querySpecification) [
			state.moveTo(newP, compound_Contains)
		]
		// add children elements to OR of the StateChart
		moveChildrenRule.fireAllCurrent("namedElement" -> q) // add equiv(q).contains
		moveChildrenRule.fireAllCurrent("namedElement" -> r) // add equiv(r).contains
		equiv(t).moveTo(newP, compound_Contains) // add the hyperedge ("equiv(t)") also
		// remove traces of q, transition and r
		removeTrace(q)
		removeTrace(t)
		if(q != r) removeTrace(r) // remove only when it is not a cycle in the PetriNet
		// add new q --> OR (newP) to TraceModel
		createTrace(q, newP)
		// remove post-place and the transition from PetriNet
		if(q != r) deletePlace(r) // delete only when it is not a cycle in the PetriNet
		deleteTransition(t)
	]
	
	/**
	 * Get rules for performing AND and OR rules
	 */
	def getAndOrRules() {
		new TransformationRuleGroup (
			createAndRuleSpecification,
			createOrRuleSpecification
		)
	}
	

	/**
	 * Remove OR states in the root without content
	 */	
	val createOrRemoveRuleSpecification = createRule(EmptyOrMatcher::querySpecification) [
		//TODO is this correct?
		//stateChartResource.remove(orState)
		orState.remove
	]
	
	/**
	 * Create the StateChart containing the AND containing the top level OR
	 */
	val createTopand = createRule(TopOrMatcher::querySpecification) [
		val topSc = stateChartResource.create(statechart) as Statechart
		val topAnd = topSc.createChild(statechart_TopState, AND) as AND
		orState.moveTo(topAnd, compound_Contains)
	]
	
	/**
	 * Get rules for creating root StateChart and removing orphaned ORs
	 */
	def getFinalisationRules() {
		new TransformationRuleGroup(
			createOrRemoveRuleSpecification,
			createTopand
		)
	}
	
	def transformPn2Sc() {
		// place->OR mapping
		initialisationRules.fireWhilePossible
		// execute AND and OR rules
		andOrRules.fireWhilePossible
		// clean orphaned root ORs; and create StateChart root
		finalisationRules.fireWhilePossible
	}
	
	
	// util functions
	/**
	 * Create a trace element between a NamedElement and State
	 */
	def createTrace(NamedElement source, State target) {
		var aTrace = traceModel.createChild(PN2SCTracemodel_Contains, mapTrace) as MapTrace
		aTrace.set(mapTrace_Source, source)
		aTrace.set(mapTrace_Target, target)
	}
	
	/**
	 * Delete the trace of a NamedElement
	 */
	def removeTrace(NamedElement source) {
		var mapTrace = TraceElementMatcher::querySpecification.<TraceElementMatch, TraceElementMatcher>find("smElement" -> source).trace
//		var mapTrace = traceElementMatcher.getOneArbitraryMatch(source, null).trace
		mapTrace.remove
	}
	
	/**
	 * The equiv function (namedElement->state)
	 */
	def equiv(NamedElement namedElement) {
		EquivMatcher::querySpecification.<EquivMatch, EquivMatcher>find("namesElement" -> namedElement).state
		//equivMatcher.getOneArbitraryMatch(namedElement, null).state
	}
	
	/**
	 * Delete a place from the model completely
	 */
	def deletePlace(Place place) {
		place.remove(place_Pret)
		place.remove(place_Postt)
		place.remove
	}
	
	/**
	 * Delete a transition from the model completely
	 */
	def deleteTransition(Transition transition) {
		transition.remove(transition_Prep)
		transition.remove(transition_Postp)
		transition.remove
	}
	
}