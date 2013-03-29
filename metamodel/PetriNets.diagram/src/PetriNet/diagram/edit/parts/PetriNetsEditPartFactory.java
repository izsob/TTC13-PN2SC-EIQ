/*
 * 
 */
package PetriNet.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class PetriNetsEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (PetriNet.diagram.part.PetriNetsVisualIDRegistry
					.getVisualID(view)) {

			case PetriNet.diagram.edit.parts.NetEditPart.VISUAL_ID:
				return new PetriNet.diagram.edit.parts.NetEditPart(view);

			case PetriNet.diagram.edit.parts.PlaceEditPart.VISUAL_ID:
				return new PetriNet.diagram.edit.parts.PlaceEditPart(view);

			case PetriNet.diagram.edit.parts.PlaceNameEditPart.VISUAL_ID:
				return new PetriNet.diagram.edit.parts.PlaceNameEditPart(view);

			case PetriNet.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
				return new PetriNet.diagram.edit.parts.TransitionEditPart(view);

			case PetriNet.diagram.edit.parts.TransitionNameEditPart.VISUAL_ID:
				return new PetriNet.diagram.edit.parts.TransitionNameEditPart(
						view);

			case PetriNet.diagram.edit.parts.PlacePosttEditPart.VISUAL_ID:
				return new PetriNet.diagram.edit.parts.PlacePosttEditPart(view);

			case PetriNet.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
				return new PetriNet.diagram.edit.parts.WrappingLabelEditPart(
						view);

			case PetriNet.diagram.edit.parts.TransitionPostpEditPart.VISUAL_ID:
				return new PetriNet.diagram.edit.parts.TransitionPostpEditPart(
						view);

			case PetriNet.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
				return new PetriNet.diagram.edit.parts.WrappingLabel2EditPart(
						view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
