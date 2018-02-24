#!/bin/bash
usage() {
    echo "Please enter the build mode, deploy or deployJar?"
    exit 1;
}

if [ $# -lt 1 ]; then
    usage
fi
if [ -z "$JAVA_HOME" ]; then
  JAVA_HOME=/home/forall_mall/jdk
fi

if [ ! -f "$JAVA_HOME/bin/java" ]; then
  echo "Please setup the JAVA_HOME"
  exit 1;
fi

export JAVA_HOME

START_OPT="-Dmode=$2"

$JAVA_HOME/bin/java -classpath lib/ant/ant.jar:lib/ant/ant-launcher.jar:lib/ant/ant-contrib.jar:"$JAVA_HOME/lib/tools.jar" $START_OPT org.apache.tools.ant.launch.Launcher -buildfile build.xml $1

if [ $? != 0 ]; then
   exit 1;
fi
