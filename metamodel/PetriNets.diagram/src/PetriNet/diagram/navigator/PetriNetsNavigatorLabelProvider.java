/*
 * 
 */
package PetriNet.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class PetriNetsNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		PetriNet.diagram.part.PetriNetsDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		PetriNet.diagram.part.PetriNetsDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof PetriNet.diagram.navigator.PetriNetsNavigatorItem
				&& !isOwnView(((PetriNet.diagram.navigator.PetriNetsNavigatorItem) element)
						.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof PetriNet.diagram.navigator.PetriNetsNavigatorGroup) {
			PetriNet.diagram.navigator.PetriNetsNavigatorGroup group = (PetriNet.diagram.navigator.PetriNetsNavigatorGroup) element;
			return PetriNet.diagram.part.PetriNetsDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof PetriNet.diagram.navigator.PetriNetsNavigatorItem) {
			PetriNet.diagram.navigator.PetriNetsNavigatorItem navigatorItem = (PetriNet.diagram.navigator.PetriNetsNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (PetriNet.diagram.part.PetriNetsVisualIDRegistry
				.getVisualID(view)) {
		case PetriNet.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://uam.es/PetriNets?Transition", PetriNet.diagram.providers.PetriNetsElementTypes.Transition_2002); //$NON-NLS-1$
		case PetriNet.diagram.edit.parts.PlaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://uam.es/PetriNets?Place", PetriNet.diagram.providers.PetriNetsElementTypes.Place_2001); //$NON-NLS-1$
		case PetriNet.diagram.edit.parts.TransitionPostpEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://uam.es/PetriNets?Transition?postp", PetriNet.diagram.providers.PetriNetsElementTypes.TransitionPostp_4002); //$NON-NLS-1$
		case PetriNet.diagram.edit.parts.PlacePosttEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://uam.es/PetriNets?Place?postt", PetriNet.diagram.providers.PetriNetsElementTypes.PlacePostt_4001); //$NON-NLS-1$
		case PetriNet.diagram.edit.parts.NetEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://uam.es/PetriNets?Net", PetriNet.diagram.providers.PetriNetsElementTypes.Net_1000); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PetriNet.diagram.part.PetriNetsDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& PetriNet.diagram.providers.PetriNetsElementTypes
						.isKnownElementType(elementType)) {
			image = PetriNet.diagram.providers.PetriNetsElementTypes
					.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof PetriNet.diagram.navigator.PetriNetsNavigatorGroup) {
			PetriNet.diagram.navigator.PetriNetsNavigatorGroup group = (PetriNet.diagram.navigator.PetriNetsNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof PetriNet.diagram.navigator.PetriNetsNavigatorItem) {
			PetriNet.diagram.navigator.PetriNetsNavigatorItem navigatorItem = (PetriNet.diagram.navigator.PetriNetsNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (PetriNet.diagram.part.PetriNetsVisualIDRegistry
				.getVisualID(view)) {
		case PetriNet.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_2002Text(view);
		case PetriNet.diagram.edit.parts.PlaceEditPart.VISUAL_ID:
			return getPlace_2001Text(view);
		case PetriNet.diagram.edit.parts.TransitionPostpEditPart.VISUAL_ID:
			return getTransitionPostp_4002Text(view);
		case PetriNet.diagram.edit.parts.PlacePosttEditPart.VISUAL_ID:
			return getPlacePostt_4001Text(view);
		case PetriNet.diagram.edit.parts.NetEditPart.VISUAL_ID:
			return getNet_1000Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getTransition_2002Text(View view) {
		IParser parser = PetriNet.diagram.providers.PetriNetsParserProvider
				.getParser(
						PetriNet.diagram.providers.PetriNetsElementTypes.Transition_2002,
						view.getElement() != null ? view.getElement() : view,
						PetriNet.diagram.part.PetriNetsVisualIDRegistry
								.getType(PetriNet.diagram.edit.parts.TransitionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PetriNet.diagram.part.PetriNetsDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPlace_2001Text(View view) {
		IParser parser = PetriNet.diagram.providers.PetriNetsParserProvider
				.getParser(
						PetriNet.diagram.providers.PetriNetsElementTypes.Place_2001,
						view.getElement() != null ? view.getElement() : view,
						PetriNet.diagram.part.PetriNetsVisualIDRegistry
								.getType(PetriNet.diagram.edit.parts.PlaceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PetriNet.diagram.part.PetriNetsDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransitionPostp_4002Text(View view) {
		IParser parser = PetriNet.diagram.providers.PetriNetsParserProvider
				.getParser(
						PetriNet.diagram.providers.PetriNetsElementTypes.TransitionPostp_4002,
						view.getElement() != null ? view.getElement() : view,
						CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PetriNet.diagram.part.PetriNetsDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPlacePostt_4001Text(View view) {
		IParser parser = PetriNet.diagram.providers.PetriNetsParserProvider
				.getParser(
						PetriNet.diagram.providers.PetriNetsElementTypes.PlacePostt_4001,
						view.getElement() != null ? view.getElement() : view,
						CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PetriNet.diagram.part.PetriNetsDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNet_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return PetriNet.diagram.edit.parts.NetEditPart.MODEL_ID
				.equals(PetriNet.diagram.part.PetriNetsVisualIDRegistry
						.getModelID(view));
	}

}
