package pn2sc.queries;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import statecharts.Compound;

/**
 * Pattern-specific match representation of the pn2sc.queries.hasContains pattern, 
 * to be used in conjunction with {@link HasContainsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see HasContainsMatcher
 * @see HasContainsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class HasContainsMatch extends BasePatternMatch {
  private Compound fFrom;
  
  private static List<String> parameterNames = makeImmutableList("from");
  
  private HasContainsMatch(final Compound pFrom) {
    this.fFrom = pFrom;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("from".equals(parameterName)) return this.fFrom;
    return null;
    
  }
  
  public Compound getFrom() {
    return this.fFrom;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("from".equals(parameterName) ) {
    	this.fFrom = (statecharts.Compound) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setFrom(final Compound pFrom) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fFrom = pFrom;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.hasContains";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return HasContainsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fFrom};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"from\"=" + prettyPrintValue(fFrom));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fFrom == null) ? 0 : fFrom.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof HasContainsMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    HasContainsMatch other = (HasContainsMatch) obj;
    if (fFrom == null) {if (other.fFrom != null) return false;}
    else if (!fFrom.equals(other.fFrom)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return HasContainsMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends HasContainsMatch {
    Mutable(final Compound pFrom) {
      super(pFrom);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends HasContainsMatch {
    Immutable(final Compound pFrom) {
      super(pFrom);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
