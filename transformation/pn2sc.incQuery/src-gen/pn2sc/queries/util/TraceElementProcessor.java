package pn2sc.queries.util;

import PetriNet.NamedElement;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import pn2sc.queries.TraceElementMatch;
import pn2sctrace.MapTrace;

/**
 * A match processor tailored for the pn2sc.queries.traceElement pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TraceElementProcessor implements IMatchProcessor<TraceElementMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSmElement the value of pattern parameter SmElement in the currently processed match 
   * @param pTrace the value of pattern parameter Trace in the currently processed match 
   * 
   */
  public abstract void process(final NamedElement pSmElement, final MapTrace pTrace);
  
  @Override
  public void process(final TraceElementMatch match) {
    process(match.getSmElement(), match.getTrace());
    
  }
}
