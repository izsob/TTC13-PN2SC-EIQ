package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.EmptyOrMatch;
import statecharts.OR;

/**
 * A match processor tailored for the pn2sc.queries.emptyOr pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EmptyOrProcessor implements IMatchProcessor<EmptyOrMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOrState the value of pattern parameter orState in the currently processed match 
   * 
   */
  public abstract void process(final OR pOrState);
  
  @Override
  public void process(final EmptyOrMatch match) {
    process(match.getOrState());
    
  }
}
