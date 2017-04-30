# vagrantdockerIDE
This project represents a Vagrant box which automatically installs docker and docker-compose and sets up a whole web application environment including a simple web application, Nginx and BindDNS. This box has been optiomized to make frequently used development proccesses (Deployment, Hot-Deployment, Debugging etc.) possible.

# Preconditions
- Windows 7 or higher
- Virtual box 5.0.26 or higher installed (Or you may use your prefered hypervisor which is compatible to Vagrant)
- Vagrant 1.8.7 or higher installed
- Java JDK 1.8 or higher installed

This box has been used together with the Spring Tool Suit, so it is recommended to use a similar IDE to be able to use all tools of this box.

# Setup

- Checkout project ot the directory of your choice
- Change to the directory setup/windows and execute the setup-environment.bat script in ADMINISTRATOR mode
	- This script will set all variables required to get the box working (Maven project and Target path)
- Optionally you can open a new command line window in ADMINISTRATOR mode, cd to the setup/windows directory and execute the script in the command line. Anyway it is recommended to close the command line window after the setup has completed. (Enrivonment variables have been refreshed)

When you completed these steps you are ready to launch the vagrant box.

# Vagrant launch
To get the whole system running you have to execute the following steps:

- Add the entry "192.168.50.2 dev.dockerdui.de" to your host file (C:\Windows\System32\drivers\etc\hosts)
- Open a new command line window in ADMINISTRATOR mode
- Change to the root directory of this project where the Vagrantfile is located
- Enter "vagrant up" and wait ... (The Setup can take a few minutes so you might grap a coffee)
- After the setup has been completed and the box is fully up and running you can enter "dev.dockerdui.de" in your browser to check if everything worked fine and the webapp is running

# Features
Firstly add the Maven project "dockerdui" (webapp/dockerdui) to your favourite IDE.

- You can make changes to the project and then execute the Maven goal "install" which will force a Hot-Deployment of the web application

- You can use the Maven goal "clean" to force an undeployment of the web application

- You can use the Maven goal "clean install" to force a new deployment of the web application

For the goal "clean" and "clean install" you might need to stop the "dev_dockerdui" container first, this can be accomplished by executing the following steps:
- If you already have a command line interface running, change to the root directroy of the Project and use the command "vagrant ssh" to connect to the vagrant machine
	- Run "docker stop dev_dockerdui" inside the vagrant box to stop the container
	- Execute "clean" or "clean install" on your host
	- Run "docker start dev_dockerdui" inside the vagrant box to start the container

- When using Eclipse (e.g. STS) you can also install Docker\Linux-Tools for Eclipse and use it to restart the container (Much easier then connection to the vagrant box)

More documentation will follow soon...
 