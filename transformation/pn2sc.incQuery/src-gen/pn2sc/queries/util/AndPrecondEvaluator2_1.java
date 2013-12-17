package pn2sc.queries.util;

import com.google.common.collect.ImmutableList;
import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.matchers.psystem.IValueProvider;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the pn2sc.queries.andPrecond pattern.
 */
@SuppressWarnings("all")
public class AndPrecondEvaluator2_1 implements IMatchChecker {
  private ImmutableList<String> parameterNames = ImmutableList.of(
    "countPostPlaces"	
    );
    ;
  
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateGeneratedExpression(final Integer countPostPlaces) {
    boolean _greaterEqualsThan = ((countPostPlaces).intValue() >= 2);
    return Boolean.valueOf(_greaterEqualsThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  @Deprecated
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int countPostPlacesPosition = tupleNameMap.get("countPostPlaces");
    java.lang.Integer countPostPlaces = (java.lang.Integer) tuple.get(countPostPlacesPosition);
    return evaluateGeneratedExpression(countPostPlaces);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateExpression(final IValueProvider provider) {
    java.lang.Integer countPostPlaces = (java.lang.Integer) provider.getValue("countPostPlaces");
    return evaluateGeneratedExpression(countPostPlaces);
    
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Iterable<String> getInputParameterNames() {
    return parameterNames;
    
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public String getShortDescription() {
    return "XExpression 2_1 from Pattern andPrecond";
    
  }
}
