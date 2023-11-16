@echo off
echo  Successfully generated test.md

rem 定义变量
set min=1
set max=10
set /a i=1

echo  If you are not satisfied with the result, you can run run.bat again. > test.md

rem 循环输出
:loop
rem 生成随机数
set /a num=%RANDOM% %% %max% + %min%

rem 输出随机数
echo ![](%num%.mp3) >> test.md

rem 判断是否继续循环
if %i% == 4 goto end

rem 继续循环
set /a i+=1
goto loop

:end
pause