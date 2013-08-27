package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.EquivContainsMatcher;

/**
 * A pattern-specific query specification that can instantiate EquivContainsMatcher in a type-safe way.
 * 
 * @see EquivContainsMatcher
 * @see EquivContainsMatch
 * 
 */
@SuppressWarnings("all")
public final class EquivContainsQuerySpecification extends BaseGeneratedQuerySpecification<EquivContainsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EquivContainsQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EquivContainsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EquivContainsMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.equivContains";
    
  }
  
  private EquivContainsQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<EquivContainsQuerySpecification> {
    @Override
    public EquivContainsQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static EquivContainsQuerySpecification INSTANCE = make();
    
    public static EquivContainsQuerySpecification make() {
      try {
      	return new EquivContainsQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
