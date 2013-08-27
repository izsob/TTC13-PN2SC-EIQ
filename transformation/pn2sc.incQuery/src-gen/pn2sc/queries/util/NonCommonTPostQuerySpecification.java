package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.NonCommonTPostMatcher;

/**
 * A pattern-specific query specification that can instantiate NonCommonTPostMatcher in a type-safe way.
 * 
 * @see NonCommonTPostMatcher
 * @see NonCommonTPostMatch
 * 
 */
@SuppressWarnings("all")
public final class NonCommonTPostQuerySpecification extends BaseGeneratedQuerySpecification<NonCommonTPostMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NonCommonTPostQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected NonCommonTPostMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NonCommonTPostMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.nonCommonTPost";
    
  }
  
  private NonCommonTPostQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<NonCommonTPostQuerySpecification> {
    @Override
    public NonCommonTPostQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static NonCommonTPostQuerySpecification INSTANCE = make();
    
    public static NonCommonTPostQuerySpecification make() {
      try {
      	return new NonCommonTPostQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
