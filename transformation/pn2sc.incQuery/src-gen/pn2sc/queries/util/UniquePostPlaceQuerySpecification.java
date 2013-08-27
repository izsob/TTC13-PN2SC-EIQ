package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.UniquePostPlaceMatcher;

/**
 * A pattern-specific query specification that can instantiate UniquePostPlaceMatcher in a type-safe way.
 * 
 * @see UniquePostPlaceMatcher
 * @see UniquePostPlaceMatch
 * 
 */
@SuppressWarnings("all")
public final class UniquePostPlaceQuerySpecification extends BaseGeneratedQuerySpecification<UniquePostPlaceMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UniquePostPlaceQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected UniquePostPlaceMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UniquePostPlaceMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.uniquePostPlace";
    
  }
  
  private UniquePostPlaceQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<UniquePostPlaceQuerySpecification> {
    @Override
    public UniquePostPlaceQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static UniquePostPlaceQuerySpecification INSTANCE = make();
    
    public static UniquePostPlaceQuerySpecification make() {
      try {
      	return new UniquePostPlaceQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
