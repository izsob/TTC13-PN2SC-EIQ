package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.UniquePrePlaceMatcher;

/**
 * A pattern-specific query specification that can instantiate UniquePrePlaceMatcher in a type-safe way.
 * 
 * @see UniquePrePlaceMatcher
 * @see UniquePrePlaceMatch
 * 
 */
@SuppressWarnings("all")
public final class UniquePrePlaceQuerySpecification extends BaseGeneratedQuerySpecification<UniquePrePlaceMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UniquePrePlaceQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected UniquePrePlaceMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UniquePrePlaceMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.uniquePrePlace";
    
  }
  
  private UniquePrePlaceQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<UniquePrePlaceQuerySpecification> {
    @Override
    public UniquePrePlaceQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static UniquePrePlaceQuerySpecification INSTANCE = make();
    
    public static UniquePrePlaceQuerySpecification make() {
      try {
      	return new UniquePrePlaceQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
