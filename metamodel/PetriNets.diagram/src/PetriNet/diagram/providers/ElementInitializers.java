/*
 * 
 */
package PetriNet.diagram.providers;

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
		ElementInitializers cached = PetriNet.diagram.part.PetriNetsDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			PetriNet.diagram.part.PetriNetsDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
