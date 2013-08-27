package pn2sc.queries.util;

import PetriNet.Place;
import PetriNet.Transition;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.PrePostPlacesMatch;

/**
 * A match processor tailored for the pn2sc.queries.prePostPlaces pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PrePostPlacesProcessor implements IMatchProcessor<PrePostPlacesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPrePlace the value of pattern parameter PrePlace in the currently processed match 
   * @param pPostPlace the value of pattern parameter PostPlace in the currently processed match 
   * @param pT the value of pattern parameter T in the currently processed match 
   * 
   */
  public abstract void process(final Place pPrePlace, final Place pPostPlace, final Transition pT);
  
  @Override
  public void process(final PrePostPlacesMatch match) {
    process(match.getPrePlace(), match.getPostPlace(), match.getT());
    
  }
}
