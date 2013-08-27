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
 * Pattern-specific match representation of the pn2sc.queries.prePostPlaces pattern, 
 * to be used in conjunction with {@link PrePostPlacesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PrePostPlacesMatcher
 * @see PrePostPlacesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PrePostPlacesMatch extends BasePatternMatch {
  private Place fPrePlace;
  
  private Place fPostPlace;
  
  private Transition fT;
  
  private static List<String> parameterNames = makeImmutableList("PrePlace", "PostPlace", "T");
  
  private PrePostPlacesMatch(final Place pPrePlace, final Place pPostPlace, final Transition pT) {
    this.fPrePlace = pPrePlace;
    this.fPostPlace = pPostPlace;
    this.fT = pT;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("PrePlace".equals(parameterName)) return this.fPrePlace;
    if ("PostPlace".equals(parameterName)) return this.fPostPlace;
    if ("T".equals(parameterName)) return this.fT;
    return null;
    
  }
  
  public Place getPrePlace() {
    return this.fPrePlace;
    
  }
  
  public Place getPostPlace() {
    return this.fPostPlace;
    
  }
  
  public Transition getT() {
    return this.fT;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("PrePlace".equals(parameterName) ) {
    	this.fPrePlace = (PetriNet.Place) newValue;
    	return true;
    }
    if ("PostPlace".equals(parameterName) ) {
    	this.fPostPlace = (PetriNet.Place) newValue;
    	return true;
    }
    if ("T".equals(parameterName) ) {
    	this.fT = (PetriNet.Transition) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setPrePlace(final Place pPrePlace) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPrePlace = pPrePlace;
    
  }
  
  public void setPostPlace(final Place pPostPlace) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPostPlace = pPostPlace;
    
  }
  
  public void setT(final Transition pT) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT = pT;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.prePostPlaces";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return PrePostPlacesMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPrePlace, fPostPlace, fT};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"PrePlace\"=" + prettyPrintValue(fPrePlace) + ", ");
    result.append("\"PostPlace\"=" + prettyPrintValue(fPostPlace) + ", ");
    result.append("\"T\"=" + prettyPrintValue(fT));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPrePlace == null) ? 0 : fPrePlace.hashCode()); 
    result = prime * result + ((fPostPlace == null) ? 0 : fPostPlace.hashCode()); 
    result = prime * result + ((fT == null) ? 0 : fT.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PrePostPlacesMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    PrePostPlacesMatch other = (PrePostPlacesMatch) obj;
    if (fPrePlace == null) {if (other.fPrePlace != null) return false;}
    else if (!fPrePlace.equals(other.fPrePlace)) return false;
    if (fPostPlace == null) {if (other.fPostPlace != null) return false;}
    else if (!fPostPlace.equals(other.fPostPlace)) return false;
    if (fT == null) {if (other.fT != null) return false;}
    else if (!fT.equals(other.fT)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return PrePostPlacesMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends PrePostPlacesMatch {
    Mutable(final Place pPrePlace, final Place pPostPlace, final Transition pT) {
      super(pPrePlace, pPostPlace, pT);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends PrePostPlacesMatch {
    Immutable(final Place pPrePlace, final Place pPostPlace, final Transition pT) {
      super(pPrePlace, pPostPlace, pT);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
