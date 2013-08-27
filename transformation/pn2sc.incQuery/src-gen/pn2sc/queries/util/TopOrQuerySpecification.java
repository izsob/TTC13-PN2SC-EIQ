package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.TopOrMatcher;

/**
 * A pattern-specific query specification that can instantiate TopOrMatcher in a type-safe way.
 * 
 * @see TopOrMatcher
 * @see TopOrMatch
 * 
 */
@SuppressWarnings("all")
public final class TopOrQuerySpecification extends BaseGeneratedQuerySpecification<TopOrMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TopOrQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TopOrMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TopOrMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.topOr";
    
  }
  
  private TopOrQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<TopOrQuerySpecification> {
    @Override
    public TopOrQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static TopOrQuerySpecification INSTANCE = make();
    
    public static TopOrQuerySpecification make() {
      try {
      	return new TopOrQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
