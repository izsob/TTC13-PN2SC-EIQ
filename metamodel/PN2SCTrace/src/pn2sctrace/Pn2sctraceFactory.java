/**
 */
package pn2sctrace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pn2sctrace.Pn2sctracePackage
 * @generated
 */
public interface Pn2sctraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Pn2sctraceFactory eINSTANCE = pn2sctrace.impl.Pn2sctraceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>PN2SC Tracemodel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PN2SC Tracemodel</em>'.
	 * @generated
	 */
	PN2SCTracemodel createPN2SCTracemodel();

	/**
	 * Returns a new object of class '<em>Map Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Trace</em>'.
	 * @generated
	 */
	MapTrace createMapTrace();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Pn2sctracePackage getPn2sctracePackage();

} //Pn2sctraceFactory
