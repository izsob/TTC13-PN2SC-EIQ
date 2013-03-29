/**
 */
package statecharts;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see statecharts.StatechartsFactory
 * @model kind="package"
 * @generated
 */
public interface StatechartsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "statecharts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://uam.es/StateCharts";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "schart";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatechartsPackage eINSTANCE = statecharts.impl.StatechartsPackageImpl.init();

	/**
	 * The meta object id for the '{@link statecharts.impl.StatechartImpl <em>Statechart</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see statecharts.impl.StatechartImpl
	 * @see statecharts.impl.StatechartsPackageImpl#getStatechart()
	 * @generated
	 */
	int STATECHART = 0;

	/**
	 * The feature id for the '<em><b>Top State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__TOP_STATE = 0;

	/**
	 * The number of structural features of the '<em>Statechart</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link statecharts.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see statecharts.impl.StateImpl
	 * @see statecharts.impl.StatechartsPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NEXT = 1;

	/**
	 * The feature id for the '<em><b>Rnext</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__RNEXT = 2;

	/**
	 * The feature id for the '<em><b>Rcontains</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__RCONTAINS = 3;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link statecharts.impl.HyperEdgeImpl <em>Hyper Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see statecharts.impl.HyperEdgeImpl
	 * @see statecharts.impl.StatechartsPackageImpl#getHyperEdge()
	 * @generated
	 */
	int HYPER_EDGE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPER_EDGE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPER_EDGE__NEXT = STATE__NEXT;

	/**
	 * The feature id for the '<em><b>Rnext</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPER_EDGE__RNEXT = STATE__RNEXT;

	/**
	 * The feature id for the '<em><b>Rcontains</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPER_EDGE__RCONTAINS = STATE__RCONTAINS;

	/**
	 * The number of structural features of the '<em>Hyper Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPER_EDGE_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link statecharts.impl.BasicImpl <em>Basic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see statecharts.impl.BasicImpl
	 * @see statecharts.impl.StatechartsPackageImpl#getBasic()
	 * @generated
	 */
	int BASIC = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC__NEXT = STATE__NEXT;

	/**
	 * The feature id for the '<em><b>Rnext</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC__RNEXT = STATE__RNEXT;

	/**
	 * The feature id for the '<em><b>Rcontains</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC__RCONTAINS = STATE__RCONTAINS;

	/**
	 * The number of structural features of the '<em>Basic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link statecharts.impl.CompoundImpl <em>Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see statecharts.impl.CompoundImpl
	 * @see statecharts.impl.StatechartsPackageImpl#getCompound()
	 * @generated
	 */
	int COMPOUND = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__NEXT = STATE__NEXT;

	/**
	 * The feature id for the '<em><b>Rnext</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__RNEXT = STATE__RNEXT;

	/**
	 * The feature id for the '<em><b>Rcontains</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__RCONTAINS = STATE__RCONTAINS;

	/**
	 * The feature id for the '<em><b>Contains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__CONTAINS = STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link statecharts.impl.ANDImpl <em>AND</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see statecharts.impl.ANDImpl
	 * @see statecharts.impl.StatechartsPackageImpl#getAND()
	 * @generated
	 */
	int AND = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__NAME = COMPOUND__NAME;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__NEXT = COMPOUND__NEXT;

	/**
	 * The feature id for the '<em><b>Rnext</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__RNEXT = COMPOUND__RNEXT;

	/**
	 * The feature id for the '<em><b>Rcontains</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__RCONTAINS = COMPOUND__RCONTAINS;

	/**
	 * The feature id for the '<em><b>Contains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__CONTAINS = COMPOUND__CONTAINS;

	/**
	 * The number of structural features of the '<em>AND</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = COMPOUND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link statecharts.impl.ORImpl <em>OR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see statecharts.impl.ORImpl
	 * @see statecharts.impl.StatechartsPackageImpl#getOR()
	 * @generated
	 */
	int OR = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__NAME = COMPOUND__NAME;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__NEXT = COMPOUND__NEXT;

	/**
	 * The feature id for the '<em><b>Rnext</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__RNEXT = COMPOUND__RNEXT;

	/**
	 * The feature id for the '<em><b>Rcontains</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__RCONTAINS = COMPOUND__RCONTAINS;

	/**
	 * The feature id for the '<em><b>Contains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__CONTAINS = COMPOUND__CONTAINS;

	/**
	 * The number of structural features of the '<em>OR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = COMPOUND_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link statecharts.Statechart <em>Statechart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statechart</em>'.
	 * @see statecharts.Statechart
	 * @generated
	 */
	EClass getStatechart();

	/**
	 * Returns the meta object for the containment reference '{@link statecharts.Statechart#getTopState <em>Top State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Top State</em>'.
	 * @see statecharts.Statechart#getTopState()
	 * @see #getStatechart()
	 * @generated
	 */
	EReference getStatechart_TopState();

	/**
	 * Returns the meta object for class '{@link statecharts.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see statecharts.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link statecharts.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see statecharts.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for the reference list '{@link statecharts.State#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Next</em>'.
	 * @see statecharts.State#getNext()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Next();

	/**
	 * Returns the meta object for the reference list '{@link statecharts.State#getRnext <em>Rnext</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rnext</em>'.
	 * @see statecharts.State#getRnext()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Rnext();

	/**
	 * Returns the meta object for the container reference '{@link statecharts.State#getRcontains <em>Rcontains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Rcontains</em>'.
	 * @see statecharts.State#getRcontains()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Rcontains();

	/**
	 * Returns the meta object for class '{@link statecharts.HyperEdge <em>Hyper Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hyper Edge</em>'.
	 * @see statecharts.HyperEdge
	 * @generated
	 */
	EClass getHyperEdge();

	/**
	 * Returns the meta object for class '{@link statecharts.Basic <em>Basic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic</em>'.
	 * @see statecharts.Basic
	 * @generated
	 */
	EClass getBasic();

	/**
	 * Returns the meta object for class '{@link statecharts.Compound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound</em>'.
	 * @see statecharts.Compound
	 * @generated
	 */
	EClass getCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link statecharts.Compound#getContains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains</em>'.
	 * @see statecharts.Compound#getContains()
	 * @see #getCompound()
	 * @generated
	 */
	EReference getCompound_Contains();

	/**
	 * Returns the meta object for class '{@link statecharts.AND <em>AND</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AND</em>'.
	 * @see statecharts.AND
	 * @generated
	 */
	EClass getAND();

	/**
	 * Returns the meta object for class '{@link statecharts.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OR</em>'.
	 * @see statecharts.OR
	 * @generated
	 */
	EClass getOR();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StatechartsFactory getStatechartsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link statecharts.impl.StatechartImpl <em>Statechart</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see statecharts.impl.StatechartImpl
		 * @see statecharts.impl.StatechartsPackageImpl#getStatechart()
		 * @generated
		 */
		EClass STATECHART = eINSTANCE.getStatechart();

		/**
		 * The meta object literal for the '<em><b>Top State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATECHART__TOP_STATE = eINSTANCE.getStatechart_TopState();

		/**
		 * The meta object literal for the '{@link statecharts.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see statecharts.impl.StateImpl
		 * @see statecharts.impl.StatechartsPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__NEXT = eINSTANCE.getState_Next();

		/**
		 * The meta object literal for the '<em><b>Rnext</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__RNEXT = eINSTANCE.getState_Rnext();

		/**
		 * The meta object literal for the '<em><b>Rcontains</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__RCONTAINS = eINSTANCE.getState_Rcontains();

		/**
		 * The meta object literal for the '{@link statecharts.impl.HyperEdgeImpl <em>Hyper Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see statecharts.impl.HyperEdgeImpl
		 * @see statecharts.impl.StatechartsPackageImpl#getHyperEdge()
		 * @generated
		 */
		EClass HYPER_EDGE = eINSTANCE.getHyperEdge();

		/**
		 * The meta object literal for the '{@link statecharts.impl.BasicImpl <em>Basic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see statecharts.impl.BasicImpl
		 * @see statecharts.impl.StatechartsPackageImpl#getBasic()
		 * @generated
		 */
		EClass BASIC = eINSTANCE.getBasic();

		/**
		 * The meta object literal for the '{@link statecharts.impl.CompoundImpl <em>Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see statecharts.impl.CompoundImpl
		 * @see statecharts.impl.StatechartsPackageImpl#getCompound()
		 * @generated
		 */
		EClass COMPOUND = eINSTANCE.getCompound();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND__CONTAINS = eINSTANCE.getCompound_Contains();

		/**
		 * The meta object literal for the '{@link statecharts.impl.ANDImpl <em>AND</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see statecharts.impl.ANDImpl
		 * @see statecharts.impl.StatechartsPackageImpl#getAND()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAND();

		/**
		 * The meta object literal for the '{@link statecharts.impl.ORImpl <em>OR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see statecharts.impl.ORImpl
		 * @see statecharts.impl.StatechartsPackageImpl#getOR()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOR();

	}

} //StatechartsPackage
