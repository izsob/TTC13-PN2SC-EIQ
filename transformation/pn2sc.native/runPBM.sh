#!/bin/bash

path="/home/benedek/data/research/ttc/runtime-Instances/instances/performance"
cd $path

for i in `ls -1rS *.petrinet`; do
sourceFile=${i}
targetFile=`basename ${i} .petrinet`.statecharts
/home/benedek/data/research/ttc/runtime-Instances/pn2sc.native/product/pn2sc/eclipse \
  -basePath $path -sourceFile $sourceFile -targetFile $targetFile \
  -debugTransform 0 -changeDriven 0
done
