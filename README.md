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
- Enter "vagrant up" and wait ... (The Setup can take a few minutes so you might grab a coffee)
- After the setup has been completed and the box is fully up and running you can enter "dev.dockerdui.de" in your browser to check if everything worked fine and the webapp is running

# Deployments
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
	- Install Linux Tools for Eclipse (https://wiki.eclipse.org/Linux_Tools_Project/Docker_Tooling/User_Guide#Introduction)
	- Open the Docker Explorer in STS
	- Create a new Docker daemon connection by adding this path: "http://127.0.0.1:2375"
	- When the connection was successful, you are able to see all running containers in the Vagrant box in the when opening the Docker explorer
	- Right click on the dev_dockerdui container and stop it for deployment procedures

# Debugging
- All logfiles of the web application as well as from the Nginx can be found in the rumtime directory of this project after the box has been started
- To remote debug the web application you can connect to "localhost:8043" (Tomcat debug mode is enabled by default)

# DNS
- You can configure the DEV-DNS by accessing the BIND-Web-UI using "https://192.168.50.2:10000" in your browser
- If you want your changes to be safed even if the DNS will be rebuild, you should add your new settings to the DNS-Configuration-Files in the container\bind-dns directory

# Virtual networks
The Nginx and the web application are connected by a nirtual docker network to enable the host name resolution between this containers. If you add your own web application and you want to make it accessible to the Nginx,
you should also add this container to the virtual network (dev-default) 

#Certificates
Most of the containers include a certs folder located in the single directories where the Dockerfiles are located in. If your whish to configure certificates for your application you might add your certs to this folder to make them available inside the container. (Can be used together with the Nginx or tomcat containers) 

# Comming soon
- Support for MacOS
- Better workaroud for ENV variables


 