set JAVA_HOME=C:/Softwares/jdk1.7.0_40
set CLASSPATH="./../target/ToyRobotSimulation-1.0-SNAPSHOT.jar"

set action=%1
set filelocation=%2

%JAVA_HOME%/bin/java -cp %CLASSPATH% com.rea.robot.simulation.main.RobotSimulation "%action%" "%filelocation%"
