/*
 * 
 */
package statecharts.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import statecharts.diagram.edit.parts.AND2EditPart;
import statecharts.diagram.edit.parts.ANDANDContainsCompartment2EditPart;
import statecharts.diagram.edit.parts.ANDANDContainsCompartmentEditPart;
import statecharts.diagram.edit.parts.ANDEditPart;
import statecharts.diagram.edit.parts.BasicEditPart;
import statecharts.diagram.edit.parts.HyperEdgeEditPart;
import statecharts.diagram.edit.parts.OREditPart;
import statecharts.diagram.edit.parts.ORORContainsCompartmentEditPart;
import statecharts.diagram.edit.parts.StatechartEditPart;
import statecharts.diagram.part.Messages;
import statecharts.diagram.part.StateChartsDiagramEditorPlugin;

/**
 * @generated
 */
public class StateChartsModelingAssistantProvider extends
		ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof StatechartEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(StateChartsElementTypes.AND_2001);
			return types;
		}
		if (editPart instanceof ANDANDContainsCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(StateChartsElementTypes.AND_3001);
			types.add(StateChartsElementTypes.OR_3002);
			types.add(StateChartsElementTypes.HyperEdge_3003);
			types.add(StateChartsElementTypes.Basic_3004);
			return types;
		}
		if (editPart instanceof ANDANDContainsCompartment2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(StateChartsElementTypes.AND_3001);
			types.add(StateChartsElementTypes.OR_3002);
			types.add(StateChartsElementTypes.HyperEdge_3003);
			types.add(StateChartsElementTypes.Basic_3004);
			return types;
		}
		if (editPart instanceof ORORContainsCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(StateChartsElementTypes.AND_3001);
			types.add(StateChartsElementTypes.OR_3002);
			types.add(StateChartsElementTypes.HyperEdge_3003);
			types.add(StateChartsElementTypes.Basic_3004);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ANDEditPart) {
			return ((ANDEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AND2EditPart) {
			return ((AND2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof OREditPart) {
			return ((OREditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof HyperEdgeEditPart) {
			return ((HyperEdgeEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof BasicEditPart) {
			return ((BasicEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ANDEditPart) {
			return ((ANDEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AND2EditPart) {
			return ((AND2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof OREditPart) {
			return ((OREditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof HyperEdgeEditPart) {
			return ((HyperEdgeEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof BasicEditPart) {
			return ((BasicEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ANDEditPart) {
			return ((ANDEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AND2EditPart) {
			return ((AND2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof OREditPart) {
			return ((OREditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof HyperEdgeEditPart) {
			return ((HyperEdgeEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof BasicEditPart) {
			return ((BasicEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ANDEditPart) {
			return ((ANDEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AND2EditPart) {
			return ((AND2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof OREditPart) {
			return ((OREditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof HyperEdgeEditPart) {
			return ((HyperEdgeEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof BasicEditPart) {
			return ((BasicEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ANDEditPart) {
			return ((ANDEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AND2EditPart) {
			return ((AND2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof OREditPart) {
			return ((OREditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof HyperEdgeEditPart) {
			return ((HyperEdgeEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof BasicEditPart) {
			return ((BasicEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target,
				getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source,
				getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it
				.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				StateChartsDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.StateChartsModelingAssistantProviderMessage);
		dialog.setTitle(Messages.StateChartsModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
