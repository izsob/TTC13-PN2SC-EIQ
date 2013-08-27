package pn2sc.queries.util;

import PetriNet.Transition;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.MoreThanOnePrePlaceMatch;

/**
 * A match processor tailored for the pn2sc.queries.moreThanOnePrePlace pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MoreThanOnePrePlaceProcessor implements IMatchProcessor<MoreThanOnePrePlaceMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT the value of pattern parameter T in the currently processed match 
   * 
   */
  public abstract void process(final Transition pT);
  
  @Override
  public void process(final MoreThanOnePrePlaceMatch match) {
    process(match.getT());
    
  }
}
