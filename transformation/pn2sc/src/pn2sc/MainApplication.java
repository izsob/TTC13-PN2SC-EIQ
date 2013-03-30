package pn2sc;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.incquery.runtime.api.EngineManager;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.EventDrivenVM;
import org.eclipse.incquery.runtime.evm.api.ExecutionSchema;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.api.Scheduler.ISchedulerFactory;
import org.eclipse.incquery.runtime.evm.specific.UpdateCompleteBasedScheduler;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import PetriNet.PetriNetPackage;

import com.google.common.base.Stopwatch;

import pn2sc.common.Config;
import pn2sc.common.EnableableJob;
import pn2sc.common.ManageRealm;
import pn2sc.jobs.Pn2ScJobs;
import pn2sc.queries.GroupOfFilePn2sc;
import pn2sc.queries.equiv.EquivMatcher;
import pn2sc.queries.equivcontains.EquivContainsMatcher;
import pn2sc.queries.traceelement.TraceElementMatcher;
import pn2sctrace.PN2SCTracemodel;
import pn2sctrace.Pn2sctraceFactory;

public class MainApplication implements IApplication {

	private Resource stateChartResource;
	private Resource traceResource;

	private Config config;
	private Resource petriNetResource;
	private PN2SCTracemodel traceModel;
	private ResourceSetImpl resourceSet;
	private Stopwatch stopwatch;
	private IncQueryEngine engine;
	private ISchedulerFactory schedulerFactory;
	private Set<RuleSpecification<?>> rules;
	private ExecutionSchema executionSchema;
	private Pn2ScJobs pn2ScJobs;

	@Override
	public Object start(IApplicationContext appContext) throws Exception {

		String[] args = (String[])appContext.getArguments().get("application.args");
		// process program arguments
		config = new Config();
		config.processParameters(args);
		System.out.print(config.getSourceFile());

		// load phase
		startWatch();
		loadModel();
		stopWatch("read");


		// transformation phase
		startWatch();

		// create empty rule set and helper job holder
		rules = new HashSet<RuleSpecification<?>>();
		pn2ScJobs = new Pn2ScJobs(engine, petriNetResource, stateChartResource, traceResource, config.getBasePath(), config.getDebugTransform());
		pn2ScJobs.setMatchers(
				new EquivMatcher(engine), 
				new EquivContainsMatcher(engine), 
				new TraceElementMatcher(engine));

		// perform initialisation and then transformation
		initialisation();
		transformPn2Sc();
		stopWatch("transformation");

		// save the models
		startWatch();
		traceResource.save(null);
		stateChartResource.save(null);
		petriNetResource.save(null);
		stopWatch("model save");
		
		System.out.println("");


		// Change driven demo
		if (config.getChangeDriven() == 1) {
			changePropagation();
		}
		return IApplication.EXIT_OK;
	}

	private PN2SCTracemodel initTraceModel() {
		Pn2sctraceFactory factory = Pn2sctraceFactory.eINSTANCE;
		PN2SCTracemodel pn2scTracemodel = factory.createPN2SCTracemodel();
		return pn2scTracemodel;
	}

	/* 
	 * Load source PetriNet and create StateChart and the trace model.
	 */
	public void loadModel() {
		// create resource set for resources: petrinet, statechart, tracemodel
		resourceSet = new ResourceSetImpl();
		// read petrinet
		URI sourceURI = URI.createFileURI(config.getBasePath() + "/" + config.getSourceFile()+".petrinet");
		petriNetResource = resourceSet.getResource(sourceURI, true);
		
		// create statechart
		URI targetURI = URI.createFileURI(config.getBasePath() + "/" + config.getSourceFile()+".statecharts");
		stateChartResource = resourceSet.createResource(targetURI);
		// create trace model
		URI traceURI = URI.createFileURI(config.getBasePath() + "/" + config.getSourceFile()+".pn2sctrace");
		traceResource = resourceSet.createResource(traceURI);
		traceModel = initTraceModel();
		traceResource.getContents().add(traceModel);

		// start engine for the resources
		try {
			engine = EngineManager.getInstance().getIncQueryEngine(resourceSet);
			new GroupOfFilePn2sc().prepare(engine);
		} catch (IncQueryException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		schedulerFactory = UpdateCompleteBasedScheduler.getIQBaseSchedulerFactory(engine);
		
	}

	/*
	 * Run the initialisation phase of the transformation.
	 */
	public void initialisation() {
		// place->OR mapping
		rules = pn2ScJobs.getInitialisationRules();

		// execute rule engine
		executionSchema = EventDrivenVM.createExecutionSchema(engine, schedulerFactory, rules);
		executionSchema.dispose();
	}

	public void transformPn2Sc() {
		// execute AND and OR rules, and StateChart creation at the end
		rules = pn2ScJobs.getAndOrRules();
		executionSchema = EventDrivenVM.createExecutionSchema(engine, schedulerFactory, rules);
		executionSchema.dispose();
	}

	public void changePropagation() {
		try {
			ManageRealm.setUp();

			/* setup change propagation rules */
			rules = pn2ScJobs.getCPRules();

			/* setup rule engine */
			// add name feature to watch updates
			HashSet<EStructuralFeature> features = new HashSet<EStructuralFeature>();
			features.add(PetriNetPackage.Literals.NAMED_ELEMENT__NAME);
			engine.getBaseIndex().registerEStructuralFeatures(features);
			//enginePN.getLogger().setLevel(Level.DEBUG);
			
			// create execution schema
			executionSchema = EventDrivenVM.createExecutionSchema(engine, schedulerFactory);
			Context context = executionSchema.getContext();
			// fire initial rules, but disable executing actions for pre-existing elements
			context.put(EnableableJob.EXECUTE_JOB, false);
			for(RuleSpecification<?> ruleSpecification : rules) {
				executionSchema.addRule(ruleSpecification, true);
			}
			// enable execution actions for newly created elements
			context.put(EnableableJob.EXECUTE_JOB, true);

			/* modify instance model */
			pn2ScJobs.manipulate();
			
			// dispose schema
			executionSchema.dispose();
			rules.clear();
			ManageRealm.tearDown();
		} catch (IncQueryException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/*
	 * Start measuring time
	 */
	public void startWatch() {
		stopwatch = new Stopwatch().start();
	}

	/* 
	 * Stop measuring time, and print elapsed time in millisecs
	 */
	public void stopWatch(String id) {
		stopwatch.stop();
		long readTime = stopwatch.elapsedTime(TimeUnit.MILLISECONDS);
		System.out.print(" " + id + ": " + readTime + " ms ");
	}

	@Override
	public void stop() {
	}

}
