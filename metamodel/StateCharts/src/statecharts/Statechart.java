/**
 */
package statecharts;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statechart</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link statecharts.Statechart#getTopState <em>Top State</em>}</li>
 * </ul>
 * </p>
 *
 * @see statecharts.StatechartsPackage#getStatechart()
 * @model annotation="gmf.diagram foo='bar' model.extension='statechart'"
 * @generated
 */
public interface Statechart extends EObject {
	/**
	 * Returns the value of the '<em><b>Top State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top State</em>' containment reference.
	 * @see #setTopState(AND)
	 * @see statecharts.StatechartsPackage#getStatechart_TopState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AND getTopState();

	/**
	 * Sets the value of the '{@link statecharts.Statechart#getTopState <em>Top State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top State</em>' containment reference.
	 * @see #getTopState()
	 * @generated
	 */
	void setTopState(AND value);

} // Statechart
