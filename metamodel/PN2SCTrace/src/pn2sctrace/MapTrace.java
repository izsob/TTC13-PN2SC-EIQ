/**
 */
package pn2sctrace;

import PetriNet.NamedElement;

import org.eclipse.emf.ecore.EObject;

import statecharts.State;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pn2sctrace.MapTrace#getSource <em>Source</em>}</li>
 *   <li>{@link pn2sctrace.MapTrace#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see pn2sctrace.Pn2sctracePackage#getMapTrace()
 * @model
 * @generated
 */
public interface MapTrace extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(NamedElement)
	 * @see pn2sctrace.Pn2sctracePackage#getMapTrace_Source()
	 * @model
	 * @generated
	 */
	NamedElement getSource();

	/**
	 * Sets the value of the '{@link pn2sctrace.MapTrace#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(State)
	 * @see pn2sctrace.Pn2sctracePackage#getMapTrace_Target()
	 * @model
	 * @generated
	 */
	State getTarget();

	/**
	 * Sets the value of the '{@link pn2sctrace.MapTrace#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(State value);

} // MapTrace
