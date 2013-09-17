package pn2sc;

import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import pn2sc.jobs.Pn2ScJobs;
import pn2sctrace.PN2SCTracemodel;
import pn2sctrace.Pn2sctraceFactory;

import com.google.common.base.Stopwatch;

public class MainApplication implements IApplication {



	private Resource stateChartResource;
	private Resource traceResource;

	private Config config;
	private Resource petriNetResource;
	private PN2SCTracemodel traceModel;
	private ResourceSetImpl resourceSet;
	private Stopwatch stopwatch;
	private AdvancedIncQueryEngine engine;
	private Pn2ScJobs pn2ScJobs;

	@Override
	public Object start(IApplicationContext appContext) throws Exception {

		String[] args = (String[])appContext.getArguments().get("application.args");
		// process program arguments
		config = new Config();
		config.processParameters(args);

		// load phase
		startWatch();
		loadModel();
		stopWatch("read");


		// transformation phase
		startWatch();

		// create empty rule set and helper job holder
		pn2ScJobs = new Pn2ScJobs(engine, petriNetResource, stateChartResource, traceResource);

		// perform initialisation and then transformation
		pn2ScJobs.transformPn2Sc();
		stopWatch("transformation");

		// save the models
		startWatch();
		traceResource.save(null);
		stateChartResource.save(null);
		petriNetResource.save(null);
		stopWatch("save");
		

		// Change driven demo
		if (config.getChangeDriven() == 1) {
//			changePropagation();
			System.out.println("Change driven code turned off");
			return -1;
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
			engine = AdvancedIncQueryEngine.from(IncQueryEngine.on(resourceSet));
			//new GroupOfFilePn2sc().prepare(engine);
		} catch (IncQueryException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}

//	public void changePropagation() {
//		try {
//
//			/* setup change propagation rules */
//			rules = pn2ScJobs.getCPRules();
//
//			/* setup rule engine */
//			// add name feature to watch updates
//			HashSet<EStructuralFeature> features = new HashSet<EStructuralFeature>();
//			features.add(PetriNetPackage.Literals.NAMED_ELEMENT__NAME);
//			engine.getBaseIndex().registerEStructuralFeatures(features);
//			//enginePN.getLogger().setLevel(Level.DEBUG);
//			
//			// create execution schema, set enablejobs to false before it, and true after
//			for(RuleSpecification<?> ruleSpec : rules) {
//				for(Job<?> job : ruleSpec.getJobs().values()) {
//					if (job instanceof EnableJob) {
//						((EnableJob<?>) job).setEnabled(false);
//					}
//				}
//			}
//			executionSchema = EventDrivenVM.createExecutionSchema(IncQueryEventRealm.create(engine), schedulerFactory, rules);
//			for(RuleSpecification<?> ruleSpec : rules) {
//				for(Job<?> job : ruleSpec.getJobs().values()) {
//					if (job instanceof EnableJob) {
//						((EnableJob<?>) job).setEnabled(true);
//					}
//				}
//			}
//			//Context context = executionSchema.getContext();
//			//context.put(EnableableJob.EXECUTE_JOB, false);
//
//			/* modify instance model */
//			pn2ScJobs.manipulate();
//			
//			// dispose schema
//			executionSchema.dispose();
//			rules.clear();
//		} catch (IncQueryException e) {
//			e.printStackTrace();
//			System.exit(1);
//		}
//	}

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
		//System.out.println("Model,Phase,Type,Value,Unit");
		System.out.println(config.getSourceFile() + "," + id + ",Time," + readTime + ",ms");
		System.out.println(config.getSourceFile() + "," + id + ",Memory," + (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()) + ",bytes");
	}

	@Override
	public void stop() {
	}

}
