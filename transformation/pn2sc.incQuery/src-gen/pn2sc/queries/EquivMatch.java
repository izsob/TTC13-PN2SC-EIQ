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
 * Pattern-specific match representation of the pn2sc.queries.equiv pattern, 
 * to be used in conjunction with {@link EquivMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EquivMatcher
 * @see EquivProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EquivMatch extends BasePatternMatch {
  private NamedElement fNamesElement;
  
  private State fState;
  
  private static List<String> parameterNames = makeImmutableList("namesElement", "state");
  
  private EquivMatch(final NamedElement pNamesElement, final State pState) {
    this.fNamesElement = pNamesElement;
    this.fState = pState;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("namesElement".equals(parameterName)) return this.fNamesElement;
    if ("state".equals(parameterName)) return this.fState;
    return null;
    
  }
  
  public NamedElement getNamesElement() {
    return this.fNamesElement;
    
  }
  
  public State getState() {
    return this.fState;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("namesElement".equals(parameterName) ) {
    	this.fNamesElement = (PetriNet.NamedElement) newValue;
    	return true;
    }
    if ("state".equals(parameterName) ) {
    	this.fState = (statecharts.State) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setNamesElement(final NamedElement pNamesElement) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fNamesElement = pNamesElement;
    
  }
  
  public void setState(final State pState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fState = pState;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.equiv";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return EquivMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fNamesElement, fState};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"namesElement\"=" + prettyPrintValue(fNamesElement) + ", ");
    result.append("\"state\"=" + prettyPrintValue(fState));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fNamesElement == null) ? 0 : fNamesElement.hashCode()); 
    result = prime * result + ((fState == null) ? 0 : fState.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EquivMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EquivMatch other = (EquivMatch) obj;
    if (fNamesElement == null) {if (other.fNamesElement != null) return false;}
    else if (!fNamesElement.equals(other.fNamesElement)) return false;
    if (fState == null) {if (other.fState != null) return false;}
    else if (!fState.equals(other.fState)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return EquivMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends EquivMatch {
    Mutable(final NamedElement pNamesElement, final State pState) {
      super(pNamesElement, pState);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends EquivMatch {
    Immutable(final NamedElement pNamesElement, final State pState) {
      super(pNamesElement, pState);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
