@echo off
echo 该工程编译需要JDK5.0或以上版本，请保证已设置JAVA_HOME环境变量为JDK5安装目录
@echo off
if "%JAVA_HOME%" == "" goto error
@echo on
"%JAVA_HOME%/bin/java" -cp lib/ant/ant.jar;lib/ant/ant-launcher.jar;lib/ant/ant-contrib.jar;"%JAVA_HOME%/lib/tools.jar" -Dmode=%2 org.apache.tools.ant.launch.Launcher -buildfile build.xml %1
