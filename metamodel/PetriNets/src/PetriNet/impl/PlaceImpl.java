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
 * An implementation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link PetriNet.impl.PlaceImpl#getPostt <em>Postt</em>}</li>
 *   <li>{@link PetriNet.impl.PlaceImpl#getPret <em>Pret</em>}</li>
 *   <li>{@link PetriNet.impl.PlaceImpl#getCnet <em>Cnet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlaceImpl extends NamedElementImpl implements Place {
	/**
	 * The cached value of the '{@link #getPostt() <em>Postt</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostt()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> postt;

	/**
	 * The cached value of the '{@link #getPret() <em>Pret</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPret()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> pret;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PetriNetPackage.Literals.PLACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getPostt() {
		if (postt == null) {
			postt = new EObjectWithInverseResolvingEList.ManyInverse<Transition>(Transition.class, this, PetriNetPackage.PLACE__POSTT, PetriNetPackage.TRANSITION__PREP);
		}
		return postt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getPret() {
		if (pret == null) {
			pret = new EObjectWithInverseResolvingEList.ManyInverse<Transition>(Transition.class, this, PetriNetPackage.PLACE__PRET, PetriNetPackage.TRANSITION__POSTP);
		}
		return pret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Net getCnet() {
		if (eContainerFeatureID() != PetriNetPackage.PLACE__CNET) return null;
		return (Net)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCnet(Net newCnet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCnet, PetriNetPackage.PLACE__CNET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCnet(Net newCnet) {
		if (newCnet != eInternalContainer() || (eContainerFeatureID() != PetriNetPackage.PLACE__CNET && newCnet != null)) {
			if (EcoreUtil.isAncestor(this, newCnet))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCnet != null)
				msgs = ((InternalEObject)newCnet).eInverseAdd(this, PetriNetPackage.NET__PLACES, Net.class, msgs);
			msgs = basicSetCnet(newCnet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.PLACE__CNET, newCnet, newCnet));
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
			case PetriNetPackage.PLACE__POSTT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPostt()).basicAdd(otherEnd, msgs);
			case PetriNetPackage.PLACE__PRET:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPret()).basicAdd(otherEnd, msgs);
			case PetriNetPackage.PLACE__CNET:
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
			case PetriNetPackage.PLACE__POSTT:
				return ((InternalEList<?>)getPostt()).basicRemove(otherEnd, msgs);
			case PetriNetPackage.PLACE__PRET:
				return ((InternalEList<?>)getPret()).basicRemove(otherEnd, msgs);
			case PetriNetPackage.PLACE__CNET:
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
			case PetriNetPackage.PLACE__CNET:
				return eInternalContainer().eInverseRemove(this, PetriNetPackage.NET__PLACES, Net.class, msgs);
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
			case PetriNetPackage.PLACE__POSTT:
				return getPostt();
			case PetriNetPackage.PLACE__PRET:
				return getPret();
			case PetriNetPackage.PLACE__CNET:
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
			case PetriNetPackage.PLACE__POSTT:
				getPostt().clear();
				getPostt().addAll((Collection<? extends Transition>)newValue);
				return;
			case PetriNetPackage.PLACE__PRET:
				getPret().clear();
				getPret().addAll((Collection<? extends Transition>)newValue);
				return;
			case PetriNetPackage.PLACE__CNET:
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
			case PetriNetPackage.PLACE__POSTT:
				getPostt().clear();
				return;
			case PetriNetPackage.PLACE__PRET:
				getPret().clear();
				return;
			case PetriNetPackage.PLACE__CNET:
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
			case PetriNetPackage.PLACE__POSTT:
				return postt != null && !postt.isEmpty();
			case PetriNetPackage.PLACE__PRET:
				return pret != null && !pret.isEmpty();
			case PetriNetPackage.PLACE__CNET:
				return getCnet() != null;
		}
		return super.eIsSet(featureID);
	}

} //PlaceImpl
