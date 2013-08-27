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
import pn2sc.queries.PrePostPlacesMatch;
import pn2sc.queries.util.PrePostPlacesQuerySpecification;

/**
 * Generated pattern matcher API of the pn2sc.queries.prePostPlaces pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link PrePostPlacesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern prePostPlaces(PrePlace:Place, PostPlace:Place, T:Transition) {
 * 	Transition.prep(T, PrePlace);
 * 	Transition.postp(T, PostPlace);
 * 	PrePlace != PostPlace;
 * }
 * </pre></code>
 * 
 * @see PrePostPlacesMatch
 * @see PrePostPlacesProcessor
 * @see PrePostPlacesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class PrePostPlacesMatcher extends BaseMatcher<PrePostPlacesMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<PrePostPlacesMatcher> querySpecification() throws IncQueryException {
    return PrePostPlacesQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static PrePostPlacesMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    PrePostPlacesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new PrePostPlacesMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_PREPLACE = 0;
  
  private final static int POSITION_POSTPLACE = 1;
  
  private final static int POSITION_T = 2;
  
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
  public PrePostPlacesMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public PrePostPlacesMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPrePlace the fixed value of pattern parameter PrePlace, or null if not bound.
   * @param pPostPlace the fixed value of pattern parameter PostPlace, or null if not bound.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @return matches represented as a PrePostPlacesMatch object.
   * 
   */
  public Collection<PrePostPlacesMatch> getAllMatches(final Place pPrePlace, final Place pPostPlace, final Transition pT) {
    return rawGetAllMatches(new Object[]{pPrePlace, pPostPlace, pT});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPrePlace the fixed value of pattern parameter PrePlace, or null if not bound.
   * @param pPostPlace the fixed value of pattern parameter PostPlace, or null if not bound.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @return a match represented as a PrePostPlacesMatch object, or null if no match is found.
   * 
   */
  public PrePostPlacesMatch getOneArbitraryMatch(final Place pPrePlace, final Place pPostPlace, final Transition pT) {
    return rawGetOneArbitraryMatch(new Object[]{pPrePlace, pPostPlace, pT});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pPrePlace the fixed value of pattern parameter PrePlace, or null if not bound.
   * @param pPostPlace the fixed value of pattern parameter PostPlace, or null if not bound.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Place pPrePlace, final Place pPostPlace, final Transition pT) {
    return rawHasMatch(new Object[]{pPrePlace, pPostPlace, pT});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPrePlace the fixed value of pattern parameter PrePlace, or null if not bound.
   * @param pPostPlace the fixed value of pattern parameter PostPlace, or null if not bound.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Place pPrePlace, final Place pPostPlace, final Transition pT) {
    return rawCountMatches(new Object[]{pPrePlace, pPostPlace, pT});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pPrePlace the fixed value of pattern parameter PrePlace, or null if not bound.
   * @param pPostPlace the fixed value of pattern parameter PostPlace, or null if not bound.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Place pPrePlace, final Place pPostPlace, final Transition pT, final IMatchProcessor<? super PrePostPlacesMatch> processor) {
    rawForEachMatch(new Object[]{pPrePlace, pPostPlace, pT}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPrePlace the fixed value of pattern parameter PrePlace, or null if not bound.
   * @param pPostPlace the fixed value of pattern parameter PostPlace, or null if not bound.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Place pPrePlace, final Place pPostPlace, final Transition pT, final IMatchProcessor<? super PrePostPlacesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pPrePlace, pPostPlace, pT}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pPrePlace the fixed value of pattern parameter PrePlace, or null if not bound.
   * @param pPostPlace the fixed value of pattern parameter PostPlace, or null if not bound.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<PrePostPlacesMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Place pPrePlace, final Place pPostPlace, final Transition pT) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pPrePlace, pPostPlace, pT});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPrePlace the fixed value of pattern parameter PrePlace, or null if not bound.
   * @param pPostPlace the fixed value of pattern parameter PostPlace, or null if not bound.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public PrePostPlacesMatch newMatch(final Place pPrePlace, final Place pPostPlace, final Transition pT) {
    return new PrePostPlacesMatch.Immutable(pPrePlace, pPostPlace, pT);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for PrePlace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Place> rawAccumulateAllValuesOfPrePlace(final Object[] parameters) {
    Set<Place> results = new HashSet<Place>();
    rawAccumulateAllValues(POSITION_PREPLACE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for PrePlace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfPrePlace() {
    return rawAccumulateAllValuesOfPrePlace(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for PrePlace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfPrePlace(final PrePostPlacesMatch partialMatch) {
    return rawAccumulateAllValuesOfPrePlace(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for PrePlace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfPrePlace(final Place pPostPlace, final Transition pT) {
    return rawAccumulateAllValuesOfPrePlace(new Object[]{null, pPostPlace, pT});
  }
  
  /**
   * Retrieve the set of values that occur in matches for PostPlace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Place> rawAccumulateAllValuesOfPostPlace(final Object[] parameters) {
    Set<Place> results = new HashSet<Place>();
    rawAccumulateAllValues(POSITION_POSTPLACE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for PostPlace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfPostPlace() {
    return rawAccumulateAllValuesOfPostPlace(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for PostPlace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfPostPlace(final PrePostPlacesMatch partialMatch) {
    return rawAccumulateAllValuesOfPostPlace(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for PostPlace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Place> getAllValuesOfPostPlace(final Place pPrePlace, final Transition pT) {
    return rawAccumulateAllValuesOfPostPlace(new Object[]{pPrePlace, null, pT});
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
  public Set<Transition> getAllValuesOfT(final PrePostPlacesMatch partialMatch) {
    return rawAccumulateAllValuesOfT(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOfT(final Place pPrePlace, final Place pPostPlace) {
    return rawAccumulateAllValuesOfT(new Object[]{pPrePlace, pPostPlace, null});
  }
  
  @Override
  protected PrePostPlacesMatch tupleToMatch(final Tuple t) {
    try {
    	return new PrePostPlacesMatch.Immutable((PetriNet.Place) t.get(POSITION_PREPLACE), (PetriNet.Place) t.get(POSITION_POSTPLACE), (PetriNet.Transition) t.get(POSITION_T));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected PrePostPlacesMatch arrayToMatch(final Object[] match) {
    try {
    	return new PrePostPlacesMatch.Immutable((PetriNet.Place) match[POSITION_PREPLACE], (PetriNet.Place) match[POSITION_POSTPLACE], (PetriNet.Transition) match[POSITION_T]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected PrePostPlacesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new PrePostPlacesMatch.Mutable((PetriNet.Place) match[POSITION_PREPLACE], (PetriNet.Place) match[POSITION_POSTPLACE], (PetriNet.Transition) match[POSITION_T]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
}
