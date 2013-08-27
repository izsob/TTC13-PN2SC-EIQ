package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.SingleRootOrMatcher;

/**
 * A pattern-specific query specification that can instantiate SingleRootOrMatcher in a type-safe way.
 * 
 * @see SingleRootOrMatcher
 * @see SingleRootOrMatch
 * 
 */
@SuppressWarnings("all")
public final class SingleRootOrQuerySpecification extends BaseGeneratedQuerySpecification<SingleRootOrMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SingleRootOrQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected SingleRootOrMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SingleRootOrMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.singleRootOr";
    
  }
  
  private SingleRootOrQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<SingleRootOrQuerySpecification> {
    @Override
    public SingleRootOrQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static SingleRootOrQuerySpecification INSTANCE = make();
    
    public static SingleRootOrQuerySpecification make() {
      try {
      	return new SingleRootOrQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
