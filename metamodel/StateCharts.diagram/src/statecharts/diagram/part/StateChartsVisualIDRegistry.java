/*
 * 
 */
package statecharts.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import statecharts.Statechart;
import statecharts.StatechartsPackage;
import statecharts.diagram.edit.parts.AND2EditPart;
import statecharts.diagram.edit.parts.ANDANDContainsCompartment2EditPart;
import statecharts.diagram.edit.parts.ANDANDContainsCompartmentEditPart;
import statecharts.diagram.edit.parts.ANDEditPart;
import statecharts.diagram.edit.parts.ANDName2EditPart;
import statecharts.diagram.edit.parts.ANDNameEditPart;
import statecharts.diagram.edit.parts.BasicEditPart;
import statecharts.diagram.edit.parts.BasicNameEditPart;
import statecharts.diagram.edit.parts.HyperEdgeEditPart;
import statecharts.diagram.edit.parts.HyperEdgeNameEditPart;
import statecharts.diagram.edit.parts.OREditPart;
import statecharts.diagram.edit.parts.ORNameEditPart;
import statecharts.diagram.edit.parts.ORORContainsCompartmentEditPart;
import statecharts.diagram.edit.parts.StateNextEditPart;
import statecharts.diagram.edit.parts.StatechartEditPart;
import statecharts.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class StateChartsVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "StateCharts.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (StatechartEditPart.MODEL_ID.equals(view.getType())) {
				return StatechartEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return statecharts.diagram.part.StateChartsVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				StateChartsDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (StatechartsPackage.eINSTANCE.getStatechart().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Statechart) domainElement)) {
			return StatechartEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = statecharts.diagram.part.StateChartsVisualIDRegistry
				.getModelID(containerView);
		if (!StatechartEditPart.MODEL_ID.equals(containerModelID)
				&& !"statechart".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (StatechartEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = statecharts.diagram.part.StateChartsVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StatechartEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case StatechartEditPart.VISUAL_ID:
			if (StatechartsPackage.eINSTANCE.getAND().isSuperTypeOf(
					domainElement.eClass())) {
				return ANDEditPart.VISUAL_ID;
			}
			break;
		case ANDANDContainsCompartmentEditPart.VISUAL_ID:
			if (StatechartsPackage.eINSTANCE.getAND().isSuperTypeOf(
					domainElement.eClass())) {
				return AND2EditPart.VISUAL_ID;
			}
			if (StatechartsPackage.eINSTANCE.getOR().isSuperTypeOf(
					domainElement.eClass())) {
				return OREditPart.VISUAL_ID;
			}
			if (StatechartsPackage.eINSTANCE.getHyperEdge().isSuperTypeOf(
					domainElement.eClass())) {
				return HyperEdgeEditPart.VISUAL_ID;
			}
			if (StatechartsPackage.eINSTANCE.getBasic().isSuperTypeOf(
					domainElement.eClass())) {
				return BasicEditPart.VISUAL_ID;
			}
			break;
		case ANDANDContainsCompartment2EditPart.VISUAL_ID:
			if (StatechartsPackage.eINSTANCE.getAND().isSuperTypeOf(
					domainElement.eClass())) {
				return AND2EditPart.VISUAL_ID;
			}
			if (StatechartsPackage.eINSTANCE.getOR().isSuperTypeOf(
					domainElement.eClass())) {
				return OREditPart.VISUAL_ID;
			}
			if (StatechartsPackage.eINSTANCE.getHyperEdge().isSuperTypeOf(
					domainElement.eClass())) {
				return HyperEdgeEditPart.VISUAL_ID;
			}
			if (StatechartsPackage.eINSTANCE.getBasic().isSuperTypeOf(
					domainElement.eClass())) {
				return BasicEditPart.VISUAL_ID;
			}
			break;
		case ORORContainsCompartmentEditPart.VISUAL_ID:
			if (StatechartsPackage.eINSTANCE.getAND().isSuperTypeOf(
					domainElement.eClass())) {
				return AND2EditPart.VISUAL_ID;
			}
			if (StatechartsPackage.eINSTANCE.getOR().isSuperTypeOf(
					domainElement.eClass())) {
				return OREditPart.VISUAL_ID;
			}
			if (StatechartsPackage.eINSTANCE.getHyperEdge().isSuperTypeOf(
					domainElement.eClass())) {
				return HyperEdgeEditPart.VISUAL_ID;
			}
			if (StatechartsPackage.eINSTANCE.getBasic().isSuperTypeOf(
					domainElement.eClass())) {
				return BasicEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = statecharts.diagram.part.StateChartsVisualIDRegistry
				.getModelID(containerView);
		if (!StatechartEditPart.MODEL_ID.equals(containerModelID)
				&& !"statechart".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (StatechartEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = statecharts.diagram.part.StateChartsVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StatechartEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case StatechartEditPart.VISUAL_ID:
			if (ANDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ANDEditPart.VISUAL_ID:
			if (ANDNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ANDANDContainsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AND2EditPart.VISUAL_ID:
			if (ANDName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ANDANDContainsCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OREditPart.VISUAL_ID:
			if (ORNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ORORContainsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case HyperEdgeEditPart.VISUAL_ID:
			if (HyperEdgeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BasicEditPart.VISUAL_ID:
			if (BasicNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ANDANDContainsCompartmentEditPart.VISUAL_ID:
			if (AND2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HyperEdgeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BasicEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ANDANDContainsCompartment2EditPart.VISUAL_ID:
			if (AND2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HyperEdgeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BasicEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ORORContainsCompartmentEditPart.VISUAL_ID:
			if (AND2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HyperEdgeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BasicEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateNextEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Statechart element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case ANDANDContainsCompartmentEditPart.VISUAL_ID:
		case ANDANDContainsCompartment2EditPart.VISUAL_ID:
		case ORORContainsCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case StatechartEditPart.VISUAL_ID:
			return false;
		case HyperEdgeEditPart.VISUAL_ID:
		case BasicEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return statecharts.diagram.part.StateChartsVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return statecharts.diagram.part.StateChartsVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return statecharts.diagram.part.StateChartsVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return statecharts.diagram.part.StateChartsVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return statecharts.diagram.part.StateChartsVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return statecharts.diagram.part.StateChartsVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
