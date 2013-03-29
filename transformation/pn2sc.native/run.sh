#!/bin/bash

path="/home/benedek/data/research/ttc/runtime-Instances/instances"

sourceFile="testcases/testcase10-in.petrinet"
targetFile="testcases/testcase10-out.statecharts"
product/pn2sc/eclipse \
  -basePath $path -sourceFile $sourceFile -targetFile $targetFile \
  -debugTransform 0 -changeDriven 0
