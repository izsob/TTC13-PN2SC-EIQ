/*
 * 
 */
package statecharts.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import statecharts.StatechartsPackage;
import statecharts.diagram.edit.parts.ANDName2EditPart;
import statecharts.diagram.edit.parts.ANDNameEditPart;
import statecharts.diagram.edit.parts.BasicNameEditPart;
import statecharts.diagram.edit.parts.HyperEdgeNameEditPart;
import statecharts.diagram.edit.parts.ORNameEditPart;
import statecharts.diagram.parsers.MessageFormatParser;
import statecharts.diagram.part.StateChartsVisualIDRegistry;

/**
 * @generated
 */
public class StateChartsParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser aNDName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getANDName_5005Parser() {
		if (aNDName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { StatechartsPackage.eINSTANCE
					.getState_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			aNDName_5005Parser = parser;
		}
		return aNDName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser aNDName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getANDName_5004Parser() {
		if (aNDName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { StatechartsPackage.eINSTANCE
					.getState_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			aNDName_5004Parser = parser;
		}
		return aNDName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser oRName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getORName_5003Parser() {
		if (oRName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { StatechartsPackage.eINSTANCE
					.getState_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			oRName_5003Parser = parser;
		}
		return oRName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser hyperEdgeName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getHyperEdgeName_5001Parser() {
		if (hyperEdgeName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { StatechartsPackage.eINSTANCE
					.getState_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			hyperEdgeName_5001Parser = parser;
		}
		return hyperEdgeName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser basicName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getBasicName_5002Parser() {
		if (basicName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { StatechartsPackage.eINSTANCE
					.getState_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			basicName_5002Parser = parser;
		}
		return basicName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ANDNameEditPart.VISUAL_ID:
			return getANDName_5005Parser();
		case ANDName2EditPart.VISUAL_ID:
			return getANDName_5004Parser();
		case ORNameEditPart.VISUAL_ID:
			return getORName_5003Parser();
		case HyperEdgeNameEditPart.VISUAL_ID:
			return getHyperEdgeName_5001Parser();
		case BasicNameEditPart.VISUAL_ID:
			return getBasicName_5002Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(StateChartsVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(StateChartsVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (StateChartsElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
