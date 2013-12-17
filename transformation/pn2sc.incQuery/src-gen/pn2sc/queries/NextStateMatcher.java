package pn2sc.queries;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import pn2sc.queries.NextStateMatch;
import pn2sc.queries.util.NextStateQuerySpecification;
import statecharts.State;

/**
 * Generated pattern matcher API of the pn2sc.queries.nextState pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NextStateMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern nextState(State1, State2) {
 * 	// P --postt--{@literal >} T
 * 	Place.postt(P,T);
 * 	
 * 	// state1 is the state, contained by the mapped OR of place 
 * 	find equivContains(P, State1);
 * 	
 * 	// state2 is the the mapped hyperedge of the transition
 * 	find equiv(T, State2);
 * }
 * or
 * {
 * 	// T --postp--{@literal >} P
 * 	Transition.postp(T,P);
 * 	
 * 	// state1 is the the mapped hyperedge of the transition
 * 	find equiv(T, State1);
 * 	
 * 	// state2 is the state, contained by the mapped OR of place 
 * 	find equivContains(P, State2);
 * }
 * </pre></code>
 * 
 * @see NextStateMatch
 * @see NextStateProcessor
 * @see NextStateQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NextStateMatcher extends BaseMatcher<NextStateMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<NextStateMatcher> querySpecification() throws IncQueryException {
    return NextStateQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NextStateMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    NextStateMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new NextStateMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_STATE1 = 0;
  
  private final static int POSITION_STATE2 = 1;
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet). 
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so 
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public NextStateMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public NextStateMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pState1 the fixed value of pattern parameter State1, or null if not bound.
   * @param pState2 the fixed value of pattern parameter State2, or null if not bound.
   * @return matches represented as a NextStateMatch object.
   * 
   */
  public Collection<NextStateMatch> getAllMatches(final State pState1, final State pState2) {
    return rawGetAllMatches(new Object[]{pState1, pState2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pState1 the fixed value of pattern parameter State1, or null if not bound.
   * @param pState2 the fixed value of pattern parameter State2, or null if not bound.
   * @return a match represented as a NextStateMatch object, or null if no match is found.
   * 
   */
  public NextStateMatch getOneArbitraryMatch(final State pState1, final State pState2) {
    return rawGetOneArbitraryMatch(new Object[]{pState1, pState2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pState1 the fixed value of pattern parameter State1, or null if not bound.
   * @param pState2 the fixed value of pattern parameter State2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final State pState1, final State pState2) {
    return rawHasMatch(new Object[]{pState1, pState2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pState1 the fixed value of pattern parameter State1, or null if not bound.
   * @param pState2 the fixed value of pattern parameter State2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final State pState1, final State pState2) {
    return rawCountMatches(new Object[]{pState1, pState2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pState1 the fixed value of pattern parameter State1, or null if not bound.
   * @param pState2 the fixed value of pattern parameter State2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final State pState1, final State pState2, final IMatchProcessor<? super NextStateMatch> processor) {
    rawForEachMatch(new Object[]{pState1, pState2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pState1 the fixed value of pattern parameter State1, or null if not bound.
   * @param pState2 the fixed value of pattern parameter State2, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final State pState1, final State pState2, final IMatchProcessor<? super NextStateMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pState1, pState2}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pState1 the fixed value of pattern parameter State1, or null if not bound.
   * @param pState2 the fixed value of pattern parameter State2, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<NextStateMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final State pState1, final State pState2) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pState1, pState2});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pState1 the fixed value of pattern parameter State1, or null if not bound.
   * @param pState2 the fixed value of pattern parameter State2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public NextStateMatch newMatch(final State pState1, final State pState2) {
    return new NextStateMatch.Immutable(pState1, pState2);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for State1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<State> rawAccumulateAllValuesOfState1(final Object[] parameters) {
    Set<State> results = new HashSet<State>();
    rawAccumulateAllValues(POSITION_STATE1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for State1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfState1() {
    return rawAccumulateAllValuesOfState1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for State1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfState1(final NextStateMatch partialMatch) {
    return rawAccumulateAllValuesOfState1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for State1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfState1(final State pState2) {
    return rawAccumulateAllValuesOfState1(new Object[]{null, pState2});
  }
  
  /**
   * Retrieve the set of values that occur in matches for State2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<State> rawAccumulateAllValuesOfState2(final Object[] parameters) {
    Set<State> results = new HashSet<State>();
    rawAccumulateAllValues(POSITION_STATE2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for State2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfState2() {
    return rawAccumulateAllValuesOfState2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for State2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfState2(final NextStateMatch partialMatch) {
    return rawAccumulateAllValuesOfState2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for State2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfState2(final State pState1) {
    return rawAccumulateAllValuesOfState2(new Object[]{pState1, null});
  }
  
  @Override
  protected NextStateMatch tupleToMatch(final Tuple t) {
    try {
    	return new NextStateMatch.Immutable((statecharts.State) t.get(POSITION_STATE1), (statecharts.State) t.get(POSITION_STATE2));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected NextStateMatch arrayToMatch(final Object[] match) {
    try {
    	return new NextStateMatch.Immutable((statecharts.State) match[POSITION_STATE1], (statecharts.State) match[POSITION_STATE2]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected NextStateMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new NextStateMatch.Mutable((statecharts.State) match[POSITION_STATE1], (statecharts.State) match[POSITION_STATE2]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
}
