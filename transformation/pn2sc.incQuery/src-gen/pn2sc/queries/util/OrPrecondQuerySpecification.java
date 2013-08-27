package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.OrPrecondMatcher;

/**
 * A pattern-specific query specification that can instantiate OrPrecondMatcher in a type-safe way.
 * 
 * @see OrPrecondMatcher
 * @see OrPrecondMatch
 * 
 */
@SuppressWarnings("all")
public final class OrPrecondQuerySpecification extends BaseGeneratedQuerySpecification<OrPrecondMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OrPrecondQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected OrPrecondMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OrPrecondMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.orPrecond";
    
  }
  
  private OrPrecondQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<OrPrecondQuerySpecification> {
    @Override
    public OrPrecondQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static OrPrecondQuerySpecification INSTANCE = make();
    
    public static OrPrecondQuerySpecification make() {
      try {
      	return new OrPrecondQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
