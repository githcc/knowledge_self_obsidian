@echo off
echo  Successfully generated test.md

rem �������
set min=1
set max=10
set /a i=1

echo  If you are not satisfied with the result, you can run run.bat again. > test.md

rem ѭ�����
:loop
rem ���������
set /a num=%RANDOM% %% %max% + %min%

rem ��������
echo ![](%num%.mp3) >> test.md

rem �ж��Ƿ����ѭ��
if %i% == 4 goto end

rem ����ѭ��
set /a i+=1
goto loop

:end
pause