@echo off
@REM ����api.openai.com
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
endlocal
pause