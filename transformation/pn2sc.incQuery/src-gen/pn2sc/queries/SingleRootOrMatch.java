package pn2sc.queries;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the pn2sc.queries.singleRootOr pattern, 
 * to be used in conjunction with {@link SingleRootOrMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SingleRootOrMatcher
 * @see SingleRootOrProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SingleRootOrMatch extends BasePatternMatch {
  private static List<String> parameterNames = makeImmutableList();
  
  private SingleRootOrMatch() {
    
  }
  
  @Override
  public Object get(final String parameterName) {
    return null;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    return false;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.singleRootOr";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return SingleRootOrMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{};
    
  }
  
  @Override
  public String prettyPrint() {
    return "[]";
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SingleRootOrMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return SingleRootOrMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends SingleRootOrMatch {
    Mutable() {
      super();
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends SingleRootOrMatch {
    Immutable() {
      super();
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
