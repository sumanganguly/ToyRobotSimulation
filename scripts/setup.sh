#!/bin/bash
JAVA_HOME="/cygdrive/c/Softwares/jdk1.7.0_40"
CLASSPATH="./../target/ToyRobotSimulation-1.0-SNAPSHOT.jar"

action=${1}
filelocation=${2}

$JAVA_HOME/bin/java -cp $CLASSPATH com.rea.robot.simulation.main.RobotSimulation "${action}" "${filelocation}"
