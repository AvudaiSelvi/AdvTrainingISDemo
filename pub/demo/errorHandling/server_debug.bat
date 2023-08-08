set WM_HOME=C:\webmethods7
set IS_HOME=%WM_HOME%\IntegrationServer
set JAVA_HOME=%WM_HOME%\jvm\win150

set WD=%CD%
cd /d %IS_HOME%
%JAVA_HOME%\bin\jdb.exe -sourcepath %IS_HOME%\packages\AdvTrainingISDemo\code\source -Xms256M -Xmx512M -XX:MaxPermSize=128M -server -DWM_HOME=%WM_HOME% -classpath C:\webMethods7\IntegrationServer\lib\jdk11x_update.jar;%JAVA_HOME%\lib\classes.zip;%JAVA_HOME%\lib\i18n.jar;%IS_HOME%\lib\wm-isproxy.jar;%WM_HOME%\common\lib\wm-converters.jar;%IS_HOME%\config\Caching com.wm.app.server.Main %IS_HOME%\bin\ini.cnf -log none -debug info
cd /d %WD%