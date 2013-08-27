package pn2sc.queries.util;

import PetriNet.Place;
import PetriNet.Transition;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.TranWithTwoPostPlacesMatch;

/**
 * A match processor tailored for the pn2sc.queries.tranWithTwoPostPlaces pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TranWithTwoPostPlacesProcessor implements IMatchProcessor<TranWithTwoPostPlacesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT the value of pattern parameter T in the currently processed match 
   * @param pP1 the value of pattern parameter P1 in the currently processed match 
   * @param pP2 the value of pattern parameter P2 in the currently processed match 
   * 
   */
  public abstract void process(final Transition pT, final Place pP1, final Place pP2);
  
  @Override
  public void process(final TranWithTwoPostPlacesMatch match) {
    process(match.getT(), match.getP1(), match.getP2());
    
  }
}
