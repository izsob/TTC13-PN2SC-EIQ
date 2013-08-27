package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.HasRcontainsMatcher;

/**
 * A pattern-specific query specification that can instantiate HasRcontainsMatcher in a type-safe way.
 * 
 * @see HasRcontainsMatcher
 * @see HasRcontainsMatch
 * 
 */
@SuppressWarnings("all")
public final class HasRcontainsQuerySpecification extends BaseGeneratedQuerySpecification<HasRcontainsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static HasRcontainsQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected HasRcontainsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return HasRcontainsMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.hasRcontains";
    
  }
  
  private HasRcontainsQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<HasRcontainsQuerySpecification> {
    @Override
    public HasRcontainsQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static HasRcontainsQuerySpecification INSTANCE = make();
    
    public static HasRcontainsQuerySpecification make() {
      try {
      	return new HasRcontainsQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
