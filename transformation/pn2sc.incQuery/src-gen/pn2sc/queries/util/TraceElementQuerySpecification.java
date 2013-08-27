package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.TraceElementMatcher;

/**
 * A pattern-specific query specification that can instantiate TraceElementMatcher in a type-safe way.
 * 
 * @see TraceElementMatcher
 * @see TraceElementMatch
 * 
 */
@SuppressWarnings("all")
public final class TraceElementQuerySpecification extends BaseGeneratedQuerySpecification<TraceElementMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TraceElementQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TraceElementMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TraceElementMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.traceElement";
    
  }
  
  private TraceElementQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<TraceElementQuerySpecification> {
    @Override
    public TraceElementQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static TraceElementQuerySpecification INSTANCE = make();
    
    public static TraceElementQuerySpecification make() {
      try {
      	return new TraceElementQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
