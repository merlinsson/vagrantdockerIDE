@echo off
set current=%~dp0
cd %current%
pushd ..\..\webapp\dockerdui
set webapp=%cd%
popd

rem Path to the dockerdui project, you may add additonal maven projects here.
SET DOCKERDUI_LOCAL=%webapp%

rem Build projects
call ./scripts/build-projects.bat

rem ### INSALLATION SECTION DO NOT CHANGE!!! ###

rem NOTHING to change here, only setting some required ENV varibales.
call ./scripts/set-environment-variables.bat

rem You may use this, to install programs required for you environment on the host system.
rem echo Installing software on host machine.
rem call .\installer\<YOUR_INSTALLER>.exe


rem ######## Custom installation scripts #######
rem Installing vagrant guest additions for proper folder syncs as well as the trigger extension
call ./vagrant-plugins/vagrant-additions.bat

ECHO Press any key to exit
PAUSE >NUL
EXIT /B