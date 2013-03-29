/*
 * 
 */
package PetriNet.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class PetriNetsPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				PetriNet.diagram.part.Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createPlace1CreationTool());
		paletteContainer.add(createTransition2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				PetriNet.diagram.part.Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createPostp1CreationTool());
		paletteContainer.add(createPostt2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPlace1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				PetriNet.diagram.part.Messages.Place1CreationTool_title,
				PetriNet.diagram.part.Messages.Place1CreationTool_desc,
				Collections
						.singletonList(PetriNet.diagram.providers.PetriNetsElementTypes.Place_2001));
		entry.setId("createPlace1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetriNet.diagram.providers.PetriNetsElementTypes
				.getImageDescriptor(PetriNet.diagram.providers.PetriNetsElementTypes.Place_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				PetriNet.diagram.part.Messages.Transition2CreationTool_title,
				PetriNet.diagram.part.Messages.Transition2CreationTool_desc,
				Collections
						.singletonList(PetriNet.diagram.providers.PetriNetsElementTypes.Transition_2002));
		entry.setId("createTransition2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetriNet.diagram.providers.PetriNetsElementTypes
				.getImageDescriptor(PetriNet.diagram.providers.PetriNetsElementTypes.Transition_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPostp1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				PetriNet.diagram.part.Messages.Postp1CreationTool_title,
				PetriNet.diagram.part.Messages.Postp1CreationTool_desc,
				Collections
						.singletonList(PetriNet.diagram.providers.PetriNetsElementTypes.TransitionPostp_4002));
		entry.setId("createPostp1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetriNet.diagram.providers.PetriNetsElementTypes
				.getImageDescriptor(PetriNet.diagram.providers.PetriNetsElementTypes.TransitionPostp_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPostt2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				PetriNet.diagram.part.Messages.Postt2CreationTool_title,
				PetriNet.diagram.part.Messages.Postt2CreationTool_desc,
				Collections
						.singletonList(PetriNet.diagram.providers.PetriNetsElementTypes.PlacePostt_4001));
		entry.setId("createPostt2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetriNet.diagram.providers.PetriNetsElementTypes
				.getImageDescriptor(PetriNet.diagram.providers.PetriNetsElementTypes.PlacePostt_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
