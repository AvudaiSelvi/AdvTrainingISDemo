set TOP="C:\webmethods7"
set CLASSPATH=%TOP%\common\lib\wm-isclient.jar;%TOP%\common\lib\ext\mail.jar
javac %1 -cp %CLASSPATH% AsynchInvoke.java