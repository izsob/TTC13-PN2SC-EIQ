package pn2sc.queries.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.HasRcontainsMatch;
import statecharts.Compound;

/**
 * A match processor tailored for the pn2sc.queries.hasRcontains pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class HasRcontainsProcessor implements IMatchProcessor<HasRcontainsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pFrom the value of pattern parameter from in the currently processed match 
   * 
   */
  public abstract void process(final Compound pFrom);
  
  @Override
  public void process(final HasRcontainsMatch match) {
    process(match.getFrom());
    
  }
}
