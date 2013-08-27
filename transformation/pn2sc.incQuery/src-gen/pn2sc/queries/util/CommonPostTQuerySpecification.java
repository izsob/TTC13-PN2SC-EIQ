package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.CommonPostTMatcher;

/**
 * A pattern-specific query specification that can instantiate CommonPostTMatcher in a type-safe way.
 * 
 * @see CommonPostTMatcher
 * @see CommonPostTMatch
 * 
 */
@SuppressWarnings("all")
public final class CommonPostTQuerySpecification extends BaseGeneratedQuerySpecification<CommonPostTMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static CommonPostTQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected CommonPostTMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return CommonPostTMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.commonPostT";
    
  }
  
  private CommonPostTQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<CommonPostTQuerySpecification> {
    @Override
    public CommonPostTQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static CommonPostTQuerySpecification INSTANCE = make();
    
    public static CommonPostTQuerySpecification make() {
      try {
      	return new CommonPostTQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
