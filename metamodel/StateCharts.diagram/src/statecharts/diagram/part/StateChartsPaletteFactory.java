/*
 * 
 */
package statecharts.diagram.part;

import java.util.ArrayList;
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

import statecharts.diagram.providers.StateChartsElementTypes;

/**
 * @generated
 */
public class StateChartsPaletteFactory {

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
				Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createBasic1CreationTool());
		paletteContainer.add(createHyperedge2CreationTool());
		paletteContainer.add(createRegion3CreationTool());
		paletteContainer.add(createSubRegion4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createNext1CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBasic1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Basic1CreationTool_title,
				Messages.Basic1CreationTool_desc,
				Collections.singletonList(StateChartsElementTypes.Basic_3004));
		entry.setId("createBasic1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateChartsElementTypes
				.getImageDescriptor(StateChartsElementTypes.Basic_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createHyperedge2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Hyperedge2CreationTool_title,
				Messages.Hyperedge2CreationTool_desc,
				Collections
						.singletonList(StateChartsElementTypes.HyperEdge_3003));
		entry.setId("createHyperedge2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateChartsElementTypes
				.getImageDescriptor(StateChartsElementTypes.HyperEdge_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRegion3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StateChartsElementTypes.AND_2001);
		types.add(StateChartsElementTypes.AND_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Region3CreationTool_title,
				Messages.Region3CreationTool_desc, types);
		entry.setId("createRegion3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateChartsElementTypes
				.getImageDescriptor(StateChartsElementTypes.AND_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubRegion4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SubRegion4CreationTool_title,
				Messages.SubRegion4CreationTool_desc,
				Collections.singletonList(StateChartsElementTypes.OR_3002));
		entry.setId("createSubRegion4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateChartsElementTypes
				.getImageDescriptor(StateChartsElementTypes.OR_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNext1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Next1CreationTool_title,
				Messages.Next1CreationTool_desc,
				Collections
						.singletonList(StateChartsElementTypes.StateNext_4001));
		entry.setId("createNext1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateChartsElementTypes
				.getImageDescriptor(StateChartsElementTypes.StateNext_4001));
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
