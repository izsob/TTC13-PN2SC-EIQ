package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.MoreThanOnePrePlaceMatcher;

/**
 * A pattern-specific query specification that can instantiate MoreThanOnePrePlaceMatcher in a type-safe way.
 * 
 * @see MoreThanOnePrePlaceMatcher
 * @see MoreThanOnePrePlaceMatch
 * 
 */
@SuppressWarnings("all")
public final class MoreThanOnePrePlaceQuerySpecification extends BaseGeneratedQuerySpecification<MoreThanOnePrePlaceMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MoreThanOnePrePlaceQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected MoreThanOnePrePlaceMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MoreThanOnePrePlaceMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.moreThanOnePrePlace";
    
  }
  
  private MoreThanOnePrePlaceQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<MoreThanOnePrePlaceQuerySpecification> {
    @Override
    public MoreThanOnePrePlaceQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static MoreThanOnePrePlaceQuerySpecification INSTANCE = make();
    
    public static MoreThanOnePrePlaceQuerySpecification make() {
      try {
      	return new MoreThanOnePrePlaceQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
