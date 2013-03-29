/*
 * 
 */
package statecharts.diagram.providers;

import statecharts.diagram.part.StateChartsDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = StateChartsDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			StateChartsDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
