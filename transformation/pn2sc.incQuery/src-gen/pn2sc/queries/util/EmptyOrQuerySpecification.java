package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.EmptyOrMatcher;

/**
 * A pattern-specific query specification that can instantiate EmptyOrMatcher in a type-safe way.
 * 
 * @see EmptyOrMatcher
 * @see EmptyOrMatch
 * 
 */
@SuppressWarnings("all")
public final class EmptyOrQuerySpecification extends BaseGeneratedQuerySpecification<EmptyOrMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EmptyOrQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EmptyOrMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EmptyOrMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.emptyOr";
    
  }
  
  private EmptyOrQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<EmptyOrQuerySpecification> {
    @Override
    public EmptyOrQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static EmptyOrQuerySpecification INSTANCE = make();
    
    public static EmptyOrQuerySpecification make() {
      try {
      	return new EmptyOrQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
