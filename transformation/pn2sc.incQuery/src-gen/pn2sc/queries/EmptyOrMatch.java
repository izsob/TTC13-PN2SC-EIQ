package pn2sc.queries;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import statecharts.OR;

/**
 * Pattern-specific match representation of the pn2sc.queries.emptyOr pattern, 
 * to be used in conjunction with {@link EmptyOrMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EmptyOrMatcher
 * @see EmptyOrProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EmptyOrMatch extends BasePatternMatch {
  private OR fOrState;
  
  private static List<String> parameterNames = makeImmutableList("orState");
  
  private EmptyOrMatch(final OR pOrState) {
    this.fOrState = pOrState;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("orState".equals(parameterName)) return this.fOrState;
    return null;
    
  }
  
  public OR getOrState() {
    return this.fOrState;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("orState".equals(parameterName) ) {
    	this.fOrState = (statecharts.OR) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setOrState(final OR pOrState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOrState = pOrState;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.emptyOr";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return EmptyOrMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOrState};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"orState\"=" + prettyPrintValue(fOrState));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fOrState == null) ? 0 : fOrState.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EmptyOrMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EmptyOrMatch other = (EmptyOrMatch) obj;
    if (fOrState == null) {if (other.fOrState != null) return false;}
    else if (!fOrState.equals(other.fOrState)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return EmptyOrMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends EmptyOrMatch {
    Mutable(final OR pOrState) {
      super(pOrState);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends EmptyOrMatch {
    Immutable(final OR pOrState) {
      super(pOrState);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
