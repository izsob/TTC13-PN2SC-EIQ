/*
 * 
 */
package statecharts.diagram.providers;

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

import statecharts.StatechartsPackage;
import statecharts.diagram.edit.parts.AND2EditPart;
import statecharts.diagram.edit.parts.ANDEditPart;
import statecharts.diagram.edit.parts.BasicEditPart;
import statecharts.diagram.edit.parts.HyperEdgeEditPart;
import statecharts.diagram.edit.parts.OREditPart;
import statecharts.diagram.edit.parts.StateNextEditPart;
import statecharts.diagram.edit.parts.StatechartEditPart;
import statecharts.diagram.part.StateChartsDiagramEditorPlugin;

/**
 * @generated
 */
public class StateChartsElementTypes {

	/**
	 * @generated
	 */
	private StateChartsElementTypes() {
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
	public static final IElementType Statechart_1000 = getElementType("StateCharts.diagram.Statechart_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AND_2001 = getElementType("StateCharts.diagram.AND_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AND_3001 = getElementType("StateCharts.diagram.AND_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OR_3002 = getElementType("StateCharts.diagram.OR_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType HyperEdge_3003 = getElementType("StateCharts.diagram.HyperEdge_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Basic_3004 = getElementType("StateCharts.diagram.Basic_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StateNext_4001 = getElementType("StateCharts.diagram.StateNext_4001"); //$NON-NLS-1$

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
				return StateChartsDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
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

			elements.put(Statechart_1000,
					StatechartsPackage.eINSTANCE.getStatechart());

			elements.put(AND_2001, StatechartsPackage.eINSTANCE.getAND());

			elements.put(AND_3001, StatechartsPackage.eINSTANCE.getAND());

			elements.put(OR_3002, StatechartsPackage.eINSTANCE.getOR());

			elements.put(HyperEdge_3003,
					StatechartsPackage.eINSTANCE.getHyperEdge());

			elements.put(Basic_3004, StatechartsPackage.eINSTANCE.getBasic());

			elements.put(StateNext_4001,
					StatechartsPackage.eINSTANCE.getState_Next());
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
			KNOWN_ELEMENT_TYPES.add(Statechart_1000);
			KNOWN_ELEMENT_TYPES.add(AND_2001);
			KNOWN_ELEMENT_TYPES.add(AND_3001);
			KNOWN_ELEMENT_TYPES.add(OR_3002);
			KNOWN_ELEMENT_TYPES.add(HyperEdge_3003);
			KNOWN_ELEMENT_TYPES.add(Basic_3004);
			KNOWN_ELEMENT_TYPES.add(StateNext_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case StatechartEditPart.VISUAL_ID:
			return Statechart_1000;
		case ANDEditPart.VISUAL_ID:
			return AND_2001;
		case AND2EditPart.VISUAL_ID:
			return AND_3001;
		case OREditPart.VISUAL_ID:
			return OR_3002;
		case HyperEdgeEditPart.VISUAL_ID:
			return HyperEdge_3003;
		case BasicEditPart.VISUAL_ID:
			return Basic_3004;
		case StateNextEditPart.VISUAL_ID:
			return StateNext_4001;
		}
		return null;
	}

}
