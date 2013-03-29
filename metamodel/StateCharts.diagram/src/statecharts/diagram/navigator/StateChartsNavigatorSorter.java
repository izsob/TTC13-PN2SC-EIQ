/*
 * 
 */
package statecharts.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import statecharts.diagram.part.StateChartsVisualIDRegistry;

/**
 * @generated
 */
public class StateChartsNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7005;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 7004;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof StateChartsNavigatorItem) {
			StateChartsNavigatorItem item = (StateChartsNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return StateChartsVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
