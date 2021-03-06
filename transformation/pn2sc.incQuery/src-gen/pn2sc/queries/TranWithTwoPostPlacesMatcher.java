package pn2sc.queries;

import PetriNet.Place;
import PetriNet.Transition;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;
import pn2sc.queries.TranWithTwoPostPlacesMatch;
import pn2sc.queries.util.TranWithTwoPostPlacesQuerySpecification;

/**
 * Generated pattern matcher API of the pn2sc.queries.tranWithTwoPostPlaces pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TranWithTwoPostPlacesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern tranWithTwoPostPlaces(T:Transition, P1:Place, P2:Place) {
 * 	find preT(P1, T);
 * 	find preT(P2, T);
 * 	P1 != P2;
 * }
 * </pre></code>
 * 
 * @see TranWithTwoPostPlacesMatch
 * @see TranWithTwoPostPlacesProcessor
 * @see TranWithTwoPostPlacesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TranWithTwoPostPlacesMatcher extends BaseMatcher<TranWithTwoPostPlacesMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<TranWithTwoPostPlacesMatcher> querySpecification() throws IncQueryException {
    return TranWithTwoPostPlacesQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TranWithTwoPostPlacesMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    TranWithTwoPostPlacesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new TranWithTwoPostPlacesMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_T = 0;
  
  private final static int POSITION_P1 = 1;
  
  private final static int POSITION_P2 = 2;
  
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
  public TranWithTwoPostPlacesMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public TranWithTwoPostPlacesMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pP1 the fixed value of pattern parameter P1, or null if not bound.
   * @param pP2 the fixed value of pattern parameter P2, or null if not bound.
   * @return matches represented as a TranWithTwoPostPlacesMatch object.
   * 
   */
  public Collection<TranWithTwoPostPlacesMatch> getAllMatches(final Transition pT, final Place pP1, final Place pP2) {
    return rawGetAllMatches(new Object[]{pT, pP1, pP2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pP1 the fixed value of pattern parameter P1, or null if not bound.
   * @param pP2 the fixed value of pattern parameter P2, or null if not bound.
   * @return a match represented as a TranWithTwoPostPlacesMatch object, or null if no match is found.
   * 
   */
  public TranWithTwoPostPlacesMatch getOneArbitraryMatch(final Transition pT, final Place pP1, final Place pP2) {
    return rawGetOneArbitraryMatch(new Object[]{pT, pP1, pP2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pP1 the fixed value of pattern parameter P1, or null if not bound.
   * @param pP2 the fixed value of pattern parameter P2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Transition pT, final Place pP1, final Place pP2) {
    return rawHasMatch(new Object[]{pT, pP1, pP2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pP1 the fixed value of pattern parameter P1, or null if not bound.
   * @param pP2 the fixed value of pattern parameter P2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Transition pT, final Place pP1, final Place pP2) {
    return rawCountMatches(new Object[]{pT, pP1, pP2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pP1 the fixed value of pattern parameter P1, or null if not bound.
   * @param pP2 the fixed value of pattern parameter P2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Transition pT, final Place pP1, final Place pP2, final IMatchProcessor<? super TranWithTwoPostPlacesMatch> processor) {
    rawForEachMatch(new Object[]{pT, pP1, pP2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pP1 the fixed value of pattern parameter P1, or null if not bound.
   * @param pP2 the fixed value of pattern parameter P2, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Transition pT, final Place pP1, final Place pP2, final IMatchProcessor<? super TranWithTwoPostPlacesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pT, pP1, pP2}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pP1 the fixed value of pattern parameter P1, or null if not bound.
   * @param pP2 the fixed value of pattern parameter P2, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<TranWithTwoPostPlacesMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Transition pT, final Place pP1, final Place pP2) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pT, pP1, pP2});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pP1 the fixed value of pattern parameter P1, or null if not bound.
   * @param pP2 the fixed value of pattern parameter P2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TranWithTwoPostPlacesMatch newMatch(final Transition pT, final Place pP1, final Place pP2) {
    return new TranWithTwoPostPlacesMatch.Immutable(pT, pP1, pP2);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for T.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Transition> rawAccumulateAllValuesOfT(final Object[] parameters) {
    Set<Transition> results = new HashSet<Transition>();
    rawAccumulateAllValues(POSITION_T, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for T.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOfT() {
    return rawAccumulateAllValuesOfT(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOfT(final TranWithTwoPostPlacesMatch partialMatch) {
    return rawAccumulateAllValuesOfT(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOfT(final Place pP1, final Place pP2) {
    return rawAccumulateAllValuesOfT(new Object[]{null, pP1, pP2});
  }
  
  /**
   * Retrieve the set of values that occur in matches for P1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Place> rawAccumulateAllValuesOfP1(final Object[] parameters) {
    Set<Place> results = new HashSet<Place>();
    rawAccumulateAllValues(POSITION_P1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for P1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfP1() {
    return rawAccumulateAllValuesOfP1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for P1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfP1(final TranWithTwoPostPlacesMatch partialMatch) {
    return rawAccumulateAllValuesOfP1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for P1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfP1(final Transition pT, final Place pP2) {
    return rawAccumulateAllValuesOfP1(new Object[]{pT, null, pP2});
  }
  
  /**
   * Retrieve the set of values that occur in matches for P2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Place> rawAccumulateAllValuesOfP2(final Object[] parameters) {
    Set<Place> results = new HashSet<Place>();
    rawAccumulateAllValues(POSITION_P2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for P2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfP2() {
    return rawAccumulateAllValuesOfP2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for P2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfP2(final TranWithTwoPostPlacesMatch partialMatch) {
    return rawAccumulateAllValuesOfP2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for P2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfP2(final Transition pT, final Place pP1) {
    return rawAccumulateAllValuesOfP2(new Object[]{pT, pP1, null});
  }
  
  @Override
  protected TranWithTwoPostPlacesMatch tupleToMatch(final Tuple t) {
    try {
    	return new TranWithTwoPostPlacesMatch.Immutable((PetriNet.Transition) t.get(POSITION_T), (PetriNet.Place) t.get(POSITION_P1), (PetriNet.Place) t.get(POSITION_P2));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected TranWithTwoPostPlacesMatch arrayToMatch(final Object[] match) {
    try {
    	return new TranWithTwoPostPlacesMatch.Immutable((PetriNet.Transition) match[POSITION_T], (PetriNet.Place) match[POSITION_P1], (PetriNet.Place) match[POSITION_P2]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected TranWithTwoPostPlacesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new TranWithTwoPostPlacesMatch.Mutable((PetriNet.Transition) match[POSITION_T], (PetriNet.Place) match[POSITION_P1], (PetriNet.Place) match[POSITION_P2]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
}
