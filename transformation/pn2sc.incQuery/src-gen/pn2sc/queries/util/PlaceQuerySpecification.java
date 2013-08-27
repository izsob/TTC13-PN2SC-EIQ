package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.PlaceMatcher;

/**
 * A pattern-specific query specification that can instantiate PlaceMatcher in a type-safe way.
 * 
 * @see PlaceMatcher
 * @see PlaceMatch
 * 
 */
@SuppressWarnings("all")
public final class PlaceQuerySpecification extends BaseGeneratedQuerySpecification<PlaceMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PlaceQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected PlaceMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PlaceMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.place";
    
  }
  
  private PlaceQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<PlaceQuerySpecification> {
    @Override
    public PlaceQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static PlaceQuerySpecification INSTANCE = make();
    
    public static PlaceQuerySpecification make() {
      try {
      	return new PlaceQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
