/**
 */
package statecharts.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import statecharts.AND;
import statecharts.Statechart;
import statecharts.StatechartsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statechart</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link statecharts.impl.StatechartImpl#getTopState <em>Top State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatechartImpl extends EObjectImpl implements Statechart {
	/**
	 * The cached value of the '{@link #getTopState() <em>Top State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopState()
	 * @generated
	 * @ordered
	 */
	protected AND topState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatechartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatechartsPackage.Literals.STATECHART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AND getTopState() {
		return topState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTopState(AND newTopState, NotificationChain msgs) {
		AND oldTopState = topState;
		topState = newTopState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatechartsPackage.STATECHART__TOP_STATE, oldTopState, newTopState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopState(AND newTopState) {
		if (newTopState != topState) {
			NotificationChain msgs = null;
			if (topState != null)
				msgs = ((InternalEObject)topState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatechartsPackage.STATECHART__TOP_STATE, null, msgs);
			if (newTopState != null)
				msgs = ((InternalEObject)newTopState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatechartsPackage.STATECHART__TOP_STATE, null, msgs);
			msgs = basicSetTopState(newTopState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatechartsPackage.STATECHART__TOP_STATE, newTopState, newTopState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatechartsPackage.STATECHART__TOP_STATE:
				return basicSetTopState(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatechartsPackage.STATECHART__TOP_STATE:
				return getTopState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StatechartsPackage.STATECHART__TOP_STATE:
				setTopState((AND)newValue);
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
			case StatechartsPackage.STATECHART__TOP_STATE:
				setTopState((AND)null);
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
			case StatechartsPackage.STATECHART__TOP_STATE:
				return topState != null;
		}
		return super.eIsSet(featureID);
	}

} //StatechartImpl
