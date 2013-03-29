/**
 */
package pn2sctrace;

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
 * @see pn2sctrace.Pn2sctraceFactory
 * @model kind="package"
 * @generated
 */
public interface Pn2sctracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pn2sctrace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://pn2sctrace/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pn2sctrace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Pn2sctracePackage eINSTANCE = pn2sctrace.impl.Pn2sctracePackageImpl.init();

	/**
	 * The meta object id for the '{@link pn2sctrace.impl.PN2SCTracemodelImpl <em>PN2SC Tracemodel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pn2sctrace.impl.PN2SCTracemodelImpl
	 * @see pn2sctrace.impl.Pn2sctracePackageImpl#getPN2SCTracemodel()
	 * @generated
	 */
	int PN2SC_TRACEMODEL = 0;

	/**
	 * The feature id for the '<em><b>Contains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PN2SC_TRACEMODEL__CONTAINS = 0;

	/**
	 * The number of structural features of the '<em>PN2SC Tracemodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PN2SC_TRACEMODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link pn2sctrace.impl.MapTraceImpl <em>Map Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pn2sctrace.impl.MapTraceImpl
	 * @see pn2sctrace.impl.Pn2sctracePackageImpl#getMapTrace()
	 * @generated
	 */
	int MAP_TRACE = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TRACE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TRACE__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Map Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TRACE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link pn2sctrace.PN2SCTracemodel <em>PN2SC Tracemodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PN2SC Tracemodel</em>'.
	 * @see pn2sctrace.PN2SCTracemodel
	 * @generated
	 */
	EClass getPN2SCTracemodel();

	/**
	 * Returns the meta object for the containment reference list '{@link pn2sctrace.PN2SCTracemodel#getContains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains</em>'.
	 * @see pn2sctrace.PN2SCTracemodel#getContains()
	 * @see #getPN2SCTracemodel()
	 * @generated
	 */
	EReference getPN2SCTracemodel_Contains();

	/**
	 * Returns the meta object for class '{@link pn2sctrace.MapTrace <em>Map Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Trace</em>'.
	 * @see pn2sctrace.MapTrace
	 * @generated
	 */
	EClass getMapTrace();

	/**
	 * Returns the meta object for the reference '{@link pn2sctrace.MapTrace#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see pn2sctrace.MapTrace#getSource()
	 * @see #getMapTrace()
	 * @generated
	 */
	EReference getMapTrace_Source();

	/**
	 * Returns the meta object for the reference '{@link pn2sctrace.MapTrace#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see pn2sctrace.MapTrace#getTarget()
	 * @see #getMapTrace()
	 * @generated
	 */
	EReference getMapTrace_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Pn2sctraceFactory getPn2sctraceFactory();

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
		 * The meta object literal for the '{@link pn2sctrace.impl.PN2SCTracemodelImpl <em>PN2SC Tracemodel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pn2sctrace.impl.PN2SCTracemodelImpl
		 * @see pn2sctrace.impl.Pn2sctracePackageImpl#getPN2SCTracemodel()
		 * @generated
		 */
		EClass PN2SC_TRACEMODEL = eINSTANCE.getPN2SCTracemodel();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PN2SC_TRACEMODEL__CONTAINS = eINSTANCE.getPN2SCTracemodel_Contains();

		/**
		 * The meta object literal for the '{@link pn2sctrace.impl.MapTraceImpl <em>Map Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pn2sctrace.impl.MapTraceImpl
		 * @see pn2sctrace.impl.Pn2sctracePackageImpl#getMapTrace()
		 * @generated
		 */
		EClass MAP_TRACE = eINSTANCE.getMapTrace();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_TRACE__SOURCE = eINSTANCE.getMapTrace_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_TRACE__TARGET = eINSTANCE.getMapTrace_Target();

	}

} //Pn2sctracePackage
