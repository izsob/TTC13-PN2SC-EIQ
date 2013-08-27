package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.NextStateMatch;
import statecharts.State;

/**
 * A match processor tailored for the pn2sc.queries.nextState pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NextStateProcessor implements IMatchProcessor<NextStateMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pState1 the value of pattern parameter State1 in the currently processed match 
   * @param pState2 the value of pattern parameter State2 in the currently processed match 
   * 
   */
  public abstract void process(final State pState1, final State pState2);
  
  @Override
  public void process(final NextStateMatch match) {
    process(match.getState1(), match.getState2());
    
  }
}
