#!/bin/bash

# usage:
# 1st param is the input model without extension inside "path" (see below). 
# ./run.sh testcases/testcase1-in

path="/home/ubuntu/ttc13/git/TTC13-PN2SC-EIQ/transformation/instances"
sourceFile=$1

# revert instance model changes
echo "Clean old changes"
cd $path
git checkout ${sourceFile}.petrinet 2> /dev/null
rm ${path}/${sourceFile}.statecharts 2> /dev/null
rm ${path}/${sourceFile}.pn2sctrace 2> /dev/null

echo "Run transformation benchmark"
echo
# run transformation
/home/ubuntu/ttc13/git/TTC13-PN2SC-EIQ/transformation/pn2sc.native/product/pn2sc/eclipse \
  -basePath $path -sourceFile ${sourceFile} \
  -debugTransform 0 -changeDriven 0

echo
echo "Output is saved to ${path}/${sourceFile}.[petrinet | statecharts | pn2sctrace]"
echo
read -p "Press [ENTER] key to close."
