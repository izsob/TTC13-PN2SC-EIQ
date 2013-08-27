package pn2sc.queries.util;

import PetriNet.Place;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.PlaceMatch;

/**
 * A match processor tailored for the pn2sc.queries.place pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PlaceProcessor implements IMatchProcessor<PlaceMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pP the value of pattern parameter p in the currently processed match 
   * 
   */
  public abstract void process(final Place pP);
  
  @Override
  public void process(final PlaceMatch match) {
    process(match.getP());
    
  }
}
