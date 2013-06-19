package pn2sc.jobs

import statecharts.StatechartsFactory
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.incquery.runtime.api.IMatchProcessor
import pn2sctrace.Pn2sctraceFactory
import pn2sctrace.PN2SCTracemodel
import PetriNet.Net
import statecharts.Statechart
import java.util.ArrayList
import java.io.FileOutputStream
import PetriNet.NamedElement
import statecharts.State
import PetriNet.Place
import PetriNet.Transition
import java.io.File
import org.eclipse.emf.common.util.EList

import static org.eclipse.incquery.runtime.evm.specific.Rules.*
import static org.eclipse.incquery.runtime.evm.specific.Jobs.*
import PetriNet.PetriNetFactory
import org.eclipse.incquery.runtime.evm.api.RuleSpecification
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.emf.ecore.EObject
import java.util.Collection
import pn2sc.queries.EquivMatcher
import pn2sc.queries.TraceElementMatcher
import pn2sc.queries.EquivContainsMatcher
import pn2sc.queries.TransitionMatch
import pn2sc.queries.TransitionMatcher
import pn2sc.queries.NextStateMatch
import pn2sc.queries.NextStateMatcher
import pn2sc.queries.AndPrecondMatch
import pn2sc.queries.AndPrecondMatcher
import pn2sc.queries.OrPrecondMatch
import pn2sc.queries.OrPrecondMatcher
import pn2sc.queries.EmptyOrMatch
import pn2sc.queries.EmptyOrMatcher
import pn2sc.queries.TopOrMatch
import pn2sc.queries.TopOrMatcher
import pn2sc.queries.PlaceMatch
import pn2sc.queries.PlaceMatcher
import pn2sc.queries.PostTMatch
import pn2sc.queries.PostTMatcher
import pn2sc.queries.PreTMatch
import pn2sc.queries.PreTMatcher
import org.eclipse.incquery.runtime.evm.specific.lifecycle.DefaultActivationLifeCycle
import org.eclipse.incquery.runtime.evm.specific.event.IncQueryActivationStateEnum

class Pn2ScJobs {
	long debug
	String basePath
	PN2SCTracemodel traceModel
	Statechart stateChart
	Net petriNet
	Resource traceModelResource
	Resource stateChartResource
	Resource petriNetResource
	IncQueryEngine engine
	int snapshotNumber
	EquivMatcher equivMatcher
	EquivContainsMatcher equivContainsMatcher
	TraceElementMatcher traceElementMatcher
	
	static val pnf = PetriNetFactory::eINSTANCE;
	static val stf = StatechartsFactory::eINSTANCE;
	static val trf = Pn2sctraceFactory::eINSTANCE;
	
	
	new(IncQueryEngine engine, Resource petriNetResource, Resource stateChartResource, Resource traceModelResource, String basePath, long debug) {
		this.debug = debug
		this.basePath = basePath
		this.engine = engine
		this.petriNetResource = petriNetResource
		this.stateChartResource = stateChartResource
		this.traceModelResource = traceModelResource
		this.petriNet = petriNetResource.contents.head as Net
		this.stateChart = stateChartResource.contents.head as Statechart
		this.traceModel = traceModelResource.contents.head as PN2SCTracemodel
		this.snapshotNumber = 0
	}
	
	/*
	 * Map a PetriNet place to a base state in the StateChart with an "or" container.
	 */
	def createMapPlaceRuleSpecification() {
		newSimpleMatcherRuleSpecification(PlaceMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(<PlaceMatch>newStatelessJob(IncQueryActivationStateEnum::APPEARED) [
				// create base b with b.name=p.name; and the state or, where or.contains={b}
				var basic = stf.createBasic()
				basic.name = p.name
				var or = stf.createOR()
				basic.moveTo(or.contains)
				
				// add the or state to the StateChart resource
				or.moveTo(stateChartResource.contents)
				
				// create trace from place to or
				createTrace(p, or)
			]))
	}
	
	/*
	 * Map a PetriNet transition to a hyperedge state in the StateChart without an "or" container.
	 */
	def createMapTransitionRuleSpecification() {
		val IMatchProcessor<TransitionMatch> processor = [
			// create hyperEdge h with h.name=t.name (without an or container)
			var hyperEdge = stf.createHyperEdge()
			hyperEdge.name =t.name
			
			// add the hyperEdge to the StateChart resource
			hyperEdge.moveTo(stateChartResource.contents) 
			
			// create trace from transition to hyperEdge
			createTrace(t, hyperEdge)
		]
		
		newSimpleMatcherRuleSpecification(TransitionMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(IncQueryActivationStateEnum::APPEARED, processor)))
	}
	
	/*
	 * Create "next" edges in the StateChart between elements connected in the PetriNet. 
	 */
	def createNextStateRuleSpecification() {
		val IMatchProcessor<NextStateMatch> processor = [
			state1.next += state2
		]
		
		newSimpleMatcherRuleSpecification(NextStateMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(IncQueryActivationStateEnum::APPEARED, processor)))
	}
	
	/*
	 * Get rules for performing initial mapping
	 */
	def getInitialisationRules() {
		newHashSet(
			createMapPlaceRuleSpecification() as RuleSpecification<?>,
			createMapTransitionRuleSpecification() as RuleSpecification<?>,
			createNextStateRuleSpecification() as RuleSpecification<?>
		)
	}
	
	/*
	 * Rule specification of (both) "and" rule
	 */
	def createAndRuleSpecification() {
		val IMatchProcessor<AndPrecondMatch> processor = [
			// collect places (pre places if the transition is a post transition, post places otherwise)
			var EList<Place> placesSet
			if (p.postt.contains(t))
				placesSet = t.prep
			else
				placesSet = t.postp
			
			// run the AND transformation 
			processAndRule(p, placesSet)
		]
				
		newSimpleMatcherRuleSpecification(AndPrecondMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(IncQueryActivationStateEnum::APPEARED, processor)))
	}
	
	/*
	 * Action (processor) for the and rule
	 */
	def processAndRule(Place place, EList<Place> placesSet) {
			// add new OR and AND to the StateChart
			val newP = stf.createOR()
			val newA = stf.createAND()
			newA.moveTo(newP.contains)
			newP.moveTo(stateChartResource.contents) 
			
			// add children of AND (equiv(p)) to the new AND state (newA)
			placesSet.forEach[ p | equiv(p).moveTo(newA.contains) ]
			
			// remove traces of places from TraceModel
			placesSet.forEach[ removeTrace ]
			
			// add new place --> OR (newP) to TraceModel
			createTrace(place, newP)
			
			// remove places from PetriNet, except one
			val placeSetIt = new ArrayList(placesSet)
			placeSetIt.forEach[  
				if (it != place) deletePlace
			]
	}
	
	/*
	 * Rule specification of the OR rule
	 */
	def createOrRuleSpecification() {
		val IMatchProcessor<OrPrecondMatch> processor = [
			// get the only pre-place (q) and post-place (r)
			val q = t.prep.head
			val r = t.postp.head
			
			// merge transitions of post-place (r) into pre-place (q)
			q.pret += r.pret
			q.postt += r.postt
			
			// add new OR to the StateChart
			val newP = stf.createOR()
			newP.moveTo(stateChartResource.contents)
			
			// add children elements to OR of the StateChart
			equivContainsMatcher.forEachMatch(q,null)[state.moveTo(newP.contains)] // add equiv(q).contains
			equivContainsMatcher.forEachMatch(r,null)[state.moveTo(newP.contains)] // add equiv(r).contains
			var transitionState = equiv(t)
			transitionState.moveTo(newP.contains)  // add the hyperedge ("equiv(t)") also
			
			// remove traces of q, transition and r
			removeTrace(q)
			removeTrace(t)
			if (q != r) removeTrace(r) // remove only when it is not a cycle in the PetriNet
			
			// add new q --> OR (newP) to TraceModel
			createTrace(q, newP)
			
			// remove post-place and the transition from PetriNet
			if (q != r) deletePlace(r) // delete only when it is not a cycle in the PetriNet
			deleteTransition(t)
		]
		
		newSimpleMatcherRuleSpecification(OrPrecondMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(IncQueryActivationStateEnum::APPEARED, processor)))
	}
	
	/*
	 * Get rules for performing AND and OR rules
	 */
	def getAndOrRules() {
		newHashSet(
			createAndRuleSpecification() as RuleSpecification<?>,
			createOrRuleSpecification() as RuleSpecification<?>
		)
	}
	

	/*
	 * Remove OR states in the root without content
	 */	
	def createOrRemoveRuleSpecification() {
		val IMatchProcessor<EmptyOrMatch> processor = [
			stateChartResource.contents.remove(orState)
		]
		
		newSimpleMatcherRuleSpecification(EmptyOrMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(IncQueryActivationStateEnum::APPEARED, processor)))
	}
	
	/*
	 * Create the StateChart containing the AND containing the top level OR
	 */
	def createTopand() {
		val IMatchProcessor<TopOrMatch> processor = [
			val topSc = stf.createStatechart()
			val topAnd = stf.createAND()
			
			topSc.moveTo(stateChartResource.contents)
			topSc.topState = topAnd
			orState.moveTo(topAnd.contains)
		]
		
		newSimpleMatcherRuleSpecification(TopOrMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(IncQueryActivationStateEnum::APPEARED, processor)))
	}
	
	/*
	 * Get rules for creating root StateChart and removing orphaned ORs
	 */
	def getFinalisationRules() {
		newHashSet(
			createOrRemoveRuleSpecification() as RuleSpecification<?>,
			createTopand() as RuleSpecification<?>
		)
	}
	
	// change propagation part
	
	/*
	 * Change propagation of a place
	 */
	def createCPPlaceRule() {
		// new place appeared
		val IMatchProcessor<PlaceMatch> processorAdd = [
			// create new basic state, and trace between place and basic
			val basic = stf.createBasic()
			basic.name = p.name
			basic.moveTo(stateChartResource.contents)
			createTrace(p, basic)
			
			doAllSnapshot("NewPlace")
		]
		
		// a place deleted
		val IMatchProcessor<PlaceMatch> processorDelete = [
			val place = it.p
			
			// lookup trace of place and delete the basic
			val basic = equiv(place)
			stateChartResource.contents.remove(basic)
			removeTrace(place)
			
			doAllSnapshot("DeletePlace")
		]
		
		// a place's name updated
		val IMatchProcessor<PlaceMatch> processorUpdate = [
			// lookup trace of place and update the basic's name
			val basic = equiv(p)
			basic.name = p.name
			
			doAllSnapshot("UpdatePlace")
		]
		
		newSimpleMatcherRuleSpecification(PlaceMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT,
			newHashSet( newEnableJob( newRecordingJob( newStatelessJob(IncQueryActivationStateEnum::APPEARED, processorAdd))), 
						newEnableJob( newRecordingJob( newStatelessJob(IncQueryActivationStateEnum::DISAPPEARED, processorDelete))),
						newEnableJob( newRecordingJob( newStatelessJob(IncQueryActivationStateEnum::UPDATED, processorUpdate)))
			))
	}
	
	/*
	 * Change propagation of a transition
	 */
	def createCPTransitionRule() {
		// a transition is added
		val IMatchProcessor<TransitionMatch> processorAdd = [
			val hyperEdge = stf.createHyperEdge()
			hyperEdge.name = t.name
			hyperEdge.moveTo(stateChartResource.contents)
			createTrace(t, hyperEdge)
			
			doAllSnapshot("NewTransition")
		]
		
		// a transition is deleted
		val IMatchProcessor<TransitionMatch> processorDelete = [
			val hyperEdge = equiv(t)
			stateChartResource.contents.remove(hyperEdge)
			removeTrace(t)
			
			doAllSnapshot("DeleteTransition")
		]
		
		// a transition's name is updated
		val IMatchProcessor<TransitionMatch> processorUpdate = [
			val hyperEdge = equiv(t)
			hyperEdge.name = t.name
			
			doAllSnapshot("UpdateTransition")
		]
		
		newSimpleMatcherRuleSpecification(TransitionMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT,
			newHashSet( newEnableJob( newRecordingJob( newStatelessJob( IncQueryActivationStateEnum::APPEARED, processorAdd))), 
						newEnableJob( newRecordingJob( newStatelessJob( IncQueryActivationStateEnum::DISAPPEARED, processorDelete))),
						newEnableJob( newRecordingJob( newStatelessJob( IncQueryActivationStateEnum::UPDATED, processorUpdate)))
			))
		
	}
	
	/*
	 * Change propagation of a place --> transition connection
	 */
	def createCPPlaceToTransitionRule() {
		// a P->T connection is created
		val IMatchProcessor<PostTMatch> processorAdd = [
			val basic = equiv(p)
			val hyperEdge = equiv(t)
			
			basic.next += hyperEdge
			
			doAllSnapshot("CP_PT_added")
		]
		
		// a P->T connection is deleted
		val IMatchProcessor<PostTMatch> processorRemove = [
			val basic = equiv(p)
			val hyperEdge = equiv(t)
			
			basic.next.remove(hyperEdge)
			
			doAllSnapshot("CP_PT_removed")
		]
		
		newSimpleMatcherRuleSpecification(PostTMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE,
			newHashSet(newStatelessJob(IncQueryActivationStateEnum::APPEARED, processorAdd),
				       newStatelessJob(IncQueryActivationStateEnum::DISAPPEARED, processorRemove)
			))
	}
	
	/*
	 * Change propagation of a transition --> place connection
	 */
	def createCPTransitionToPlaceRule() {
		// a T->P connection is created
		val IMatchProcessor<PreTMatch> processorAdd = [
			val basic = equiv(p)
			val hyperEdge = equiv(t)
			
			hyperEdge.next += basic
			
			doAllSnapshot("CP_TP_added")
		]
		
		// a T->P connection is deleted
		val IMatchProcessor<PreTMatch> processorRemove = [
			val basic = equiv(p)
			val hyperEdge = equiv(t)
			
			hyperEdge.next.remove(basic)
			
			doAllSnapshot("CP_TP_removed")
		]
		
		newSimpleMatcherRuleSpecification(PreTMatcher::querySpecification,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE,
			newHashSet(newStatelessJob(IncQueryActivationStateEnum::APPEARED, processorAdd),
				       newStatelessJob(IncQueryActivationStateEnum::DISAPPEARED, processorRemove)
			))
	}
	
	def getCPRules() {
		newHashSet(
			createCPPlaceRule() as RuleSpecification<?>,
			createCPTransitionRule() as RuleSpecification<?>,
			createCPPlaceToTransitionRule() as RuleSpecification<?>,
			createCPTransitionToPlaceRule() as RuleSpecification<?>
		)
	}
	
	def manipulate() {
		// create petrinet factors and get root place
			val onlyPlace = petriNet.places.head; 

			//  a)
			//  create place and add to petrinet
			val place = pnf.createPlace();
			place.name = "newPlace";
			petriNet.places += place;
			//  create transition and add to petrinet
			val transition = pnf.createTransition();
			transition.name = "newTransition";
			transition.moveTo(petriNet.transitions)
			//  connect: place -> transition
			place.postt += transition
			//  connect: transition -> onlyPlace
			transition.postp += onlyPlace

			//  b) change names
			place.name = "theNewPlace";
			transition.name = "theNewTransition";

			//  c) remove place and transition
			deletePlace(place);
			deleteTransition(transition);
	}
	
	
	// util functions
	/*
	 * Create snapshot of a resource
	 * @param resource: resource to be saved
	 * @param postfix: file extension
	 * @param type: type of the snapshot 
	 */
	def doSnapshot(Resource resource, String postfix, String type) {
		val path = basePath + "/test/dbg" + snapshotNumber + type + postfix
		val file = new File(path)
		file.createNewFile()
		var output = new FileOutputStream(file);
		
		resource.save(output, null)
		output.close()
	}	
	
	/*
	 * Create snapshot of the petrinet, statecharts, and the trace model
	 */
	def doAllSnapshot(String cond) {
		if (debug.bitwiseAnd(1) == 1) {
			doSnapshot(stateChartResource, ".statecharts", cond)
			doSnapshot(petriNetResource, ".petrinet", cond)
			doSnapshot(traceModelResource, ".pn2sctrace", cond)
			snapshotNumber = snapshotNumber + 1
		}
	}
	
	/*
	 * Create a trace element between a NamedElement and State
	 */
	def createTrace(NamedElement source, State target) {
		var aTrace = trf.createMapTrace()
		aTrace.source = source
		aTrace.target = target
		aTrace.moveTo(traceModel.contains)
	}
	
	/*
	 * Delete the trace of a NamedElement
	 */
	def removeTrace(NamedElement source) {
		var mapTrace = traceElementMatcher.getOneArbitraryMatch(source, null).trace
		traceModel.contains.remove(mapTrace)
	}
	
	/*
	 * The equiv function (namedElement->state)
	 */
	def equiv(NamedElement namedElement) {
		equivMatcher.getOneArbitraryMatch(namedElement, null).state
	}
	
	/*
	 * Delete a place from the model completely
	 */
	def deletePlace(Place place) {
		place.pret.clear()
		place.postt.clear()
		petriNet.places.remove(place)
	}
	
	/*
	 * Delete a transition from the model completely
	 */
	def deleteTransition(Transition transition) {
		transition.prep.clear()
		transition.postp.clear()
		petriNet.transitions.remove(transition)
	}
	
	/*
	 * Built-in move command (supported by the engine)
	 */
	def moveTo(EObject what, EList where) {
		engine.baseIndex.cheapMoveTo(what, where)
	}
	def moveTo(Collection<EObject> what, EList where) {
		what.forEach[moveTo(where)]
	}
	
	def setMatchers(EquivMatcher eqm, EquivContainsMatcher eqcm, TraceElementMatcher tem) {
		equivMatcher = eqm
		equivContainsMatcher = eqcm
		traceElementMatcher = tem
	}
	
}