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

echo "Read,Transform,Save" > $outCSV

for i in `ls -1rS ${modelpath}/*.petrinet`; do
sourceFile=`basename ${i} .petrinet`
"$executable" \
  -basePath $modelpath -sourceFile $sourceFile \
  -debugTransform 0 -changeDriven 0 | cut -f 3,7,12 -d " " --output-delimiter "," >> $outCSV
done

#read -p "Press [ENTER] key to close."