/**
 */
package PetriNet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Net</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link PetriNet.Net#getPlaces <em>Places</em>}</li>
 *   <li>{@link PetriNet.Net#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see PetriNet.PetriNetPackage#getNet()
 * @model annotation="gmf.diagram foo='bar'"
 * @generated
 */
public interface Net extends EObject {
	/**
	 * Returns the value of the '<em><b>Places</b></em>' containment reference list.
	 * The list contents are of type {@link PetriNet.Place}.
	 * It is bidirectional and its opposite is '{@link PetriNet.Place#getCnet <em>Cnet</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Places</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Places</em>' containment reference list.
	 * @see PetriNet.PetriNetPackage#getNet_Places()
	 * @see PetriNet.Place#getCnet
	 * @model opposite="cnet" containment="true"
	 * @generated
	 */
	EList<Place> getPlaces();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link PetriNet.Transition}.
	 * It is bidirectional and its opposite is '{@link PetriNet.Transition#getCnet <em>Cnet</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see PetriNet.PetriNetPackage#getNet_Transitions()
	 * @see PetriNet.Transition#getCnet
	 * @model opposite="cnet" containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

} // Net
