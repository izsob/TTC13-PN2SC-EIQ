package pn2sc.queries;

import PetriNet.Place;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the pn2sc.queries.place pattern, 
 * to be used in conjunction with {@link PlaceMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PlaceMatcher
 * @see PlaceProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PlaceMatch extends BasePatternMatch {
  private Place fP;
  
  private static List<String> parameterNames = makeImmutableList("p");
  
  private PlaceMatch(final Place pP) {
    this.fP = pP;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("p".equals(parameterName)) return this.fP;
    return null;
    
  }
  
  public Place getP() {
    return this.fP;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("p".equals(parameterName) ) {
    	this.fP = (PetriNet.Place) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setP(final Place pP) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fP = pP;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.place";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return PlaceMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fP};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"p\"=" + prettyPrintValue(fP));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fP == null) ? 0 : fP.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PlaceMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    PlaceMatch other = (PlaceMatch) obj;
    if (fP == null) {if (other.fP != null) return false;}
    else if (!fP.equals(other.fP)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return PlaceMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends PlaceMatch {
    Mutable(final Place pP) {
      super(pP);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends PlaceMatch {
    Immutable(final Place pP) {
      super(pP);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
