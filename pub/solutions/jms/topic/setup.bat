@echo off
rem webMethods installation directory
set WM_HOME=C:\SoftwareAG
set JAVA_HOME=%WM_HOME%\jvm\win160\bin
set Path=%PATH%;%WM_HOME%\jvm\win160\bin

rem classpath for JMS
set JMS_CLASSPATH=%WM_HOME%\Broker\lib\jms.jar;%WM_HOME%\Broker\lib\wm-jmsclient.jar

rem classpath for JNDI
set JNDI_CLASSPATH=%WM_HOME%\Broker\lib\wm-brokerclient.jar;%WM_HOME%\Broker\lib\wm-jmsnaming.jar;%WM_HOME%\common\lib\wm-g11nutils.jar

set CLASSPATH=.;%JMS_CLASSPATH%;%JNDI_CLASSPATH%;%CLASSPATH%

echo CLASSPATH=%CLASSPATH%
