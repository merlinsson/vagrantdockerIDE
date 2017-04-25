@echo off
rem ####Setting ENV variables for web applications####
rem Path to the docker UI project
setx DOCKERDUI %DOCKERDUI_LOCAL% /m
echo Your DOCKERDUI is set to: %DOCKERDUI_LOCAL% 

rem You may set more maven projects as ENV-Variables here.


PAUSE
rem Sets ENV variables for builds in target folder of the different systems
call %~dp0\target-version-selection.bat

