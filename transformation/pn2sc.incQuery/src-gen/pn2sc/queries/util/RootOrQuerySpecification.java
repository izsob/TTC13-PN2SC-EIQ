package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.RootOrMatcher;

/**
 * A pattern-specific query specification that can instantiate RootOrMatcher in a type-safe way.
 * 
 * @see RootOrMatcher
 * @see RootOrMatch
 * 
 */
@SuppressWarnings("all")
public final class RootOrQuerySpecification extends BaseGeneratedQuerySpecification<RootOrMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RootOrQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected RootOrMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RootOrMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.rootOr";
    
  }
  
  private RootOrQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<RootOrQuerySpecification> {
    @Override
    public RootOrQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static RootOrQuerySpecification INSTANCE = make();
    
    public static RootOrQuerySpecification make() {
      try {
      	return new RootOrQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
