package pn2sc.common;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.ActivationState;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.specific.RecordingJob;

public class EnableableJob<Match extends IPatternMatch> extends RecordingJob<Match> {

	public static final String EXECUTE_JOB = "org.eclipse.incquery.evm.ExecEnabled";

	public EnableableJob(ActivationState activationState,
			IMatchProcessor<Match> matchProcessor) {
		super(activationState, matchProcessor);
	}
	@Override
	protected void execute(final Activation<Match> activation, final Context context) {
		if (context.get(EXECUTE_JOB) instanceof Boolean) {
			Boolean execEnabled = (Boolean) context.get(EXECUTE_JOB);
			if (execEnabled) {
				super.execute(activation, context);
			}
		}
	}


	public static <Match extends IPatternMatch> Job<Match> newEnableableJob(ActivationState activationState, IMatchProcessor<Match> processor){
		return new EnableableJob<Match>(activationState, processor);
	}
}
