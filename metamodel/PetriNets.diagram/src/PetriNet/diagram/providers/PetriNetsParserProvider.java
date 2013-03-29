/*
 * 
 */
package PetriNet.diagram.providers;

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

/**
 * @generated
 */
public class PetriNetsParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser placeName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getPlaceName_5001Parser() {
		if (placeName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { PetriNet.PetriNetPackage.eINSTANCE
					.getNamedElement_Name() };
			PetriNet.diagram.parsers.MessageFormatParser parser = new PetriNet.diagram.parsers.MessageFormatParser(
					features);
			placeName_5001Parser = parser;
		}
		return placeName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionName_5002Parser() {
		if (transitionName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { PetriNet.PetriNetPackage.eINSTANCE
					.getNamedElement_Name() };
			PetriNet.diagram.parsers.MessageFormatParser parser = new PetriNet.diagram.parsers.MessageFormatParser(
					features);
			transitionName_5002Parser = parser;
		}
		return transitionName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case PetriNet.diagram.edit.parts.PlaceNameEditPart.VISUAL_ID:
			return getPlaceName_5001Parser();
		case PetriNet.diagram.edit.parts.TransitionNameEditPart.VISUAL_ID:
			return getTransitionName_5002Parser();
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
			return getParser(PetriNet.diagram.part.PetriNetsVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(PetriNet.diagram.part.PetriNetsVisualIDRegistry
					.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (PetriNet.diagram.providers.PetriNetsElementTypes
					.getElement(hint) == null) {
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
