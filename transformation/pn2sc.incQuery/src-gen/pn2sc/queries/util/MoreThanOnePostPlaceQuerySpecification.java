package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.MoreThanOnePostPlaceMatcher;

/**
 * A pattern-specific query specification that can instantiate MoreThanOnePostPlaceMatcher in a type-safe way.
 * 
 * @see MoreThanOnePostPlaceMatcher
 * @see MoreThanOnePostPlaceMatch
 * 
 */
@SuppressWarnings("all")
public final class MoreThanOnePostPlaceQuerySpecification extends BaseGeneratedQuerySpecification<MoreThanOnePostPlaceMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MoreThanOnePostPlaceQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected MoreThanOnePostPlaceMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MoreThanOnePostPlaceMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.moreThanOnePostPlace";
    
  }
  
  private MoreThanOnePostPlaceQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<MoreThanOnePostPlaceQuerySpecification> {
    @Override
    public MoreThanOnePostPlaceQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static MoreThanOnePostPlaceQuerySpecification INSTANCE = make();
    
    public static MoreThanOnePostPlaceQuerySpecification make() {
      try {
      	return new MoreThanOnePostPlaceQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
