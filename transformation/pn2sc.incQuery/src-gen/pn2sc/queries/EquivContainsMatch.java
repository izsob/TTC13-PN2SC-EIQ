package pn2sc.queries;

import PetriNet.NamedElement;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import statecharts.State;

/**
 * Pattern-specific match representation of the pn2sc.queries.equivContains pattern, 
 * to be used in conjunction with {@link EquivContainsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EquivContainsMatcher
 * @see EquivContainsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EquivContainsMatch extends BasePatternMatch {
  private NamedElement fNamedElement;
  
  private State fState;
  
  private static List<String> parameterNames = makeImmutableList("namedElement", "State");
  
  private EquivContainsMatch(final NamedElement pNamedElement, final State pState) {
    this.fNamedElement = pNamedElement;
    this.fState = pState;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("namedElement".equals(parameterName)) return this.fNamedElement;
    if ("State".equals(parameterName)) return this.fState;
    return null;
    
  }
  
  public NamedElement getNamedElement() {
    return this.fNamedElement;
    
  }
  
  public State getState() {
    return this.fState;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("namedElement".equals(parameterName) ) {
    	this.fNamedElement = (PetriNet.NamedElement) newValue;
    	return true;
    }
    if ("State".equals(parameterName) ) {
    	this.fState = (statecharts.State) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setNamedElement(final NamedElement pNamedElement) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fNamedElement = pNamedElement;
    
  }
  
  public void setState(final State pState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fState = pState;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.equivContains";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return EquivContainsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fNamedElement, fState};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"namedElement\"=" + prettyPrintValue(fNamedElement) + ", ");
    result.append("\"State\"=" + prettyPrintValue(fState));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fNamedElement == null) ? 0 : fNamedElement.hashCode()); 
    result = prime * result + ((fState == null) ? 0 : fState.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EquivContainsMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EquivContainsMatch other = (EquivContainsMatch) obj;
    if (fNamedElement == null) {if (other.fNamedElement != null) return false;}
    else if (!fNamedElement.equals(other.fNamedElement)) return false;
    if (fState == null) {if (other.fState != null) return false;}
    else if (!fState.equals(other.fState)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return EquivContainsMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends EquivContainsMatch {
    Mutable(final NamedElement pNamedElement, final State pState) {
      super(pNamedElement, pState);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends EquivContainsMatch {
    Immutable(final NamedElement pNamedElement, final State pState) {
      super(pNamedElement, pState);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
