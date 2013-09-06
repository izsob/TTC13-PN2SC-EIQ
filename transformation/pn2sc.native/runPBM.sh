#!/bin/bash

# Usage: runPBM.sh executable modelpath outCSV
# Parameters:
#   executable: path of the eclipse application that runs one transformation
#   modelpath: path of the folder, where .petrinet input models reside
#   outCSV: name of the output CSV file

executable="$1"
modelpath="$2"
outCSV="$3"


export DISPLAY=""

#cleanDir.sh $path

echo "Model,Phase,Type,Value,Unit" > $outCSV

for i in `ls -1rS ${modelpath}/*.petrinet | head -n 5`; do
echo "Processing input file ${i}" 
sourceFile=`basename ${i} .petrinet`
"$executable" \
  -basePath $modelpath -sourceFile $sourceFile \
  -debugTransform 0 -changeDriven 0 >> $outCSV
done

#read -p "Press [ENTER] key to close."