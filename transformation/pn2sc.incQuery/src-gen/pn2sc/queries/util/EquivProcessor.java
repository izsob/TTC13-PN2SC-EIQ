package pn2sc.queries.util;

import PetriNet.NamedElement;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.EquivMatch;
import statecharts.State;

/**
 * A match processor tailored for the pn2sc.queries.equiv pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EquivProcessor implements IMatchProcessor<EquivMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pNamesElement the value of pattern parameter namesElement in the currently processed match 
   * @param pState the value of pattern parameter state in the currently processed match 
   * 
   */
  public abstract void process(final NamedElement pNamesElement, final State pState);
  
  @Override
  public void process(final EquivMatch match) {
    process(match.getNamesElement(), match.getState());
    
  }
}
