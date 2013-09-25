package pn2sc.queries;

import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import pn2sc.queries.AndPrecondMatcher;
import pn2sc.queries.CommonPostTMatcher;
import pn2sc.queries.CommonPreTMatcher;
import pn2sc.queries.EmptyOrMatcher;
import pn2sc.queries.EquivContainsMatcher;
import pn2sc.queries.EquivMatcher;
import pn2sc.queries.HasContainsMatcher;
import pn2sc.queries.HasRcontainsMatcher;
import pn2sc.queries.MoreThanOnePostPlaceMatcher;
import pn2sc.queries.MoreThanOnePrePlaceMatcher;
import pn2sc.queries.NextStateMatcher;
import pn2sc.queries.NonCommonTPostMatcher;
import pn2sc.queries.NonCommonTPreMatcher;
import pn2sc.queries.OrPrecondMatcher;
import pn2sc.queries.PlaceMatcher;
import pn2sc.queries.PostTMatcher;
import pn2sc.queries.PrePostPlacesMatcher;
import pn2sc.queries.PreTMatcher;
import pn2sc.queries.RootOrMatcher;
import pn2sc.queries.SingleRootOrMatcher;
import pn2sc.queries.TopOrMatcher;
import pn2sc.queries.TraceElementMatcher;
import pn2sc.queries.TranWithTwoPostPlacesMatcher;
import pn2sc.queries.TransitionMatcher;
import pn2sc.queries.TransitionWithTwoPrePlacesMatcher;
import pn2sc.queries.UniquePostPlaceMatcher;
import pn2sc.queries.UniquePrePlaceMatcher;

/**
 * A pattern group formed of all patterns defined in pn2sc.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare 
 * an EMF-IncQuery engine for matching all patterns originally defined in file pn2sc.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package pn2sc.queries, the group contains the definition of the following patterns: <ul>
 * <li>place</li>
 * <li>transition</li>
 * <li>nextState</li>
 * <li>equiv</li>
 * <li>equivContains</li>
 * <li>traceElement</li>
 * <li>andPrecond</li>
 * <li>nonCommonTPre</li>
 * <li>tranWithTwoPostPlaces</li>
 * <li>nonCommonTPost</li>
 * <li>transitionWithTwoPrePlaces</li>
 * <li>postT</li>
 * <li>preT</li>
 * <li>orPrecond</li>
 * <li>uniquePrePlace</li>
 * <li>moreThanOnePrePlace</li>
 * <li>uniquePostPlace</li>
 * <li>moreThanOnePostPlace</li>
 * <li>commonPreT</li>
 * <li>commonPostT</li>
 * <li>prePostPlaces</li>
 * <li>topOr</li>
 * <li>singleRootOr</li>
 * <li>rootOr</li>
 * <li>emptyOr</li>
 * <li>hasRcontains</li>
 * <li>hasContains</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Pn2sc extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Pn2sc instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Pn2sc();
    }
    return INSTANCE;
    
  }
  
  private static Pn2sc INSTANCE;
  
  private Pn2sc() throws IncQueryException {
    querySpecifications.add(EmptyOrMatcher.querySpecification());
    querySpecifications.add(PreTMatcher.querySpecification());
    querySpecifications.add(RootOrMatcher.querySpecification());
    querySpecifications.add(TransitionMatcher.querySpecification());
    querySpecifications.add(CommonPostTMatcher.querySpecification());
    querySpecifications.add(AndPrecondMatcher.querySpecification());
    querySpecifications.add(NonCommonTPostMatcher.querySpecification());
    querySpecifications.add(HasContainsMatcher.querySpecification());
    querySpecifications.add(TransitionWithTwoPrePlacesMatcher.querySpecification());
    querySpecifications.add(PlaceMatcher.querySpecification());
    querySpecifications.add(MoreThanOnePrePlaceMatcher.querySpecification());
    querySpecifications.add(EquivMatcher.querySpecification());
    querySpecifications.add(UniquePrePlaceMatcher.querySpecification());
    querySpecifications.add(EquivContainsMatcher.querySpecification());
    querySpecifications.add(SingleRootOrMatcher.querySpecification());
    querySpecifications.add(UniquePostPlaceMatcher.querySpecification());
    querySpecifications.add(TranWithTwoPostPlacesMatcher.querySpecification());
    querySpecifications.add(OrPrecondMatcher.querySpecification());
    querySpecifications.add(MoreThanOnePostPlaceMatcher.querySpecification());
    querySpecifications.add(PrePostPlacesMatcher.querySpecification());
    querySpecifications.add(TopOrMatcher.querySpecification());
    querySpecifications.add(NextStateMatcher.querySpecification());
    querySpecifications.add(PostTMatcher.querySpecification());
    querySpecifications.add(CommonPreTMatcher.querySpecification());
    querySpecifications.add(HasRcontainsMatcher.querySpecification());
    querySpecifications.add(NonCommonTPreMatcher.querySpecification());
    querySpecifications.add(TraceElementMatcher.querySpecification());
    
  }
}
