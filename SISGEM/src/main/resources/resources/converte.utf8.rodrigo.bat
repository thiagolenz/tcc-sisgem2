@echo off
echo Gera o arquivo com os escapes do utf8 usado pelo InputStream.
echo.
echo .. the input/output stream is encoded in ISO 8859-1 character encoding. Characters that cannot be directly represented in this encoding can be written using Unicode escapes ; only a single 'u' character is allowed in an escape sequence. The native2ascii tool can be used to convert property files to and from other character encodings.

e:
cd \GIT\documento\ConlabWeb\src\main\resources\resources

"c:\Program Files\Java\jdk1.8.0_05\bin\native2ascii.exe" -encoding UTF-8 labels_pt.properties.utf8 labels_pt.properties

echo.

pause