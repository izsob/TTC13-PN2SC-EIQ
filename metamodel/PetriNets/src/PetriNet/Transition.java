/**
 */
package PetriNet;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link PetriNet.Transition#getPrep <em>Prep</em>}</li>
 *   <li>{@link PetriNet.Transition#getPostp <em>Postp</em>}</li>
 *   <li>{@link PetriNet.Transition#getCnet <em>Cnet</em>}</li>
 * </ul>
 * </p>
 *
 * @see PetriNet.PetriNetPackage#getTransition()
 * @model annotation="gmf.node label='name' figure='rectangle' color='0,0,0' size='15,50' label.placement='external'"
 * @generated
 */
public interface Transition extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Prep</b></em>' reference list.
	 * The list contents are of type {@link PetriNet.Place}.
	 * It is bidirectional and its opposite is '{@link PetriNet.Place#getPostt <em>Postt</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prep</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prep</em>' reference list.
	 * @see PetriNet.PetriNetPackage#getTransition_Prep()
	 * @see PetriNet.Place#getPostt
	 * @model opposite="postt"
	 * @generated
	 */
	EList<Place> getPrep();

	/**
	 * Returns the value of the '<em><b>Postp</b></em>' reference list.
	 * The list contents are of type {@link PetriNet.Place}.
	 * It is bidirectional and its opposite is '{@link PetriNet.Place#getPret <em>Pret</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postp</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postp</em>' reference list.
	 * @see PetriNet.PetriNetPackage#getTransition_Postp()
	 * @see PetriNet.Place#getPret
	 * @model opposite="pret"
	 *        annotation="gmf.link target.decoration='arrow'"
	 * @generated
	 */
	EList<Place> getPostp();

	/**
	 * Returns the value of the '<em><b>Cnet</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link PetriNet.Net#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cnet</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cnet</em>' container reference.
	 * @see #setCnet(Net)
	 * @see PetriNet.PetriNetPackage#getTransition_Cnet()
	 * @see PetriNet.Net#getTransitions
	 * @model opposite="transitions" required="true" transient="false"
	 * @generated
	 */
	Net getCnet();

	/**
	 * Sets the value of the '{@link PetriNet.Transition#getCnet <em>Cnet</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cnet</em>' container reference.
	 * @see #getCnet()
	 * @generated
	 */
	void setCnet(Net value);

} // Transition
