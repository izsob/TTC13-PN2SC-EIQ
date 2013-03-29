/**
 */
package pn2sctrace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PN2SC Tracemodel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pn2sctrace.PN2SCTracemodel#getContains <em>Contains</em>}</li>
 * </ul>
 * </p>
 *
 * @see pn2sctrace.Pn2sctracePackage#getPN2SCTracemodel()
 * @model
 * @generated
 */
public interface PN2SCTracemodel extends EObject {
	/**
	 * Returns the value of the '<em><b>Contains</b></em>' containment reference list.
	 * The list contents are of type {@link pn2sctrace.MapTrace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains</em>' containment reference list.
	 * @see pn2sctrace.Pn2sctracePackage#getPN2SCTracemodel_Contains()
	 * @model containment="true"
	 * @generated
	 */
	EList<MapTrace> getContains();

} // PN2SCTracemodel
