/*
 * 
 */
package statecharts.diagram.navigator;

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

import statecharts.diagram.edit.parts.AND2EditPart;
import statecharts.diagram.edit.parts.ANDEditPart;
import statecharts.diagram.edit.parts.ANDName2EditPart;
import statecharts.diagram.edit.parts.ANDNameEditPart;
import statecharts.diagram.edit.parts.BasicEditPart;
import statecharts.diagram.edit.parts.BasicNameEditPart;
import statecharts.diagram.edit.parts.HyperEdgeEditPart;
import statecharts.diagram.edit.parts.HyperEdgeNameEditPart;
import statecharts.diagram.edit.parts.OREditPart;
import statecharts.diagram.edit.parts.ORNameEditPart;
import statecharts.diagram.edit.parts.StateNextEditPart;
import statecharts.diagram.edit.parts.StatechartEditPart;
import statecharts.diagram.part.StateChartsDiagramEditorPlugin;
import statecharts.diagram.part.StateChartsVisualIDRegistry;
import statecharts.diagram.providers.StateChartsElementTypes;
import statecharts.diagram.providers.StateChartsParserProvider;

/**
 * @generated
 */
public class StateChartsNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		StateChartsDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		StateChartsDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof StateChartsNavigatorItem
				&& !isOwnView(((StateChartsNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof StateChartsNavigatorGroup) {
			StateChartsNavigatorGroup group = (StateChartsNavigatorGroup) element;
			return StateChartsDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof StateChartsNavigatorItem) {
			StateChartsNavigatorItem navigatorItem = (StateChartsNavigatorItem) element;
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
		switch (StateChartsVisualIDRegistry.getVisualID(view)) {
		case OREditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://uam.es/StateCharts?OR", StateChartsElementTypes.OR_3002); //$NON-NLS-1$
		case StatechartEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://uam.es/StateCharts?Statechart", StateChartsElementTypes.Statechart_1000); //$NON-NLS-1$
		case HyperEdgeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://uam.es/StateCharts?HyperEdge", StateChartsElementTypes.HyperEdge_3003); //$NON-NLS-1$
		case StateNextEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://uam.es/StateCharts?State?next", StateChartsElementTypes.StateNext_4001); //$NON-NLS-1$
		case ANDEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://uam.es/StateCharts?AND", StateChartsElementTypes.AND_2001); //$NON-NLS-1$
		case BasicEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://uam.es/StateCharts?Basic", StateChartsElementTypes.Basic_3004); //$NON-NLS-1$
		case AND2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://uam.es/StateCharts?AND", StateChartsElementTypes.AND_3001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = StateChartsDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& StateChartsElementTypes.isKnownElementType(elementType)) {
			image = StateChartsElementTypes.getImage(elementType);
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
		if (element instanceof StateChartsNavigatorGroup) {
			StateChartsNavigatorGroup group = (StateChartsNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof StateChartsNavigatorItem) {
			StateChartsNavigatorItem navigatorItem = (StateChartsNavigatorItem) element;
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
		switch (StateChartsVisualIDRegistry.getVisualID(view)) {
		case OREditPart.VISUAL_ID:
			return getOR_3002Text(view);
		case StatechartEditPart.VISUAL_ID:
			return getStatechart_1000Text(view);
		case HyperEdgeEditPart.VISUAL_ID:
			return getHyperEdge_3003Text(view);
		case StateNextEditPart.VISUAL_ID:
			return getStateNext_4001Text(view);
		case ANDEditPart.VISUAL_ID:
			return getAND_2001Text(view);
		case BasicEditPart.VISUAL_ID:
			return getBasic_3004Text(view);
		case AND2EditPart.VISUAL_ID:
			return getAND_3001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getOR_3002Text(View view) {
		IParser parser = StateChartsParserProvider.getParser(
				StateChartsElementTypes.OR_3002,
				view.getElement() != null ? view.getElement() : view,
				StateChartsVisualIDRegistry.getType(ORNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StateChartsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStatechart_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getHyperEdge_3003Text(View view) {
		IParser parser = StateChartsParserProvider.getParser(
				StateChartsElementTypes.HyperEdge_3003,
				view.getElement() != null ? view.getElement() : view,
				StateChartsVisualIDRegistry
						.getType(HyperEdgeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StateChartsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStateNext_4001Text(View view) {
		IParser parser = StateChartsParserProvider.getParser(
				StateChartsElementTypes.StateNext_4001,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StateChartsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAND_2001Text(View view) {
		IParser parser = StateChartsParserProvider.getParser(
				StateChartsElementTypes.AND_2001,
				view.getElement() != null ? view.getElement() : view,
				StateChartsVisualIDRegistry.getType(ANDNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StateChartsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBasic_3004Text(View view) {
		IParser parser = StateChartsParserProvider.getParser(
				StateChartsElementTypes.Basic_3004,
				view.getElement() != null ? view.getElement() : view,
				StateChartsVisualIDRegistry
						.getType(BasicNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StateChartsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAND_3001Text(View view) {
		IParser parser = StateChartsParserProvider
				.getParser(StateChartsElementTypes.AND_3001,
						view.getElement() != null ? view.getElement() : view,
						StateChartsVisualIDRegistry
								.getType(ANDName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StateChartsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
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
		return StatechartEditPart.MODEL_ID.equals(StateChartsVisualIDRegistry
				.getModelID(view));
	}

}
