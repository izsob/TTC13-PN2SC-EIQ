package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.SingleRootOrMatch;

/**
 * A match processor tailored for the pn2sc.queries.singleRootOr pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SingleRootOrProcessor implements IMatchProcessor<SingleRootOrMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * 
   */
  public abstract void process();
  
  @Override
  public void process(final SingleRootOrMatch match) {
    process();
    
  }
}
