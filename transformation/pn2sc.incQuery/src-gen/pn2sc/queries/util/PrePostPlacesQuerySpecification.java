package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.PrePostPlacesMatcher;

/**
 * A pattern-specific query specification that can instantiate PrePostPlacesMatcher in a type-safe way.
 * 
 * @see PrePostPlacesMatcher
 * @see PrePostPlacesMatch
 * 
 */
@SuppressWarnings("all")
public final class PrePostPlacesQuerySpecification extends BaseGeneratedQuerySpecification<PrePostPlacesMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PrePostPlacesQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected PrePostPlacesMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PrePostPlacesMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.prePostPlaces";
    
  }
  
  private PrePostPlacesQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<PrePostPlacesQuerySpecification> {
    @Override
    public PrePostPlacesQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static PrePostPlacesQuerySpecification INSTANCE = make();
    
    public static PrePostPlacesQuerySpecification make() {
      try {
      	return new PrePostPlacesQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
