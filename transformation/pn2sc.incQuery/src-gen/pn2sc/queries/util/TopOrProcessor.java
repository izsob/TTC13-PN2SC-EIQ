package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.TopOrMatch;
import statecharts.OR;

/**
 * A match processor tailored for the pn2sc.queries.topOr pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TopOrProcessor implements IMatchProcessor<TopOrMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOrState the value of pattern parameter orState in the currently processed match 
   * 
   */
  public abstract void process(final OR pOrState);
  
  @Override
  public void process(final TopOrMatch match) {
    process(match.getOrState());
    
  }
}
