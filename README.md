# vagrantdockerIDE
This project represents a Vagrant box which automatically installs docker and docker-compose and sets up a whole web application environment including a simple web application, Nginx and BindDNS. This box has been optiomized to make frequently used development proccesses (Deployment, Hot-Deployment, Debugging etc.) possible.

# Preconditions
- Virtual box 5.0.26 or higher installed
- Vagrant 1.8.7 or higher installed
- Java JDK 1.8 or higher installed

This box has been used together with the Spring Tool Suit, so it is recommended to use a similar IDE to be able to used all tools of this box.

# Setup

- Checkout project ot the directory of your choice
- Change to the directory setup/windows and execute the setup-environment.bat script in ADMINISTRATOR mode
	- This script will set all variables required to get the box working (Maven project and Target path)
- Optionally you can open a new command line window in ADMINISTRATOR mode, cd to the setup/windows directory and execute the script in the command line. Anyway it is recommended to close the command line window after the setup has completed.
