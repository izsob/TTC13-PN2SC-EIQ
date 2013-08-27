package pn2sc.queries;

import PetriNet.Place;
import PetriNet.Transition;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the pn2sc.queries.postT pattern, 
 * to be used in conjunction with {@link PostTMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PostTMatcher
 * @see PostTProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PostTMatch extends BasePatternMatch {
  private Place fP;
  
  private Transition fT;
  
  private static List<String> parameterNames = makeImmutableList("P", "T");
  
  private PostTMatch(final Place pP, final Transition pT) {
    this.fP = pP;
    this.fT = pT;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("P".equals(parameterName)) return this.fP;
    if ("T".equals(parameterName)) return this.fT;
    return null;
    
  }
  
  public Place getP() {
    return this.fP;
    
  }
  
  public Transition getT() {
    return this.fT;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("P".equals(parameterName) ) {
    	this.fP = (PetriNet.Place) newValue;
    	return true;
    }
    if ("T".equals(parameterName) ) {
    	this.fT = (PetriNet.Transition) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setP(final Place pP) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fP = pP;
    
  }
  
  public void setT(final Transition pT) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT = pT;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.postT";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return PostTMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fP, fT};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"P\"=" + prettyPrintValue(fP) + ", ");
    result.append("\"T\"=" + prettyPrintValue(fT));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fP == null) ? 0 : fP.hashCode()); 
    result = prime * result + ((fT == null) ? 0 : fT.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PostTMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    PostTMatch other = (PostTMatch) obj;
    if (fP == null) {if (other.fP != null) return false;}
    else if (!fP.equals(other.fP)) return false;
    if (fT == null) {if (other.fT != null) return false;}
    else if (!fT.equals(other.fT)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return PostTMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends PostTMatch {
    Mutable(final Place pP, final Transition pT) {
      super(pP, pT);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends PostTMatch {
    Immutable(final Place pP, final Transition pT) {
      super(pP, pT);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
