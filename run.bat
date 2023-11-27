@echo off
@REM Powered by OpenAI
setlocal enabledelayedexpansion
echo.
for /d %%i in (*) do (
    echo %%i
    pushd "%%i"
    for /d %%j in (*) do (
        echo     - %%j
    )
    popd
    echo.
)

set count=0

for /r %%F in (*) do (
    if not "%%~aF"=="d" (
        set /a count+=1
    )
)

echo Total files in the current directory and its subdirectories: %count%
endlocal
pause