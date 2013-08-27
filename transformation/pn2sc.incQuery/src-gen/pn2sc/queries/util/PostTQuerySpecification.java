package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import pn2sc.queries.PostTMatcher;

/**
 * A pattern-specific query specification that can instantiate PostTMatcher in a type-safe way.
 * 
 * @see PostTMatcher
 * @see PostTMatch
 * 
 */
@SuppressWarnings("all")
public final class PostTQuerySpecification extends BaseGeneratedQuerySpecification<PostTMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PostTQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected PostTMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PostTMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "pn2sc.incQuery";
    
  }
  
  @Override
  protected String patternName() {
    return "pn2sc.queries.postT";
    
  }
  
  private PostTQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<PostTQuerySpecification> {
    @Override
    public PostTQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static PostTQuerySpecification INSTANCE = make();
    
    public static PostTQuerySpecification make() {
      try {
      	return new PostTQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
