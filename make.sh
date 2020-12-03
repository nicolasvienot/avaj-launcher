#!/bin/bash

if [ $# -eq 0 ]; then
    find * -name "*.java" > sources.txt
    javac @sources.txt
    echo "You should now be able to use :"
    echo "$ java -cp src com.avaj.simulator.Simulator scenario.txt"
elif [ $# -eq 1 -a "$1" = "clean" ]; then
    rm -rf $(find . -name "*.class")
    rm -rf simulation.txt
    rm -rf sources.txt
else
    echo "Usage : bash make.sh [clean]"
fi

