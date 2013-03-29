/**
 */
package PetriNet;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link PetriNet.Place#getPostt <em>Postt</em>}</li>
 *   <li>{@link PetriNet.Place#getPret <em>Pret</em>}</li>
 *   <li>{@link PetriNet.Place#getCnet <em>Cnet</em>}</li>
 * </ul>
 * </p>
 *
 * @see PetriNet.PetriNetPackage#getPlace()
 * @model annotation="gmf.node label='name' figure='ellipse'"
 * @generated
 */
public interface Place extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Postt</b></em>' reference list.
	 * The list contents are of type {@link PetriNet.Transition}.
	 * It is bidirectional and its opposite is '{@link PetriNet.Transition#getPrep <em>Prep</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postt</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postt</em>' reference list.
	 * @see PetriNet.PetriNetPackage#getPlace_Postt()
	 * @see PetriNet.Transition#getPrep
	 * @model opposite="prep"
	 *        annotation="gmf.link target.decoration='arrow'"
	 * @generated
	 */
	EList<Transition> getPostt();

	/**
	 * Returns the value of the '<em><b>Pret</b></em>' reference list.
	 * The list contents are of type {@link PetriNet.Transition}.
	 * It is bidirectional and its opposite is '{@link PetriNet.Transition#getPostp <em>Postp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pret</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pret</em>' reference list.
	 * @see PetriNet.PetriNetPackage#getPlace_Pret()
	 * @see PetriNet.Transition#getPostp
	 * @model opposite="postp"
	 * @generated
	 */
	EList<Transition> getPret();

	/**
	 * Returns the value of the '<em><b>Cnet</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link PetriNet.Net#getPlaces <em>Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cnet</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cnet</em>' container reference.
	 * @see #setCnet(Net)
	 * @see PetriNet.PetriNetPackage#getPlace_Cnet()
	 * @see PetriNet.Net#getPlaces
	 * @model opposite="places" required="true" transient="false"
	 * @generated
	 */
	Net getCnet();

	/**
	 * Sets the value of the '{@link PetriNet.Place#getCnet <em>Cnet</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cnet</em>' container reference.
	 * @see #getCnet()
	 * @generated
	 */
	void setCnet(Net value);

} // Place
