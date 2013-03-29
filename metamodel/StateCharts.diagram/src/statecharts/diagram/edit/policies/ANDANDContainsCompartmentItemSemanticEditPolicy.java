/*
 * 
 */
package statecharts.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import statecharts.diagram.edit.commands.AND2CreateCommand;
import statecharts.diagram.edit.commands.BasicCreateCommand;
import statecharts.diagram.edit.commands.HyperEdgeCreateCommand;
import statecharts.diagram.edit.commands.ORCreateCommand;
import statecharts.diagram.providers.StateChartsElementTypes;

/**
 * @generated
 */
public class ANDANDContainsCompartmentItemSemanticEditPolicy extends
		StateChartsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ANDANDContainsCompartmentItemSemanticEditPolicy() {
		super(StateChartsElementTypes.AND_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StateChartsElementTypes.AND_3001 == req.getElementType()) {
			return getGEFWrapper(new AND2CreateCommand(req));
		}
		if (StateChartsElementTypes.OR_3002 == req.getElementType()) {
			return getGEFWrapper(new ORCreateCommand(req));
		}
		if (StateChartsElementTypes.HyperEdge_3003 == req.getElementType()) {
			return getGEFWrapper(new HyperEdgeCreateCommand(req));
		}
		if (StateChartsElementTypes.Basic_3004 == req.getElementType()) {
			return getGEFWrapper(new BasicCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
