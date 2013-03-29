/*
 * 
 */
package statecharts.diagram.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage;

import statecharts.diagram.part.StateChartsDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramConnectionsPreferencePage extends ConnectionsPreferencePage {

	/**
	 * @generated
	 */
	public DiagramConnectionsPreferencePage() {
		setPreferenceStore(StateChartsDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
}
