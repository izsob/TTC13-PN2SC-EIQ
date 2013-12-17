package pn2sc.queries;

import PetriNet.NamedElement;
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
import pn2sc.queries.TraceElementMatch;
import pn2sc.queries.util.TraceElementQuerySpecification;
import pn2sctrace.MapTrace;

/**
 * Generated pattern matcher API of the pn2sc.queries.traceElement pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TraceElementMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern traceElement(SmElement:NamedElement, Trace:MapTrace) {	
 * 	MapTrace.source(Trace,SmElement);
 * }
 * </pre></code>
 * 
 * @see TraceElementMatch
 * @see TraceElementProcessor
 * @see TraceElementQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TraceElementMatcher extends BaseMatcher<TraceElementMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<TraceElementMatcher> querySpecification() throws IncQueryException {
    return TraceElementQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TraceElementMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    TraceElementMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new TraceElementMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_SMELEMENT = 0;
  
  private final static int POSITION_TRACE = 1;
  
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
  public TraceElementMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public TraceElementMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSmElement the fixed value of pattern parameter SmElement, or null if not bound.
   * @param pTrace the fixed value of pattern parameter Trace, or null if not bound.
   * @return matches represented as a TraceElementMatch object.
   * 
   */
  public Collection<TraceElementMatch> getAllMatches(final NamedElement pSmElement, final MapTrace pTrace) {
    return rawGetAllMatches(new Object[]{pSmElement, pTrace});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSmElement the fixed value of pattern parameter SmElement, or null if not bound.
   * @param pTrace the fixed value of pattern parameter Trace, or null if not bound.
   * @return a match represented as a TraceElementMatch object, or null if no match is found.
   * 
   */
  public TraceElementMatch getOneArbitraryMatch(final NamedElement pSmElement, final MapTrace pTrace) {
    return rawGetOneArbitraryMatch(new Object[]{pSmElement, pTrace});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSmElement the fixed value of pattern parameter SmElement, or null if not bound.
   * @param pTrace the fixed value of pattern parameter Trace, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final NamedElement pSmElement, final MapTrace pTrace) {
    return rawHasMatch(new Object[]{pSmElement, pTrace});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSmElement the fixed value of pattern parameter SmElement, or null if not bound.
   * @param pTrace the fixed value of pattern parameter Trace, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final NamedElement pSmElement, final MapTrace pTrace) {
    return rawCountMatches(new Object[]{pSmElement, pTrace});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSmElement the fixed value of pattern parameter SmElement, or null if not bound.
   * @param pTrace the fixed value of pattern parameter Trace, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final NamedElement pSmElement, final MapTrace pTrace, final IMatchProcessor<? super TraceElementMatch> processor) {
    rawForEachMatch(new Object[]{pSmElement, pTrace}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSmElement the fixed value of pattern parameter SmElement, or null if not bound.
   * @param pTrace the fixed value of pattern parameter Trace, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final NamedElement pSmElement, final MapTrace pTrace, final IMatchProcessor<? super TraceElementMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSmElement, pTrace}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pSmElement the fixed value of pattern parameter SmElement, or null if not bound.
   * @param pTrace the fixed value of pattern parameter Trace, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<TraceElementMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final NamedElement pSmElement, final MapTrace pTrace) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pSmElement, pTrace});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSmElement the fixed value of pattern parameter SmElement, or null if not bound.
   * @param pTrace the fixed value of pattern parameter Trace, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TraceElementMatch newMatch(final NamedElement pSmElement, final MapTrace pTrace) {
    return new TraceElementMatch.Immutable(pSmElement, pTrace);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for SmElement.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<NamedElement> rawAccumulateAllValuesOfSmElement(final Object[] parameters) {
    Set<NamedElement> results = new HashSet<NamedElement>();
    rawAccumulateAllValues(POSITION_SMELEMENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for SmElement.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfSmElement() {
    return rawAccumulateAllValuesOfSmElement(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for SmElement.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfSmElement(final TraceElementMatch partialMatch) {
    return rawAccumulateAllValuesOfSmElement(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for SmElement.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfSmElement(final MapTrace pTrace) {
    return rawAccumulateAllValuesOfSmElement(new Object[]{null, pTrace});
  }
  
  /**
   * Retrieve the set of values that occur in matches for Trace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<MapTrace> rawAccumulateAllValuesOfTrace(final Object[] parameters) {
    Set<MapTrace> results = new HashSet<MapTrace>();
    rawAccumulateAllValues(POSITION_TRACE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Trace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<MapTrace> getAllValuesOfTrace() {
    return rawAccumulateAllValuesOfTrace(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Trace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<MapTrace> getAllValuesOfTrace(final TraceElementMatch partialMatch) {
    return rawAccumulateAllValuesOfTrace(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Trace.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<MapTrace> getAllValuesOfTrace(final NamedElement pSmElement) {
    return rawAccumulateAllValuesOfTrace(new Object[]{pSmElement, null});
  }
  
  @Override
  protected TraceElementMatch tupleToMatch(final Tuple t) {
    try {
    	return new TraceElementMatch.Immutable((PetriNet.NamedElement) t.get(POSITION_SMELEMENT), (pn2sctrace.MapTrace) t.get(POSITION_TRACE));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected TraceElementMatch arrayToMatch(final Object[] match) {
    try {
    	return new TraceElementMatch.Immutable((PetriNet.NamedElement) match[POSITION_SMELEMENT], (pn2sctrace.MapTrace) match[POSITION_TRACE]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected TraceElementMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new TraceElementMatch.Mutable((PetriNet.NamedElement) match[POSITION_SMELEMENT], (pn2sctrace.MapTrace) match[POSITION_TRACE]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
}
