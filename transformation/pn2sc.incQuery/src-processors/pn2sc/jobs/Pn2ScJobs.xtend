package pn2sc.jobs

import statecharts.StatechartsFactory
import org.eclipse.incquery.runtime.evm.specific.DefaultActivationLifeCycle
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.incquery.runtime.api.IMatchProcessor
import org.eclipse.incquery.runtime.evm.api.ActivationState
import pn2sctrace.Pn2sctraceFactory
import pn2sctrace.PN2SCTracemodel
import pn2sc.queries.transition.TransitionMatch
import pn2sc.queries.transition.TransitionMatcher
import pn2sc.queries.nextstate.NextStateMatch
import pn2sc.queries.nextstate.NextStateMatcher
import pn2sc.queries.andprecond2.AndPrecond2Match
import pn2sc.queries.andprecond2.AndPrecond2Matcher
import PetriNet.Net
import pn2sc.queries.traceelement.TraceElementMatcher
import pn2sc.queries.orprecond.OrPrecondMatch
import pn2sc.queries.orprecond.OrPrecondMatcher
import pn2sc.queries.topor.TopOrMatch
import pn2sc.queries.topor.TopOrMatcher
import statecharts.Statechart
import java.util.ArrayList
import java.io.FileOutputStream
import pn2sc.queries.emptyor.EmptyOrMatch
import pn2sc.queries.emptyor.EmptyOrMatcher
import PetriNet.NamedElement
import statecharts.State
import PetriNet.Place
import PetriNet.Transition
import pn2sc.common.EnableableJob
import java.io.File
import org.eclipse.emf.common.util.EList
import pn2sc.queries.postt.PostTMatch
import pn2sc.queries.postt.PostTMatcher
import pn2sc.queries.pret.PreTMatch
import pn2sc.queries.pret.PreTMatcher

import static org.eclipse.incquery.runtime.evm.specific.Rules.*
import static org.eclipse.incquery.runtime.evm.specific.Jobs.*
import PetriNet.PetriNetFactory
import org.eclipse.incquery.runtime.api.IPatternMatch
import org.eclipse.incquery.runtime.evm.api.RuleSpecification
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.emf.ecore.EObject
import java.util.Collection
import pn2sc.queries.place.PlaceMatch
import pn2sc.queries.place.PlaceMatcher
import pn2sc.queries.equiv.EquivMatcher
import pn2sc.queries.equivcontains.EquivContainsMatcher
import pn2sc.queries.andprecond2.AndPrecond2Match
import org.eclipse.incquery.runtime.api.EngineManager
import java.util.List

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
		newSimpleMatcherRuleSpecification(PlaceMatcher::factory,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(<PlaceMatch>newStatelessJob(ActivationState::APPEARED) [
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
			val transition = it.t
			
			// create hyperEdge h with h.name=t.name (without an or container)
			var hyperEdge = stf.createHyperEdge()
			hyperEdge.name =transition.name
			
			// add the hyperEdge to the StateChart resource
			hyperEdge.moveTo(stateChartResource.contents) 
			
			// create trace from transition to hyperEdge
			createTrace(transition, hyperEdge)
		]
		
		newSimpleMatcherRuleSpecification(TransitionMatcher::factory,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(ActivationState::APPEARED, processor)))
	}
	
	/*
	 * Create "next" edges in the StateChart between elements connected in the PetriNet. 
	 */
	def createNextStateRuleSpecification() {
		val IMatchProcessor<NextStateMatch> processor = [
			val prev = it.state1
			val succ = it.state2
			
			prev.next += succ
		]
		
		newSimpleMatcherRuleSpecification(NextStateMatcher::factory,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(ActivationState::APPEARED, processor)))
	}
	
	/*
	 * Get rules for performing initial mapping
	 */
	def getInitialisationRules() {
		newHashSet(
			createMapPlaceRuleSpecification() as RuleSpecification<? extends IPatternMatch>,
			createMapTransitionRuleSpecification() as RuleSpecification<? extends IPatternMatch>,
			createNextStateRuleSpecification() as RuleSpecification<? extends IPatternMatch>
		)
	}
	
	/*
	 * Rule specification of (both) "and" rule
	 */
	def createAndRuleSpecification() {
		val IMatchProcessor<AndPrecond2Match> processor = [
			val place = it.p
			
			// collect places (pre places if the transition is a post transition, post places otherwise)
			var EList<Place> placesSet
			if (p.postt.contains(t))
				placesSet = t.prep
			else
				placesSet = t.postp
			
			// run the AND transformation 
			processAndRule(place, placesSet)
		]
				
		newSimpleMatcherRuleSpecification(AndPrecond2Matcher::factory,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(ActivationState::APPEARED, processor)))
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
			val transition = it.t
			
			// get the only pre-place (q) and post-place (r)
			val q = transition.prep.head
			val r = transition.postp.head
			
			// merge transitions of post-place (r) into pre-place (q)
			q.pret += r.pret
			q.postt += r.postt
			
			// add new OR to the StateChart
			val newP = stf.createOR()
			newP.moveTo(stateChartResource.contents)
			
			// add children elements to OR of the StateChart
			equivContainsMatcher.forEachMatch(q,null)[state.moveTo(newP.contains)] // add equiv(q).contains
			equivContainsMatcher.forEachMatch(r,null)[state.moveTo(newP.contains)] // add equiv(r).contains
			var transitionState = equiv(transition)
			transitionState.moveTo(newP.contains)  // add the hyperedge ("equiv(t)") also
			
			// remove traces of q, transition and r
			removeTrace(q)
			removeTrace(transition)
			if (q != r) removeTrace(r) // remove only when it is not a cycle in the PetriNet
			
			// add new q --> OR (newP) to TraceModel
			createTrace(q, newP)
			
			// remove post-place and the transition from PetriNet
			if (q != r) deletePlace(r) // delete only when it is not a cycle in the PetriNet
			deleteTransition(transition)
		]
		
		newSimpleMatcherRuleSpecification(OrPrecondMatcher::factory,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(ActivationState::APPEARED, processor)))
	}
	
	/*
	 * Get rules for performing AND and OR rules
	 */
	def getAndOrRules() {
		newHashSet(
			createAndRuleSpecification() as RuleSpecification<? extends IPatternMatch>,
			createOrRuleSpecification() as RuleSpecification<? extends IPatternMatch>
		)
	}
	

	/*
	 * Remove OR states in the root without content
	 */	
	def createOrRemoveRuleSpecification() {
		val IMatchProcessor<EmptyOrMatch> processor = [
			stateChartResource.contents.remove(orState)
		]
		
		newSimpleMatcherRuleSpecification(EmptyOrMatcher::factory,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(ActivationState::APPEARED, processor)))
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
		
		newSimpleMatcherRuleSpecification(TopOrMatcher::factory,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE_AND_DISAPPEAR,
			newHashSet(newStatelessJob(ActivationState::APPEARED, processor)))
	}
	
	/*
	 * Get rules for creating root StateChart and removing orphaned ORs
	 */
	def getFinalisationRules() {
		newHashSet(
			createOrRemoveRuleSpecification() as RuleSpecification<? extends IPatternMatch>,
			createTopand() as RuleSpecification<? extends IPatternMatch>
		)
	}
	
	// change propagation part
	
	/*
	 * Change propagation of a place
	 */
	def createCPPlaceRule() {
		// new place appeared
		val IMatchProcessor<PlaceMatch> processorAdd = [
			val place = it.p
			
			// create new basic state, and trace between place and basic
			val basic = stf.createBasic()
			basic.name = place.name
			basic.moveTo(stateChartResource.contents)
			createTrace(place, basic)
			
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
			val place = it.p
			
			// lookup trace of place and update the basic's name
			val basic = equiv(place)
			basic.name = place.name
			
			doAllSnapshot("UpdatePlace")
		]
		
		newSimpleMatcherRuleSpecification(PlaceMatcher::factory,
			DefaultActivationLifeCycle::DEFAULT,
			newHashSet( EnableableJob::newEnableableJob(ActivationState::APPEARED, processorAdd), 
						EnableableJob::newEnableableJob(ActivationState::DISAPPEARED, processorDelete),
						EnableableJob::newEnableableJob(ActivationState::UPDATED, processorUpdate)
			))
	}
	
	/*
	 * Change propagation of a transition
	 */
	def createCPTransitionRule() {
		// a transition is added
		val IMatchProcessor<TransitionMatch> processorAdd = [
			val transition = it.t
			
			val hyperEdge = stf.createHyperEdge()
			hyperEdge.name = transition.name
			hyperEdge.moveTo(stateChartResource.contents)
			createTrace(transition, hyperEdge)
			
			doAllSnapshot("NewTransition")
		]
		
		// a transition is deleted
		val IMatchProcessor<TransitionMatch> processorDelete = [
			val transition = it.t
			
			val hyperEdge = equiv(transition)
			stateChartResource.contents.remove(hyperEdge)
			removeTrace(transition)
			
			doAllSnapshot("DeleteTransition")
		]
		
		// a transition's name is updated
		val IMatchProcessor<TransitionMatch> processorUpdate = [
			val transition = it.t
			
			val hyperEdge = equiv(transition)
			hyperEdge.name = transition.name
			
			doAllSnapshot("UpdateTransition")
		]
		
		newSimpleMatcherRuleSpecification(TransitionMatcher::factory,
			DefaultActivationLifeCycle::DEFAULT,
			newHashSet( EnableableJob::newEnableableJob(ActivationState::APPEARED, processorAdd), 
						EnableableJob::newEnableableJob(ActivationState::DISAPPEARED, processorDelete),
						EnableableJob::newEnableableJob(ActivationState::UPDATED, processorUpdate)
			))
		
	}
	
	/*
	 * Change propagation of a place --> transition connection
	 */
	def createCPPlaceToTransitionRule() {
		// a P->T connection is created
		val IMatchProcessor<PostTMatch> processorAdd = [
			val place = it.p
			val transition = it.t
			
			val basic = equiv(place)
			val hyperEdge = equiv(transition)
			
			basic.next += hyperEdge
			
			doAllSnapshot("CP_PT_added")
		]
		
		// a P->T connection is deleted
		val IMatchProcessor<PostTMatch> processorRemove = [
			val place = it.p
			val transition = it.t
			
			val basic = equiv(place)
			val hyperEdge = equiv(transition)
			
			basic.next.remove(hyperEdge)
			
			doAllSnapshot("CP_PT_removed")
		]
		
		newSimpleMatcherRuleSpecification(PostTMatcher::factory,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE,
			newHashSet(newStatelessJob(ActivationState::APPEARED, processorAdd),
				       newStatelessJob(ActivationState::DISAPPEARED, processorRemove)
			))
	}
	
	/*
	 * Change propagation of a transition --> place connection
	 */
	def createCPTransitionToPlaceRule() {
		// a T->P connection is created
		val IMatchProcessor<PreTMatch> processorAdd = [
			val place = it.p
			val transition = it.t
			
			val basic = equiv(place)
			val hyperEdge = equiv(transition)
			
			hyperEdge.next += basic
			
			doAllSnapshot("CP_TP_added")
		]
		
		// a T->P connection is deleted
		val IMatchProcessor<PreTMatch> processorRemove = [
			val place = it.p
			val transition = it.t
			
			val basic = equiv(place)
			val hyperEdge = equiv(transition)
			
			hyperEdge.next.remove(basic)
			
			doAllSnapshot("CP_TP_removed")
		]
		
		newSimpleMatcherRuleSpecification(PreTMatcher::factory,
			DefaultActivationLifeCycle::DEFAULT_NO_UPDATE,
			newHashSet(newStatelessJob(ActivationState::APPEARED, processorAdd),
				       newStatelessJob(ActivationState::DISAPPEARED, processorRemove)
			))
	}
	
	def getCPRules() {
		newHashSet(
			createCPPlaceRule() as RuleSpecification<? extends IPatternMatch>,
			createCPTransitionRule() as RuleSpecification<? extends IPatternMatch>,
			createCPPlaceToTransitionRule() as RuleSpecification<? extends IPatternMatch>,
			createCPTransitionToPlaceRule() as RuleSpecification<? extends IPatternMatch>
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