/*
 * 
 */
package PetriNet.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		PetriNet.diagram.preferences.DiagramGeneralPreferencePage
				.initDefaults(store);
		PetriNet.diagram.preferences.DiagramAppearancePreferencePage
				.initDefaults(store);
		PetriNet.diagram.preferences.DiagramConnectionsPreferencePage
				.initDefaults(store);
		PetriNet.diagram.preferences.DiagramPrintingPreferencePage
				.initDefaults(store);
		PetriNet.diagram.preferences.DiagramRulersAndGridPreferencePage
				.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return PetriNet.diagram.part.PetriNetsDiagramEditorPlugin.getInstance()
				.getPreferenceStore();
	}
}
