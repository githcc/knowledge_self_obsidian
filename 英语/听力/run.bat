@echo off
echo Successfully generated test.md

rem Define variables
set min=1
set max=10
set /a i=1

echo If you are not satisfied with the result, you can run run.bat again. > test.md

rem Loop output
:loop
rem Generate random number
set /a num=%RANDOM% %% %max% + %min%

rem Output random number
echo ![](%num%.mp3) >> test.md

rem Check whether to continue the loop
if %i% == 4 goto end

rem Continue the loop
set /a i+=1
goto loop

:end
pause