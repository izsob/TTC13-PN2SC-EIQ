package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.PreTMatcher;

/**
 * A pattern-specific query specification that can instantiate PreTMatcher in a type-safe way.
 * 
 * @see PreTMatcher
 * @see PreTMatch
 * 
 */
@SuppressWarnings("all")
public final class PreTQuerySpecification extends BaseGeneratedQuerySpecification<PreTMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PreTQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected PreTMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PreTMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.preT";
    
  }
  
  private PreTQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<PreTQuerySpecification> {
    @Override
    public PreTQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static PreTQuerySpecification INSTANCE = make();
    
    public static PreTQuerySpecification make() {
      try {
      	return new PreTQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
