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
public class AndPrecondEvaluator1_1 implements IMatchChecker {
  private ImmutableList<String> parameterNames = ImmutableList.of(
    "countPrePlaces"	
    );
    ;
  
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateGeneratedExpression(final Integer countPrePlaces) {
    boolean _greaterEqualsThan = ((countPrePlaces).intValue() >= 2);
    return Boolean.valueOf(_greaterEqualsThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  @Deprecated
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int countPrePlacesPosition = tupleNameMap.get("countPrePlaces");
    java.lang.Integer countPrePlaces = (java.lang.Integer) tuple.get(countPrePlacesPosition);
    return evaluateGeneratedExpression(countPrePlaces);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateExpression(final IValueProvider provider) {
    java.lang.Integer countPrePlaces = (java.lang.Integer) provider.getValue("countPrePlaces");
    return evaluateGeneratedExpression(countPrePlaces);
    
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
    return "XExpression 1_1 from Pattern andPrecond";
    
  }
}
