package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.HasContainsMatcher;

/**
 * A pattern-specific query specification that can instantiate HasContainsMatcher in a type-safe way.
 * 
 * @see HasContainsMatcher
 * @see HasContainsMatch
 * 
 */
@SuppressWarnings("all")
public final class HasContainsQuerySpecification extends BaseGeneratedQuerySpecification<HasContainsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static HasContainsQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected HasContainsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return HasContainsMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.hasContains";
    
  }
  
  private HasContainsQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<HasContainsQuerySpecification> {
    @Override
    public HasContainsQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static HasContainsQuerySpecification INSTANCE = make();
    
    public static HasContainsQuerySpecification make() {
      try {
      	return new HasContainsQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
