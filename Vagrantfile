# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|

	config.vm.provider "virtualbox" do |v|
		v.memory = 8096
		v.cpus = 4
		v.name = "DEV - DockerVirtual"
        #Activated the dnshostresolver, to pass DNS queries to the host.
        #This option gets currently disabled and the box will get an DNS-Server address which
        #points to nowhere... (Bad Bugfix?). Anyway, this option will enable the host resolver and 
        #DNS queries get forwarded to the host.
        v.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
	end
	
	#Configure box
    config.vm.box = "ubuntu/xenial64"
    config.vm.box_version= "20170311.0.0"
    config.vm.box_check_update = false
	config.vm.boot_timeout = 600
	
    #Configure static private IP
    config.vm.network "private_network", ip: "192.168.50.2"
    
    # Triggers a check on startup of the webapps version in order to map the newest webapp from the target directory to the vagrant machine.
	# Additonally, external services which are running on the host can be started by using the "start_external_services.bat" script.
    config.trigger.before :up do
    vagrant_dir = File.expand_path(File.dirname(__FILE__))
    version_file = vagrant_dir + '/setup/windows/scripts/target-version-selection.bat'
    external_file = vagrant_dir + '/setup/windows/scripts/start-external-services.bat'
      run version_file
      run external_file
    end
    
	# Refreshed the webapp version when box is shut down
    config.trigger.before :halt do
    vagrant_dir = File.expand_path(File.dirname(__FILE__))
    version_file = vagrant_dir + '/setup/windows/scripts/target-version-selection.bat'
      run version_file
    end
    
	# Refreshed the webapp version when box is reloaded
    config.trigger.before :reload do
    vagrant_dir = File.expand_path(File.dirname(__FILE__))
    version_file = vagrant_dir + '/setup/windows/scripts/target-version-selection.bat'
      run version_file
    end
    
    #DIR of containers
	config.vm.synced_folder "./container", "/opt/container"
    

    #Mapping of logfiles
    config.vm.synced_folder "./runtime/logs", "/var/log/dev"
    
	#Mapping of project webapp target directory for tomcats
    config.vm.synced_folder ENV['DOCKERDUI_TARGET'], "/opt/server/dockerdui"
	
    # Config scripts after machine has been booted
	config.vm.provision :shell, path: "./vagrant-setup/docker/docker_setup.sh"
    config.vm.provision :shell, path: "./vagrant-setup/docker/daemon-restart.sh", run: 'always', privileged: true
    config.vm.provision :shell, path: "./vagrant-setup/docker/build-start-base-container.sh", privileged: true
    
    #Port mappings for docker daemon
    config.vm.network :forwarded_port, host: 2375, guest: 2375  
	
	#Port mappings for DNS
    config.vm.network :forwarded_port, host: 10000, guest: 10000
	
	#Port mappings for Tomcat debug port
    config.vm.network :forwarded_port, host: 8043, guest: 8043  

end
