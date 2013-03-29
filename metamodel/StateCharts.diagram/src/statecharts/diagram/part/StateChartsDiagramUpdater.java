/*
 * 
 */
package statecharts.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import statecharts.Basic;
import statecharts.HyperEdge;
import statecharts.State;
import statecharts.Statechart;
import statecharts.StatechartsPackage;
import statecharts.diagram.edit.parts.AND2EditPart;
import statecharts.diagram.edit.parts.ANDANDContainsCompartment2EditPart;
import statecharts.diagram.edit.parts.ANDANDContainsCompartmentEditPart;
import statecharts.diagram.edit.parts.ANDEditPart;
import statecharts.diagram.edit.parts.BasicEditPart;
import statecharts.diagram.edit.parts.HyperEdgeEditPart;
import statecharts.diagram.edit.parts.OREditPart;
import statecharts.diagram.edit.parts.ORORContainsCompartmentEditPart;
import statecharts.diagram.edit.parts.StateNextEditPart;
import statecharts.diagram.edit.parts.StatechartEditPart;
import statecharts.diagram.providers.StateChartsElementTypes;

/**
 * @generated
 */
public class StateChartsDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List<StateChartsNodeDescriptor> getSemanticChildren(View view) {
		switch (StateChartsVisualIDRegistry.getVisualID(view)) {
		case StatechartEditPart.VISUAL_ID:
			return getStatechart_1000SemanticChildren(view);
		case ANDANDContainsCompartmentEditPart.VISUAL_ID:
			return getANDANDContainsCompartment_7001SemanticChildren(view);
		case ANDANDContainsCompartment2EditPart.VISUAL_ID:
			return getANDANDContainsCompartment_7002SemanticChildren(view);
		case ORORContainsCompartmentEditPart.VISUAL_ID:
			return getORORContainsCompartment_7003SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateChartsNodeDescriptor> getStatechart_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Statechart modelElement = (Statechart) view.getElement();
		LinkedList<StateChartsNodeDescriptor> result = new LinkedList<StateChartsNodeDescriptor>();
		{
			statecharts.AND childElement = modelElement.getTopState();
			int visualID = StateChartsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ANDEditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsNodeDescriptor> getANDANDContainsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		statecharts.AND modelElement = (statecharts.AND) containerView
				.getElement();
		LinkedList<StateChartsNodeDescriptor> result = new LinkedList<StateChartsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContains().iterator(); it
				.hasNext();) {
			State childElement = (State) it.next();
			int visualID = StateChartsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AND2EditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OREditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HyperEdgeEditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BasicEditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsNodeDescriptor> getANDANDContainsCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		statecharts.AND modelElement = (statecharts.AND) containerView
				.getElement();
		LinkedList<StateChartsNodeDescriptor> result = new LinkedList<StateChartsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContains().iterator(); it
				.hasNext();) {
			State childElement = (State) it.next();
			int visualID = StateChartsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AND2EditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OREditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HyperEdgeEditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BasicEditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsNodeDescriptor> getORORContainsCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		statecharts.OR modelElement = (statecharts.OR) containerView
				.getElement();
		LinkedList<StateChartsNodeDescriptor> result = new LinkedList<StateChartsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContains().iterator(); it
				.hasNext();) {
			State childElement = (State) it.next();
			int visualID = StateChartsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AND2EditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OREditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HyperEdgeEditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BasicEditPart.VISUAL_ID) {
				result.add(new StateChartsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getContainedLinks(View view) {
		switch (StateChartsVisualIDRegistry.getVisualID(view)) {
		case StatechartEditPart.VISUAL_ID:
			return getStatechart_1000ContainedLinks(view);
		case ANDEditPart.VISUAL_ID:
			return getAND_2001ContainedLinks(view);
		case AND2EditPart.VISUAL_ID:
			return getAND_3001ContainedLinks(view);
		case OREditPart.VISUAL_ID:
			return getOR_3002ContainedLinks(view);
		case HyperEdgeEditPart.VISUAL_ID:
			return getHyperEdge_3003ContainedLinks(view);
		case BasicEditPart.VISUAL_ID:
			return getBasic_3004ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getIncomingLinks(View view) {
		switch (StateChartsVisualIDRegistry.getVisualID(view)) {
		case ANDEditPart.VISUAL_ID:
			return getAND_2001IncomingLinks(view);
		case AND2EditPart.VISUAL_ID:
			return getAND_3001IncomingLinks(view);
		case OREditPart.VISUAL_ID:
			return getOR_3002IncomingLinks(view);
		case HyperEdgeEditPart.VISUAL_ID:
			return getHyperEdge_3003IncomingLinks(view);
		case BasicEditPart.VISUAL_ID:
			return getBasic_3004IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getOutgoingLinks(View view) {
		switch (StateChartsVisualIDRegistry.getVisualID(view)) {
		case ANDEditPart.VISUAL_ID:
			return getAND_2001OutgoingLinks(view);
		case AND2EditPart.VISUAL_ID:
			return getAND_3001OutgoingLinks(view);
		case OREditPart.VISUAL_ID:
			return getOR_3002OutgoingLinks(view);
		case HyperEdgeEditPart.VISUAL_ID:
			return getHyperEdge_3003OutgoingLinks(view);
		case BasicEditPart.VISUAL_ID:
			return getBasic_3004OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getStatechart_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getAND_2001ContainedLinks(
			View view) {
		statecharts.AND modelElement = (statecharts.AND) view.getElement();
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_State_Next_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getAND_3001ContainedLinks(
			View view) {
		statecharts.AND modelElement = (statecharts.AND) view.getElement();
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_State_Next_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getOR_3002ContainedLinks(
			View view) {
		statecharts.OR modelElement = (statecharts.OR) view.getElement();
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_State_Next_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getHyperEdge_3003ContainedLinks(
			View view) {
		HyperEdge modelElement = (HyperEdge) view.getElement();
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_State_Next_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getBasic_3004ContainedLinks(
			View view) {
		Basic modelElement = (Basic) view.getElement();
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_State_Next_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getAND_2001IncomingLinks(
			View view) {
		statecharts.AND modelElement = (statecharts.AND) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_State_Next_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getAND_3001IncomingLinks(
			View view) {
		statecharts.AND modelElement = (statecharts.AND) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_State_Next_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getOR_3002IncomingLinks(
			View view) {
		statecharts.OR modelElement = (statecharts.OR) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_State_Next_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getHyperEdge_3003IncomingLinks(
			View view) {
		HyperEdge modelElement = (HyperEdge) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_State_Next_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getBasic_3004IncomingLinks(
			View view) {
		Basic modelElement = (Basic) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_State_Next_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getAND_2001OutgoingLinks(
			View view) {
		statecharts.AND modelElement = (statecharts.AND) view.getElement();
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_State_Next_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getAND_3001OutgoingLinks(
			View view) {
		statecharts.AND modelElement = (statecharts.AND) view.getElement();
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_State_Next_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getOR_3002OutgoingLinks(
			View view) {
		statecharts.OR modelElement = (statecharts.OR) view.getElement();
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_State_Next_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getHyperEdge_3003OutgoingLinks(
			View view) {
		HyperEdge modelElement = (HyperEdge) view.getElement();
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_State_Next_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateChartsLinkDescriptor> getBasic_3004OutgoingLinks(
			View view) {
		Basic modelElement = (Basic) view.getElement();
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_State_Next_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StateChartsLinkDescriptor> getIncomingFeatureModelFacetLinks_State_Next_4001(
			State target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == StatechartsPackage.eINSTANCE
					.getState_Next()) {
				result.add(new StateChartsLinkDescriptor(setting.getEObject(),
						target, StateChartsElementTypes.StateNext_4001,
						StateNextEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StateChartsLinkDescriptor> getOutgoingFeatureModelFacetLinks_State_Next_4001(
			State source) {
		LinkedList<StateChartsLinkDescriptor> result = new LinkedList<StateChartsLinkDescriptor>();
		for (Iterator<?> destinations = source.getNext().iterator(); destinations
				.hasNext();) {
			State destination = (State) destinations.next();
			result.add(new StateChartsLinkDescriptor(source, destination,
					StateChartsElementTypes.StateNext_4001,
					StateNextEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<StateChartsNodeDescriptor> getSemanticChildren(View view) {
			return StateChartsDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StateChartsLinkDescriptor> getContainedLinks(View view) {
			return StateChartsDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StateChartsLinkDescriptor> getIncomingLinks(View view) {
			return StateChartsDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StateChartsLinkDescriptor> getOutgoingLinks(View view) {
			return StateChartsDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
