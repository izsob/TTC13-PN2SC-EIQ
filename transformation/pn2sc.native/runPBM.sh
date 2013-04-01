#!/bin/bash

path="/home/ubuntu/ttc13/git/TTC13-PN2SC-EIQ/transformation/instances/performance"
cd $path

echo "Restore petrinets to original state."
/home/ubuntu/ttc13/git/TTC13-PN2SC-EIQ/transformation/pn2sc.native/cleanDir.sh $path
echo "Running the benchmark:"
echo ""

for i in `ls -1rS *.petrinet | head -n 11`; do
sourceFile=`basename ${i} .petrinet`
/home/ubuntu/ttc13/git/TTC13-PN2SC-EIQ/transformation/pn2sc.native/product/pn2sc/eclipse \
  -basePath $path -sourceFile $sourceFile \
  -debugTransform 0 -changeDriven 0 \
  -vmargs -Xmx896m -Xms896m
done

read -p "Press [ENTER] key to close."