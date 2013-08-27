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
 * Pattern-specific match representation of the pn2sc.queries.tranWithTwoPostPlaces pattern, 
 * to be used in conjunction with {@link TranWithTwoPostPlacesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TranWithTwoPostPlacesMatcher
 * @see TranWithTwoPostPlacesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TranWithTwoPostPlacesMatch extends BasePatternMatch {
  private Transition fT;
  
  private Place fP1;
  
  private Place fP2;
  
  private static List<String> parameterNames = makeImmutableList("T", "P1", "P2");
  
  private TranWithTwoPostPlacesMatch(final Transition pT, final Place pP1, final Place pP2) {
    this.fT = pT;
    this.fP1 = pP1;
    this.fP2 = pP2;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("T".equals(parameterName)) return this.fT;
    if ("P1".equals(parameterName)) return this.fP1;
    if ("P2".equals(parameterName)) return this.fP2;
    return null;
    
  }
  
  public Transition getT() {
    return this.fT;
    
  }
  
  public Place getP1() {
    return this.fP1;
    
  }
  
  public Place getP2() {
    return this.fP2;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("T".equals(parameterName) ) {
    	this.fT = (PetriNet.Transition) newValue;
    	return true;
    }
    if ("P1".equals(parameterName) ) {
    	this.fP1 = (PetriNet.Place) newValue;
    	return true;
    }
    if ("P2".equals(parameterName) ) {
    	this.fP2 = (PetriNet.Place) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setT(final Transition pT) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT = pT;
    
  }
  
  public void setP1(final Place pP1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fP1 = pP1;
    
  }
  
  public void setP2(final Place pP2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fP2 = pP2;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.tranWithTwoPostPlaces";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return TranWithTwoPostPlacesMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fT, fP1, fP2};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"T\"=" + prettyPrintValue(fT) + ", ");
    result.append("\"P1\"=" + prettyPrintValue(fP1) + ", ");
    result.append("\"P2\"=" + prettyPrintValue(fP2));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fT == null) ? 0 : fT.hashCode()); 
    result = prime * result + ((fP1 == null) ? 0 : fP1.hashCode()); 
    result = prime * result + ((fP2 == null) ? 0 : fP2.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TranWithTwoPostPlacesMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TranWithTwoPostPlacesMatch other = (TranWithTwoPostPlacesMatch) obj;
    if (fT == null) {if (other.fT != null) return false;}
    else if (!fT.equals(other.fT)) return false;
    if (fP1 == null) {if (other.fP1 != null) return false;}
    else if (!fP1.equals(other.fP1)) return false;
    if (fP2 == null) {if (other.fP2 != null) return false;}
    else if (!fP2.equals(other.fP2)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return TranWithTwoPostPlacesMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends TranWithTwoPostPlacesMatch {
    Mutable(final Transition pT, final Place pP1, final Place pP2) {
      super(pT, pP1, pP2);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends TranWithTwoPostPlacesMatch {
    Immutable(final Transition pT, final Place pP1, final Place pP2) {
      super(pT, pP1, pP2);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
