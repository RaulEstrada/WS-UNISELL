cls
cd %~dp0
cd src
"C:\Program Files\Java\jdk1.8.0_111\bin\java.exe" -Djavax.xml.accessExternalSchema=all -jar ..\tools\wsimport\jaxws-tools.jar -Xnocompile -extension -XadditionalHeaders -p uniovi.miw.unisell.data http://localhost:9090/WebServices/DataAccessWS.asmx?WSDL
pause
