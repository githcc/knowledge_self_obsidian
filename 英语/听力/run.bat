@echo off
echo  Successfully generated test.md (minimum 1.mp3, maximum 10.mp3, quantity 4, some duplicates exist), preview mode to view test.md

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