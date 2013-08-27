package pn2sc.queries.util;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the pn2sc.queries.andPrecond pattern.
 */
@SuppressWarnings("all")
public class AndPrecondEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer countPrePlaces) {
    boolean _greaterEqualsThan = ((countPrePlaces).intValue() >= 2);
    return Boolean.valueOf(_greaterEqualsThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int countPrePlacesPosition = tupleNameMap.get("countPrePlaces");
    java.lang.Integer countPrePlaces = (java.lang.Integer) tuple.get(countPrePlacesPosition);
    return evaluateXExpressionGenerated(countPrePlaces);
  }
}
