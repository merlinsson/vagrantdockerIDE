#!/bin/bash
#Creating virtual network with default config
sudo docker network create dev-default --subnet=172.22.0.0/16 --gateway=172.22.0.1

#Build required containers

sudo docker-compose -f /opt/container/bind-dns/compose_bind_dns.yml build --no-cache
sudo docker-compose -f /opt/container/bind-dns/compose_bind_dns.yml up -d

sudo docker-compose -f /opt/container/nginx/compose_nginx_dev.yml build --no-cache
sudo docker-compose -f /opt/container/nginx/compose_nginx_dev.yml up -d

sudo docker-compose -f /opt/container/tomcat/compose-tomcat.yml build --no-cache
sudo docker-compose -f /opt/container/tomcat/compose-tomcat.yml up -d

