package pn2sc.queries;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import statecharts.State;

/**
 * Pattern-specific match representation of the pn2sc.queries.nextState pattern, 
 * to be used in conjunction with {@link NextStateMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NextStateMatcher
 * @see NextStateProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NextStateMatch extends BasePatternMatch {
  private State fState1;
  
  private State fState2;
  
  private static List<String> parameterNames = makeImmutableList("State1", "State2");
  
  private NextStateMatch(final State pState1, final State pState2) {
    this.fState1 = pState1;
    this.fState2 = pState2;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("State1".equals(parameterName)) return this.fState1;
    if ("State2".equals(parameterName)) return this.fState2;
    return null;
    
  }
  
  public State getState1() {
    return this.fState1;
    
  }
  
  public State getState2() {
    return this.fState2;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("State1".equals(parameterName) ) {
    	this.fState1 = (statecharts.State) newValue;
    	return true;
    }
    if ("State2".equals(parameterName) ) {
    	this.fState2 = (statecharts.State) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setState1(final State pState1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fState1 = pState1;
    
  }
  
  public void setState2(final State pState2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fState2 = pState2;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.nextState";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return NextStateMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fState1, fState2};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"State1\"=" + prettyPrintValue(fState1) + ", ");
    result.append("\"State2\"=" + prettyPrintValue(fState2));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fState1 == null) ? 0 : fState1.hashCode()); 
    result = prime * result + ((fState2 == null) ? 0 : fState2.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof NextStateMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    NextStateMatch other = (NextStateMatch) obj;
    if (fState1 == null) {if (other.fState1 != null) return false;}
    else if (!fState1.equals(other.fState1)) return false;
    if (fState2 == null) {if (other.fState2 != null) return false;}
    else if (!fState2.equals(other.fState2)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return NextStateMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends NextStateMatch {
    Mutable(final State pState1, final State pState2) {
      super(pState1, pState2);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends NextStateMatch {
    Immutable(final State pState1, final State pState2) {
      super(pState1, pState2);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
