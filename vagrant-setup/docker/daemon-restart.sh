#!/bin/bash
sudo rm -rf /etc/systemd/system/docker.service.d
sudo mkdir /etc/systemd/system/docker.service.d
sudo cp /vagrant/vagrant-setup/docker/custom.conf /etc/systemd/system/docker.service.d/custom.conf
sudo systemctl daemon-reload
sudo systemctl restart docker
echo Docker service was restarted for configuration changes
echo Docker daemon access is set to tcp://0.0.0.0:2375
echo Docker daemon primary DNS is set to 192.168.50.2
sudo ps aux | grep docker | grep -v grep