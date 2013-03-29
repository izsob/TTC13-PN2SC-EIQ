#!/bin/bash

cd $1
git checkout -- . > /dev/null
git clean -d -x -f > /dev/null