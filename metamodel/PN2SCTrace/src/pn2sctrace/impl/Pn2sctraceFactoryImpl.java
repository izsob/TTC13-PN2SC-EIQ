/**
 */
package pn2sctrace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pn2sctrace.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Pn2sctraceFactoryImpl extends EFactoryImpl implements Pn2sctraceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Pn2sctraceFactory init() {
		try {
			Pn2sctraceFactory thePn2sctraceFactory = (Pn2sctraceFactory)EPackage.Registry.INSTANCE.getEFactory("http://pn2sctrace/1.0"); 
			if (thePn2sctraceFactory != null) {
				return thePn2sctraceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Pn2sctraceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pn2sctraceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Pn2sctracePackage.PN2SC_TRACEMODEL: return createPN2SCTracemodel();
			case Pn2sctracePackage.MAP_TRACE: return createMapTrace();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PN2SCTracemodel createPN2SCTracemodel() {
		PN2SCTracemodelImpl pn2SCTracemodel = new PN2SCTracemodelImpl();
		return pn2SCTracemodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapTrace createMapTrace() {
		MapTraceImpl mapTrace = new MapTraceImpl();
		return mapTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pn2sctracePackage getPn2sctracePackage() {
		return (Pn2sctracePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Pn2sctracePackage getPackage() {
		return Pn2sctracePackage.eINSTANCE;
	}

} //Pn2sctraceFactoryImpl
