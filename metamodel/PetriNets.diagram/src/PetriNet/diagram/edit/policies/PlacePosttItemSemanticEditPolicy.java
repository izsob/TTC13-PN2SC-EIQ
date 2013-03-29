/*
 * 
 */
package PetriNet.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class PlacePosttItemSemanticEditPolicy extends
		PetriNet.diagram.edit.policies.PetriNetsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PlacePosttItemSemanticEditPolicy() {
		super(PetriNet.diagram.providers.PetriNetsElementTypes.PlacePostt_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
