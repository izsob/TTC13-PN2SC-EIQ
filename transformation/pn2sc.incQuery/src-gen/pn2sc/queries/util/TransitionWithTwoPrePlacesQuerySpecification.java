package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.TransitionWithTwoPrePlacesMatcher;

/**
 * A pattern-specific query specification that can instantiate TransitionWithTwoPrePlacesMatcher in a type-safe way.
 * 
 * @see TransitionWithTwoPrePlacesMatcher
 * @see TransitionWithTwoPrePlacesMatch
 * 
 */
@SuppressWarnings("all")
public final class TransitionWithTwoPrePlacesQuerySpecification extends BaseGeneratedQuerySpecification<TransitionWithTwoPrePlacesMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TransitionWithTwoPrePlacesQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TransitionWithTwoPrePlacesMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TransitionWithTwoPrePlacesMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.transitionWithTwoPrePlaces";
    
  }
  
  private TransitionWithTwoPrePlacesQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<TransitionWithTwoPrePlacesQuerySpecification> {
    @Override
    public TransitionWithTwoPrePlacesQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static TransitionWithTwoPrePlacesQuerySpecification INSTANCE = make();
    
    public static TransitionWithTwoPrePlacesQuerySpecification make() {
      try {
      	return new TransitionWithTwoPrePlacesQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
