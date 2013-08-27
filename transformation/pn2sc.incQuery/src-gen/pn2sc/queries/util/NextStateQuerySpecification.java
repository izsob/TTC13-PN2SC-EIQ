package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.NextStateMatcher;

/**
 * A pattern-specific query specification that can instantiate NextStateMatcher in a type-safe way.
 * 
 * @see NextStateMatcher
 * @see NextStateMatch
 * 
 */
@SuppressWarnings("all")
public final class NextStateQuerySpecification extends BaseGeneratedQuerySpecification<NextStateMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NextStateQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected NextStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NextStateMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.nextState";
    
  }
  
  private NextStateQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<NextStateQuerySpecification> {
    @Override
    public NextStateQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static NextStateQuerySpecification INSTANCE = make();
    
    public static NextStateQuerySpecification make() {
      try {
      	return new NextStateQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
