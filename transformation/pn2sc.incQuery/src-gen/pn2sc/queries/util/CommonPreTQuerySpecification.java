package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.CommonPreTMatcher;

/**
 * A pattern-specific query specification that can instantiate CommonPreTMatcher in a type-safe way.
 * 
 * @see CommonPreTMatcher
 * @see CommonPreTMatch
 * 
 */
@SuppressWarnings("all")
public final class CommonPreTQuerySpecification extends BaseGeneratedQuerySpecification<CommonPreTMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static CommonPreTQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected CommonPreTMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return CommonPreTMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.commonPreT";
    
  }
  
  private CommonPreTQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<CommonPreTQuerySpecification> {
    @Override
    public CommonPreTQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static CommonPreTQuerySpecification INSTANCE = make();
    
    public static CommonPreTQuerySpecification make() {
      try {
      	return new CommonPreTQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
