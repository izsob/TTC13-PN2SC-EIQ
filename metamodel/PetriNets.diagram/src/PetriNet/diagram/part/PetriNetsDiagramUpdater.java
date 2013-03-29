/*
 * 
 */
package PetriNet.diagram.part;

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

/**
 * @generated
 */
public class PetriNetsDiagramUpdater {

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
	public static List<PetriNet.diagram.part.PetriNetsNodeDescriptor> getSemanticChildren(
			View view) {
		switch (PetriNet.diagram.part.PetriNetsVisualIDRegistry
				.getVisualID(view)) {
		case PetriNet.diagram.edit.parts.NetEditPart.VISUAL_ID:
			return getNet_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PetriNet.diagram.part.PetriNetsNodeDescriptor> getNet_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		PetriNet.Net modelElement = (PetriNet.Net) view.getElement();
		LinkedList<PetriNet.diagram.part.PetriNetsNodeDescriptor> result = new LinkedList<PetriNet.diagram.part.PetriNetsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPlaces().iterator(); it.hasNext();) {
			PetriNet.Place childElement = (PetriNet.Place) it.next();
			int visualID = PetriNet.diagram.part.PetriNetsVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == PetriNet.diagram.edit.parts.PlaceEditPart.VISUAL_ID) {
				result.add(new PetriNet.diagram.part.PetriNetsNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getTransitions().iterator(); it
				.hasNext();) {
			PetriNet.Transition childElement = (PetriNet.Transition) it.next();
			int visualID = PetriNet.diagram.part.PetriNetsVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == PetriNet.diagram.edit.parts.TransitionEditPart.VISUAL_ID) {
				result.add(new PetriNet.diagram.part.PetriNetsNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getContainedLinks(
			View view) {
		switch (PetriNet.diagram.part.PetriNetsVisualIDRegistry
				.getVisualID(view)) {
		case PetriNet.diagram.edit.parts.NetEditPart.VISUAL_ID:
			return getNet_1000ContainedLinks(view);
		case PetriNet.diagram.edit.parts.PlaceEditPart.VISUAL_ID:
			return getPlace_2001ContainedLinks(view);
		case PetriNet.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_2002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getIncomingLinks(
			View view) {
		switch (PetriNet.diagram.part.PetriNetsVisualIDRegistry
				.getVisualID(view)) {
		case PetriNet.diagram.edit.parts.PlaceEditPart.VISUAL_ID:
			return getPlace_2001IncomingLinks(view);
		case PetriNet.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_2002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (PetriNet.diagram.part.PetriNetsVisualIDRegistry
				.getVisualID(view)) {
		case PetriNet.diagram.edit.parts.PlaceEditPart.VISUAL_ID:
			return getPlace_2001OutgoingLinks(view);
		case PetriNet.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_2002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getNet_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getPlace_2001ContainedLinks(
			View view) {
		PetriNet.Place modelElement = (PetriNet.Place) view.getElement();
		LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor> result = new LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Place_Postt_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getTransition_2002ContainedLinks(
			View view) {
		PetriNet.Transition modelElement = (PetriNet.Transition) view
				.getElement();
		LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor> result = new LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Transition_Postp_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getPlace_2001IncomingLinks(
			View view) {
		PetriNet.Place modelElement = (PetriNet.Place) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor> result = new LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Transition_Postp_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getTransition_2002IncomingLinks(
			View view) {
		PetriNet.Transition modelElement = (PetriNet.Transition) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor> result = new LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Place_Postt_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getPlace_2001OutgoingLinks(
			View view) {
		PetriNet.Place modelElement = (PetriNet.Place) view.getElement();
		LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor> result = new LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Place_Postt_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getTransition_2002OutgoingLinks(
			View view) {
		PetriNet.Transition modelElement = (PetriNet.Transition) view
				.getElement();
		LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor> result = new LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Transition_Postp_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<PetriNet.diagram.part.PetriNetsLinkDescriptor> getIncomingFeatureModelFacetLinks_Place_Postt_4001(
			PetriNet.Transition target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor> result = new LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == PetriNet.PetriNetPackage.eINSTANCE
					.getPlace_Postt()) {
				result.add(new PetriNet.diagram.part.PetriNetsLinkDescriptor(
						setting.getEObject(),
						target,
						PetriNet.diagram.providers.PetriNetsElementTypes.PlacePostt_4001,
						PetriNet.diagram.edit.parts.PlacePosttEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<PetriNet.diagram.part.PetriNetsLinkDescriptor> getIncomingFeatureModelFacetLinks_Transition_Postp_4002(
			PetriNet.Place target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor> result = new LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == PetriNet.PetriNetPackage.eINSTANCE
					.getTransition_Postp()) {
				result.add(new PetriNet.diagram.part.PetriNetsLinkDescriptor(
						setting.getEObject(),
						target,
						PetriNet.diagram.providers.PetriNetsElementTypes.TransitionPostp_4002,
						PetriNet.diagram.edit.parts.TransitionPostpEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<PetriNet.diagram.part.PetriNetsLinkDescriptor> getOutgoingFeatureModelFacetLinks_Place_Postt_4001(
			PetriNet.Place source) {
		LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor> result = new LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor>();
		for (Iterator<?> destinations = source.getPostt().iterator(); destinations
				.hasNext();) {
			PetriNet.Transition destination = (PetriNet.Transition) destinations
					.next();
			result.add(new PetriNet.diagram.part.PetriNetsLinkDescriptor(
					source,
					destination,
					PetriNet.diagram.providers.PetriNetsElementTypes.PlacePostt_4001,
					PetriNet.diagram.edit.parts.PlacePosttEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<PetriNet.diagram.part.PetriNetsLinkDescriptor> getOutgoingFeatureModelFacetLinks_Transition_Postp_4002(
			PetriNet.Transition source) {
		LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor> result = new LinkedList<PetriNet.diagram.part.PetriNetsLinkDescriptor>();
		for (Iterator<?> destinations = source.getPostp().iterator(); destinations
				.hasNext();) {
			PetriNet.Place destination = (PetriNet.Place) destinations.next();
			result.add(new PetriNet.diagram.part.PetriNetsLinkDescriptor(
					source,
					destination,
					PetriNet.diagram.providers.PetriNetsElementTypes.TransitionPostp_4002,
					PetriNet.diagram.edit.parts.TransitionPostpEditPart.VISUAL_ID));
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
		public List<PetriNet.diagram.part.PetriNetsNodeDescriptor> getSemanticChildren(
				View view) {
			return PetriNetsDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getContainedLinks(
				View view) {
			return PetriNetsDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getIncomingLinks(
				View view) {
			return PetriNetsDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PetriNet.diagram.part.PetriNetsLinkDescriptor> getOutgoingLinks(
				View view) {
			return PetriNetsDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
