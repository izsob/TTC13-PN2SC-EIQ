/**
 */
package pn2sctrace.impl;

import PetriNet.PetriNetPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import pn2sctrace.MapTrace;
import pn2sctrace.PN2SCTracemodel;
import pn2sctrace.Pn2sctraceFactory;
import pn2sctrace.Pn2sctracePackage;

import statecharts.StatechartsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Pn2sctracePackageImpl extends EPackageImpl implements Pn2sctracePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pn2SCTracemodelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapTraceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see pn2sctrace.Pn2sctracePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Pn2sctracePackageImpl() {
		super(eNS_URI, Pn2sctraceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Pn2sctracePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Pn2sctracePackage init() {
		if (isInited) return (Pn2sctracePackage)EPackage.Registry.INSTANCE.getEPackage(Pn2sctracePackage.eNS_URI);

		// Obtain or create and register package
		Pn2sctracePackageImpl thePn2sctracePackage = (Pn2sctracePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Pn2sctracePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Pn2sctracePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PetriNetPackage.eINSTANCE.eClass();
		StatechartsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePn2sctracePackage.createPackageContents();

		// Initialize created meta-data
		thePn2sctracePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePn2sctracePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Pn2sctracePackage.eNS_URI, thePn2sctracePackage);
		return thePn2sctracePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPN2SCTracemodel() {
		return pn2SCTracemodelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPN2SCTracemodel_Contains() {
		return (EReference)pn2SCTracemodelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapTrace() {
		return mapTraceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapTrace_Source() {
		return (EReference)mapTraceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapTrace_Target() {
		return (EReference)mapTraceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pn2sctraceFactory getPn2sctraceFactory() {
		return (Pn2sctraceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		pn2SCTracemodelEClass = createEClass(PN2SC_TRACEMODEL);
		createEReference(pn2SCTracemodelEClass, PN2SC_TRACEMODEL__CONTAINS);

		mapTraceEClass = createEClass(MAP_TRACE);
		createEReference(mapTraceEClass, MAP_TRACE__SOURCE);
		createEReference(mapTraceEClass, MAP_TRACE__TARGET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PetriNetPackage thePetriNetPackage = (PetriNetPackage)EPackage.Registry.INSTANCE.getEPackage(PetriNetPackage.eNS_URI);
		StatechartsPackage theStatechartsPackage = (StatechartsPackage)EPackage.Registry.INSTANCE.getEPackage(StatechartsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(pn2SCTracemodelEClass, PN2SCTracemodel.class, "PN2SCTracemodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPN2SCTracemodel_Contains(), this.getMapTrace(), null, "contains", null, 0, -1, PN2SCTracemodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapTraceEClass, MapTrace.class, "MapTrace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapTrace_Source(), thePetriNetPackage.getNamedElement(), null, "source", null, 0, 1, MapTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapTrace_Target(), theStatechartsPackage.getState(), null, "target", null, 0, 1, MapTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Pn2sctracePackageImpl
