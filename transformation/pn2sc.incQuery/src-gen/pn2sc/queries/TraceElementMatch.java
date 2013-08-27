package pn2sc.queries;

import PetriNet.NamedElement;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import pn2sctrace.MapTrace;

/**
 * Pattern-specific match representation of the pn2sc.queries.traceElement pattern, 
 * to be used in conjunction with {@link TraceElementMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TraceElementMatcher
 * @see TraceElementProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TraceElementMatch extends BasePatternMatch {
  private NamedElement fSmElement;
  
  private MapTrace fTrace;
  
  private static List<String> parameterNames = makeImmutableList("SmElement", "Trace");
  
  private TraceElementMatch(final NamedElement pSmElement, final MapTrace pTrace) {
    this.fSmElement = pSmElement;
    this.fTrace = pTrace;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("SmElement".equals(parameterName)) return this.fSmElement;
    if ("Trace".equals(parameterName)) return this.fTrace;
    return null;
    
  }
  
  public NamedElement getSmElement() {
    return this.fSmElement;
    
  }
  
  public MapTrace getTrace() {
    return this.fTrace;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("SmElement".equals(parameterName) ) {
    	this.fSmElement = (PetriNet.NamedElement) newValue;
    	return true;
    }
    if ("Trace".equals(parameterName) ) {
    	this.fTrace = (pn2sctrace.MapTrace) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSmElement(final NamedElement pSmElement) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSmElement = pSmElement;
    
  }
  
  public void setTrace(final MapTrace pTrace) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTrace = pTrace;
    
  }
  
  @Override
  public String patternName() {
    return "pn2sc.queries.traceElement";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return TraceElementMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSmElement, fTrace};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"SmElement\"=" + prettyPrintValue(fSmElement) + ", ");
    result.append("\"Trace\"=" + prettyPrintValue(fTrace));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSmElement == null) ? 0 : fSmElement.hashCode()); 
    result = prime * result + ((fTrace == null) ? 0 : fTrace.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TraceElementMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TraceElementMatch other = (TraceElementMatch) obj;
    if (fSmElement == null) {if (other.fSmElement != null) return false;}
    else if (!fSmElement.equals(other.fSmElement)) return false;
    if (fTrace == null) {if (other.fTrace != null) return false;}
    else if (!fTrace.equals(other.fTrace)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return TraceElementMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends TraceElementMatch {
    Mutable(final NamedElement pSmElement, final MapTrace pTrace) {
      super(pSmElement, pTrace);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends TraceElementMatch {
    Immutable(final NamedElement pSmElement, final MapTrace pTrace) {
      super(pSmElement, pTrace);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
