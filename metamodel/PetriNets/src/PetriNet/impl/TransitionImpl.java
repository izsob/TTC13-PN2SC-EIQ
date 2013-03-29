/**
 */
package PetriNet.impl;

import PetriNet.Net;
import PetriNet.PetriNetPackage;
import PetriNet.Place;
import PetriNet.Transition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link PetriNet.impl.TransitionImpl#getPrep <em>Prep</em>}</li>
 *   <li>{@link PetriNet.impl.TransitionImpl#getPostp <em>Postp</em>}</li>
 *   <li>{@link PetriNet.impl.TransitionImpl#getCnet <em>Cnet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends NamedElementImpl implements Transition {
	/**
	 * The cached value of the '{@link #getPrep() <em>Prep</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrep()
	 * @generated
	 * @ordered
	 */
	protected EList<Place> prep;

	/**
	 * The cached value of the '{@link #getPostp() <em>Postp</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostp()
	 * @generated
	 * @ordered
	 */
	protected EList<Place> postp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PetriNetPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Place> getPrep() {
		if (prep == null) {
			prep = new EObjectWithInverseResolvingEList.ManyInverse<Place>(Place.class, this, PetriNetPackage.TRANSITION__PREP, PetriNetPackage.PLACE__POSTT);
		}
		return prep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Place> getPostp() {
		if (postp == null) {
			postp = new EObjectWithInverseResolvingEList.ManyInverse<Place>(Place.class, this, PetriNetPackage.TRANSITION__POSTP, PetriNetPackage.PLACE__PRET);
		}
		return postp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Net getCnet() {
		if (eContainerFeatureID() != PetriNetPackage.TRANSITION__CNET) return null;
		return (Net)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCnet(Net newCnet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCnet, PetriNetPackage.TRANSITION__CNET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCnet(Net newCnet) {
		if (newCnet != eInternalContainer() || (eContainerFeatureID() != PetriNetPackage.TRANSITION__CNET && newCnet != null)) {
			if (EcoreUtil.isAncestor(this, newCnet))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCnet != null)
				msgs = ((InternalEObject)newCnet).eInverseAdd(this, PetriNetPackage.NET__TRANSITIONS, Net.class, msgs);
			msgs = basicSetCnet(newCnet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.TRANSITION__CNET, newCnet, newCnet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__PREP:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPrep()).basicAdd(otherEnd, msgs);
			case PetriNetPackage.TRANSITION__POSTP:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPostp()).basicAdd(otherEnd, msgs);
			case PetriNetPackage.TRANSITION__CNET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCnet((Net)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__PREP:
				return ((InternalEList<?>)getPrep()).basicRemove(otherEnd, msgs);
			case PetriNetPackage.TRANSITION__POSTP:
				return ((InternalEList<?>)getPostp()).basicRemove(otherEnd, msgs);
			case PetriNetPackage.TRANSITION__CNET:
				return basicSetCnet(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case PetriNetPackage.TRANSITION__CNET:
				return eInternalContainer().eInverseRemove(this, PetriNetPackage.NET__TRANSITIONS, Net.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__PREP:
				return getPrep();
			case PetriNetPackage.TRANSITION__POSTP:
				return getPostp();
			case PetriNetPackage.TRANSITION__CNET:
				return getCnet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__PREP:
				getPrep().clear();
				getPrep().addAll((Collection<? extends Place>)newValue);
				return;
			case PetriNetPackage.TRANSITION__POSTP:
				getPostp().clear();
				getPostp().addAll((Collection<? extends Place>)newValue);
				return;
			case PetriNetPackage.TRANSITION__CNET:
				setCnet((Net)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__PREP:
				getPrep().clear();
				return;
			case PetriNetPackage.TRANSITION__POSTP:
				getPostp().clear();
				return;
			case PetriNetPackage.TRANSITION__CNET:
				setCnet((Net)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__PREP:
				return prep != null && !prep.isEmpty();
			case PetriNetPackage.TRANSITION__POSTP:
				return postp != null && !postp.isEmpty();
			case PetriNetPackage.TRANSITION__CNET:
				return getCnet() != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
