@echo off
cls
setlocal 

rem Checking if runtime variables exist, otherwise takes ENV variables
if [%DOCKERDUI_LOCAL%] EQU [] (
 GOTO UI_LOCAL_VARS
) ELSE (
 GOTO SETFOLDERS
)

:UI_LOCAL_VARS
echo Setting DOCKERDUI_LOCAL home to %DOCKERDUI%
SET DOCKERDUI_LOCAL=%DOCKERDUI%


:SETFOLDERS
rem NOTHING to change here, only setting paths to webapp target directories
rem Setting target dir to latest dockerui build
cd /d %DOCKERDUI_LOCAL%/target/

for /f "tokens=*" %%1 in ('dir /b /ad /on dockerdui-*') do (
    set dockerduilatestdir=%%1
)
SET DOCKERDUI_TARGET_LOCAL=%DOCKERDUI_LOCAL%\target\%dockerduilatestdir%
setx DOCKERDUI_TARGET %DOCKERDUI_TARGET_LOCAL% /m
echo DOCKERDUI_TARGET target is set to %DOCKERDUI_TARGET_LOCAL%

