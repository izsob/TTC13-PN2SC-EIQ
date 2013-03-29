/*
 * 
 */
package statecharts.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import statecharts.diagram.part.StateChartsVisualIDRegistry;

/**
 * @generated
 */
public class StateChartsEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (StateChartsVisualIDRegistry.getVisualID(view)) {

			case StatechartEditPart.VISUAL_ID:
				return new StatechartEditPart(view);

			case ANDEditPart.VISUAL_ID:
				return new ANDEditPart(view);

			case ANDNameEditPart.VISUAL_ID:
				return new ANDNameEditPart(view);

			case AND2EditPart.VISUAL_ID:
				return new AND2EditPart(view);

			case ANDName2EditPart.VISUAL_ID:
				return new ANDName2EditPart(view);

			case OREditPart.VISUAL_ID:
				return new OREditPart(view);

			case ORNameEditPart.VISUAL_ID:
				return new ORNameEditPart(view);

			case HyperEdgeEditPart.VISUAL_ID:
				return new HyperEdgeEditPart(view);

			case HyperEdgeNameEditPart.VISUAL_ID:
				return new HyperEdgeNameEditPart(view);

			case BasicEditPart.VISUAL_ID:
				return new BasicEditPart(view);

			case BasicNameEditPart.VISUAL_ID:
				return new BasicNameEditPart(view);

			case ANDANDContainsCompartmentEditPart.VISUAL_ID:
				return new ANDANDContainsCompartmentEditPart(view);

			case ANDANDContainsCompartment2EditPart.VISUAL_ID:
				return new ANDANDContainsCompartment2EditPart(view);

			case ORORContainsCompartmentEditPart.VISUAL_ID:
				return new ORORContainsCompartmentEditPart(view);

			case StateNextEditPart.VISUAL_ID:
				return new StateNextEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

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
