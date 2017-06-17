cls
cd %~dp0
cd src
"C:\Program Files\Java\jdk1.8.0_111\bin\java.exe" -Djavax.xml.accessExternalSchema=all -jar ..\tools\wsimport\jaxws-tools.jar -Xnocompile -extension -XadditionalHeaders -p impl.uniovi.unisell.bpel http://156.35.98.14:57898/ws/PurchaseWS.asmx?WSDL
pause
