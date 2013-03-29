/**
 */
package statecharts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link statecharts.State#getName <em>Name</em>}</li>
 *   <li>{@link statecharts.State#getNext <em>Next</em>}</li>
 *   <li>{@link statecharts.State#getRnext <em>Rnext</em>}</li>
 *   <li>{@link statecharts.State#getRcontains <em>Rcontains</em>}</li>
 * </ul>
 * </p>
 *
 * @see statecharts.StatechartsPackage#getState()
 * @model abstract="true"
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see statecharts.StatechartsPackage#getState_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link statecharts.State#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Next</b></em>' reference list.
	 * The list contents are of type {@link statecharts.State}.
	 * It is bidirectional and its opposite is '{@link statecharts.State#getRnext <em>Rnext</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next</em>' reference list.
	 * @see statecharts.StatechartsPackage#getState_Next()
	 * @see statecharts.State#getRnext
	 * @model opposite="rnext"
	 *        annotation="gmf.link source='src' target='trg' target.decoration='arrow' color='0,0,0'"
	 * @generated
	 */
	EList<State> getNext();

	/**
	 * Returns the value of the '<em><b>Rnext</b></em>' reference list.
	 * The list contents are of type {@link statecharts.State}.
	 * It is bidirectional and its opposite is '{@link statecharts.State#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rnext</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rnext</em>' reference list.
	 * @see statecharts.StatechartsPackage#getState_Rnext()
	 * @see statecharts.State#getNext
	 * @model opposite="next"
	 * @generated
	 */
	EList<State> getRnext();

	/**
	 * Returns the value of the '<em><b>Rcontains</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link statecharts.Compound#getContains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rcontains</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rcontains</em>' container reference.
	 * @see #setRcontains(Compound)
	 * @see statecharts.StatechartsPackage#getState_Rcontains()
	 * @see statecharts.Compound#getContains
	 * @model opposite="contains" transient="false"
	 * @generated
	 */
	Compound getRcontains();

	/**
	 * Sets the value of the '{@link statecharts.State#getRcontains <em>Rcontains</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rcontains</em>' container reference.
	 * @see #getRcontains()
	 * @generated
	 */
	void setRcontains(Compound value);

} // State
