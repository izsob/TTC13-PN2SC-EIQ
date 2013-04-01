TTC13-PN2SC-EIQ
===============

This repository contains the PN2SC solution of TTC 2013 for EMF-IncQuery.

Contents:
* metamodels: contains EMF metamodel of the Petri-Net, the Statechart and the Trace model
* transformation: contains the transformation code:
  * instances: Petri-Net input instance models, including the testcases and performance benchmark models
  * pn2sc.incQuery
     * src/pn2sc/queries/pn2sc.eiq: rule preconditions
     * src-processors/pn2sc/jobs/Pn2ScJobs.xtend: rule postconditions and rule definitions
  * pn2sc
     * src/pn2sc/MainApplication.java: Control code (Eclipse Application)
  * pn2sc.common: common utility code used by pn2sc and pn2sc.incQuery
  * pn2sc.native: contains some scripts to run the benchmark automatically from command line.
                  Run configurations and product definition can be dound in the pn2sc project
                  that can be used. (On plug-in version mismatch they need to be regenerated.)
