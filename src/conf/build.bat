@echo off
set JCA_HOME=..\..
set ANT_HOME=%JCA_HOME%/lib/ant
%JAVA_HOME%\bin\java.exe -classpath "%ANT_HOME%\lib\ant.jar;%ANT_HOME%\lib\bcel.jar;%JAVA_HOME%\lib\tools.jar" "-Dant.home=%ANT_HOME%" "-Djavax.xml.transform.TransformerFactory=org.apache.xalan.processor.TransformerFactoryImpl" org.apache.tools.ant.Main -f %JCA_HOME%/src/conf/build.xml  %* 

:END
if "%NOPAUSE%" == "" pause

:END_NO_PAUSE
