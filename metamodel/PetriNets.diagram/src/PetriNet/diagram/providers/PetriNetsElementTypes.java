/*
 * 
 */
package PetriNet.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class PetriNetsElementTypes {

	/**
	 * @generated
	 */
	private PetriNetsElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Net_1000 = getElementType("PetriNets.diagram.Net_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Place_2001 = getElementType("PetriNets.diagram.Place_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Transition_2002 = getElementType("PetriNets.diagram.Transition_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PlacePostt_4001 = getElementType("PetriNets.diagram.PlacePostt_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TransitionPostp_4002 = getElementType("PetriNets.diagram.TransitionPostp_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return PetriNet.diagram.part.PetriNetsDiagramEditorPlugin
						.getInstance().getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Net_1000, PetriNet.PetriNetPackage.eINSTANCE.getNet());

			elements.put(Place_2001,
					PetriNet.PetriNetPackage.eINSTANCE.getPlace());

			elements.put(Transition_2002,
					PetriNet.PetriNetPackage.eINSTANCE.getTransition());

			elements.put(PlacePostt_4001,
					PetriNet.PetriNetPackage.eINSTANCE.getPlace_Postt());

			elements.put(TransitionPostp_4002,
					PetriNet.PetriNetPackage.eINSTANCE.getTransition_Postp());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Net_1000);
			KNOWN_ELEMENT_TYPES.add(Place_2001);
			KNOWN_ELEMENT_TYPES.add(Transition_2002);
			KNOWN_ELEMENT_TYPES.add(PlacePostt_4001);
			KNOWN_ELEMENT_TYPES.add(TransitionPostp_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case PetriNet.diagram.edit.parts.NetEditPart.VISUAL_ID:
			return Net_1000;
		case PetriNet.diagram.edit.parts.PlaceEditPart.VISUAL_ID:
			return Place_2001;
		case PetriNet.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return Transition_2002;
		case PetriNet.diagram.edit.parts.PlacePosttEditPart.VISUAL_ID:
			return PlacePostt_4001;
		case PetriNet.diagram.edit.parts.TransitionPostpEditPart.VISUAL_ID:
			return TransitionPostp_4002;
		}
		return null;
	}

}
