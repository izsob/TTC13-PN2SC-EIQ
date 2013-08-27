package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.RootOrMatch;
import statecharts.OR;

/**
 * A match processor tailored for the pn2sc.queries.rootOr pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class RootOrProcessor implements IMatchProcessor<RootOrMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRootOr the value of pattern parameter rootOr in the currently processed match 
   * 
   */
  public abstract void process(final OR pRootOr);
  
  @Override
  public void process(final RootOrMatch match) {
    process(match.getRootOr());
    
  }
}
