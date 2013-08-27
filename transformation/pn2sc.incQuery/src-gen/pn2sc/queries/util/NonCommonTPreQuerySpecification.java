package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.NonCommonTPreMatcher;

/**
 * A pattern-specific query specification that can instantiate NonCommonTPreMatcher in a type-safe way.
 * 
 * @see NonCommonTPreMatcher
 * @see NonCommonTPreMatch
 * 
 */
@SuppressWarnings("all")
public final class NonCommonTPreQuerySpecification extends BaseGeneratedQuerySpecification<NonCommonTPreMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NonCommonTPreQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected NonCommonTPreMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NonCommonTPreMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.nonCommonTPre";
    
  }
  
  private NonCommonTPreQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<NonCommonTPreQuerySpecification> {
    @Override
    public NonCommonTPreQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static NonCommonTPreQuerySpecification INSTANCE = make();
    
    public static NonCommonTPreQuerySpecification make() {
      try {
      	return new NonCommonTPreQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
