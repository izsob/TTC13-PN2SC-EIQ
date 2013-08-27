package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.EquivMatcher;

/**
 * A pattern-specific query specification that can instantiate EquivMatcher in a type-safe way.
 * 
 * @see EquivMatcher
 * @see EquivMatch
 * 
 */
@SuppressWarnings("all")
public final class EquivQuerySpecification extends BaseGeneratedQuerySpecification<EquivMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EquivQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EquivMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EquivMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.equiv";
    
  }
  
  private EquivQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<EquivQuerySpecification> {
    @Override
    public EquivQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static EquivQuerySpecification INSTANCE = make();
    
    public static EquivQuerySpecification make() {
      try {
      	return new EquivQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
