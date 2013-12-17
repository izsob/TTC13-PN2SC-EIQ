package pn2sc.queries;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
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

@SuppressWarnings("all")
public final class Pn2scMatchers {
  private IncQueryEngine engine;
  
  public Pn2scMatchers(final IncQueryEngine engine) {
    this.engine = engine;
    
  }
  
  public HasRcontainsMatcher getHasRcontainsMatcher() throws IncQueryException {
    return HasRcontainsMatcher.on(engine);
  }
  
  public TransitionMatcher getTransitionMatcher() throws IncQueryException {
    return TransitionMatcher.on(engine);
  }
  
  public TransitionWithTwoPrePlacesMatcher getTransitionWithTwoPrePlacesMatcher() throws IncQueryException {
    return TransitionWithTwoPrePlacesMatcher.on(engine);
  }
  
  public AndPrecondMatcher getAndPrecondMatcher() throws IncQueryException {
    return AndPrecondMatcher.on(engine);
  }
  
  public EmptyOrMatcher getEmptyOrMatcher() throws IncQueryException {
    return EmptyOrMatcher.on(engine);
  }
  
  public PostTMatcher getPostTMatcher() throws IncQueryException {
    return PostTMatcher.on(engine);
  }
  
  public RootOrMatcher getRootOrMatcher() throws IncQueryException {
    return RootOrMatcher.on(engine);
  }
  
  public TraceElementMatcher getTraceElementMatcher() throws IncQueryException {
    return TraceElementMatcher.on(engine);
  }
  
  public UniquePrePlaceMatcher getUniquePrePlaceMatcher() throws IncQueryException {
    return UniquePrePlaceMatcher.on(engine);
  }
  
  public SingleRootOrMatcher getSingleRootOrMatcher() throws IncQueryException {
    return SingleRootOrMatcher.on(engine);
  }
  
  public PrePostPlacesMatcher getPrePostPlacesMatcher() throws IncQueryException {
    return PrePostPlacesMatcher.on(engine);
  }
  
  public TranWithTwoPostPlacesMatcher getTranWithTwoPostPlacesMatcher() throws IncQueryException {
    return TranWithTwoPostPlacesMatcher.on(engine);
  }
  
  public TopOrMatcher getTopOrMatcher() throws IncQueryException {
    return TopOrMatcher.on(engine);
  }
  
  public CommonPreTMatcher getCommonPreTMatcher() throws IncQueryException {
    return CommonPreTMatcher.on(engine);
  }
  
  public PreTMatcher getPreTMatcher() throws IncQueryException {
    return PreTMatcher.on(engine);
  }
  
  public NonCommonTPostMatcher getNonCommonTPostMatcher() throws IncQueryException {
    return NonCommonTPostMatcher.on(engine);
  }
  
  public NonCommonTPreMatcher getNonCommonTPreMatcher() throws IncQueryException {
    return NonCommonTPreMatcher.on(engine);
  }
  
  public MoreThanOnePrePlaceMatcher getMoreThanOnePrePlaceMatcher() throws IncQueryException {
    return MoreThanOnePrePlaceMatcher.on(engine);
  }
  
  public PlaceMatcher getPlaceMatcher() throws IncQueryException {
    return PlaceMatcher.on(engine);
  }
  
  public MoreThanOnePostPlaceMatcher getMoreThanOnePostPlaceMatcher() throws IncQueryException {
    return MoreThanOnePostPlaceMatcher.on(engine);
  }
  
  public HasContainsMatcher getHasContainsMatcher() throws IncQueryException {
    return HasContainsMatcher.on(engine);
  }
  
  public UniquePostPlaceMatcher getUniquePostPlaceMatcher() throws IncQueryException {
    return UniquePostPlaceMatcher.on(engine);
  }
  
  public EquivMatcher getEquivMatcher() throws IncQueryException {
    return EquivMatcher.on(engine);
  }
  
  public OrPrecondMatcher getOrPrecondMatcher() throws IncQueryException {
    return OrPrecondMatcher.on(engine);
  }
  
  public EquivContainsMatcher getEquivContainsMatcher() throws IncQueryException {
    return EquivContainsMatcher.on(engine);
  }
  
  public CommonPostTMatcher getCommonPostTMatcher() throws IncQueryException {
    return CommonPostTMatcher.on(engine);
  }
  
  public NextStateMatcher getNextStateMatcher() throws IncQueryException {
    return NextStateMatcher.on(engine);
  }
}
