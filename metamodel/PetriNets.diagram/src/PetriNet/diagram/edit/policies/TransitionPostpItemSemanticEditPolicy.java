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
public class TransitionPostpItemSemanticEditPolicy extends
		PetriNet.diagram.edit.policies.PetriNetsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TransitionPostpItemSemanticEditPolicy() {
		super(
				PetriNet.diagram.providers.PetriNetsElementTypes.TransitionPostp_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
