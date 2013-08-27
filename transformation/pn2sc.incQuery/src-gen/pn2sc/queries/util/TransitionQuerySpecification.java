package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.TransitionMatcher;

/**
 * A pattern-specific query specification that can instantiate TransitionMatcher in a type-safe way.
 * 
 * @see TransitionMatcher
 * @see TransitionMatch
 * 
 */
@SuppressWarnings("all")
public final class TransitionQuerySpecification extends BaseGeneratedQuerySpecification<TransitionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TransitionQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TransitionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TransitionMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.transition";
    
  }
  
  private TransitionQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<TransitionQuerySpecification> {
    @Override
    public TransitionQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static TransitionQuerySpecification INSTANCE = make();
    
    public static TransitionQuerySpecification make() {
      try {
      	return new TransitionQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
