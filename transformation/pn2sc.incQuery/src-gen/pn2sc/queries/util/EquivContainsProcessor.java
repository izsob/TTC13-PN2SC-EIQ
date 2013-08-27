package pn2sc.queries.util;

import PetriNet.NamedElement;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.EquivContainsMatch;
import statecharts.State;

/**
 * A match processor tailored for the pn2sc.queries.equivContains pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EquivContainsProcessor implements IMatchProcessor<EquivContainsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pNamedElement the value of pattern parameter namedElement in the currently processed match 
   * @param pState the value of pattern parameter State in the currently processed match 
   * 
   */
  public abstract void process(final NamedElement pNamedElement, final State pState);
  
  @Override
  public void process(final EquivContainsMatch match) {
    process(match.getNamedElement(), match.getState());
    
  }
}
