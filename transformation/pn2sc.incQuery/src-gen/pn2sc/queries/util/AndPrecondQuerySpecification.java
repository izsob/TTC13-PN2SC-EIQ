package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.AndPrecondMatcher;

/**
 * A pattern-specific query specification that can instantiate AndPrecondMatcher in a type-safe way.
 * 
 * @see AndPrecondMatcher
 * @see AndPrecondMatch
 * 
 */
@SuppressWarnings("all")
public final class AndPrecondQuerySpecification extends BaseGeneratedQuerySpecification<AndPrecondMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AndPrecondQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected AndPrecondMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AndPrecondMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.andPrecond";
    
  }
  
  private AndPrecondQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<AndPrecondQuerySpecification> {
    @Override
    public AndPrecondQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static AndPrecondQuerySpecification INSTANCE = make();
    
    public static AndPrecondQuerySpecification make() {
      try {
      	return new AndPrecondQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
