#!/bin/bash

# udapte repo
apt-get update

# install docker
apt-get install -y curl 
curl -sSL https://get.docker.com/ | sh 

#Setting userts for docker
usermod -aG docker ubuntu

#Installing docker-compose and setting rights
curl -L https://github.com/docker/compose/releases/download/1.7.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose

chmod +x /usr/local/bin/docker-compose