/*
 * 
 */
package statecharts.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import statecharts.diagram.providers.StateChartsElementTypes;

/**
 * @generated
 */
public class StateNextItemSemanticEditPolicy extends
		StateChartsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StateNextItemSemanticEditPolicy() {
		super(StateChartsElementTypes.StateNext_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
