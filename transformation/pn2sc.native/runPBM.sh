#!/bin/bash

path="/home/ubuntu/ttc13/git/TTC13-PN2SC-EIQ/transformation/instances/performance"
cd $path

/home/ubuntu/ttc13/git/TTC13-PN2SC-EIQ/transformation/pn2sc.native/cleanDir.sh $path

for i in `ls -1rS *.petrinet`; do
sourceFile=`basename ${i} .petrinet`
/home/ubuntu/ttc13/git/TTC13-PN2SC-EIQ/transformation/pn2sc.native/product/pn2sc/eclipse \
  -basePath $path -sourceFile $sourceFile \
  -debugTransform 0 -changeDriven 0
done

read -p "Press [ENTER] key to close."