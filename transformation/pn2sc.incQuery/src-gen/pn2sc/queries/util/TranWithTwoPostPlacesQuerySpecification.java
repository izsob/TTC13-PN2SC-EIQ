package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.TranWithTwoPostPlacesMatcher;

/**
 * A pattern-specific query specification that can instantiate TranWithTwoPostPlacesMatcher in a type-safe way.
 * 
 * @see TranWithTwoPostPlacesMatcher
 * @see TranWithTwoPostPlacesMatch
 * 
 */
@SuppressWarnings("all")
public final class TranWithTwoPostPlacesQuerySpecification extends BaseGeneratedQuerySpecification<TranWithTwoPostPlacesMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TranWithTwoPostPlacesQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TranWithTwoPostPlacesMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TranWithTwoPostPlacesMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.tranWithTwoPostPlaces";
    
  }
  
  private TranWithTwoPostPlacesQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<TranWithTwoPostPlacesQuerySpecification> {
    @Override
    public TranWithTwoPostPlacesQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static TranWithTwoPostPlacesQuerySpecification INSTANCE = make();
    
    public static TranWithTwoPostPlacesQuerySpecification make() {
      try {
      	return new TranWithTwoPostPlacesQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
