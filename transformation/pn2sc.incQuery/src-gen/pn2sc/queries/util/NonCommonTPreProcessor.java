package pn2sc.queries.util;

import PetriNet.Transition;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.NonCommonTPreMatch;

/**
 * A match processor tailored for the pn2sc.queries.nonCommonTPre pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NonCommonTPreProcessor implements IMatchProcessor<NonCommonTPreMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT the value of pattern parameter T in the currently processed match 
   * 
   */
  public abstract void process(final Transition pT);
  
  @Override
  public void process(final NonCommonTPreMatch match) {
    process(match.getT());
    
  }
}
