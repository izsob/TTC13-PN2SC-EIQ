package pn2sc.queries;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import statecharts.OR;

/**
 * Pattern-specific match representation of the pn2sc.queries.rootOr pattern, 
 * to be used in conjunction with {@link RootOrMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see RootOrMatcher
 * @see RootOrProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class RootOrMatch extends BasePatternMatch {
  private OR fRootOr;
  
  private static List<String> parameterNames = makeImmutableList("rootOr");
  
  private RootOrMatch(final OR pRootOr) {
    this.fRootOr = pRootOr;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("rootOr".equals(parameterName)) return this.fRootOr;
    return null;
    
  }
  
  public OR getRootOr() {
    return this.fRootOr;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("rootOr".equals(parameterName) ) {
    	this.fRootOr = (statecharts.OR) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setRootOr(final OR pRootOr) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRootOr = pRootOr;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.rootOr";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return RootOrMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRootOr};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"rootOr\"=" + prettyPrintValue(fRootOr));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRootOr == null) ? 0 : fRootOr.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof RootOrMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    RootOrMatch other = (RootOrMatch) obj;
    if (fRootOr == null) {if (other.fRootOr != null) return false;}
    else if (!fRootOr.equals(other.fRootOr)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return RootOrMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends RootOrMatch {
    Mutable(final OR pRootOr) {
      super(pRootOr);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends RootOrMatch {
    Immutable(final OR pRootOr) {
      super(pRootOr);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
