package pn2sc.queries.util;

import PetriNet.Place;
import PetriNet.Transition;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.PostTMatch;

/**
 * A match processor tailored for the pn2sc.queries.postT pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PostTProcessor implements IMatchProcessor<PostTMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pP the value of pattern parameter P in the currently processed match 
   * @param pT the value of pattern parameter T in the currently processed match 
   * 
   */
  public abstract void process(final Place pP, final Transition pT);
  
  @Override
  public void process(final PostTMatch match) {
    process(match.getP(), match.getT());
    
  }
}
