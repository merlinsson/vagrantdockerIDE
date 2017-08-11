#Version: 0.0.1
FROM nginx:latest
MAINTAINER Merlin Rothhardt "merlin.rothhardt@gmail.com"
ENV REFRESHED_AT 2017-04-25
ARG env

#Installing logrotate for logging management
RUN apt-get -y update --fix-missing

# adding the local configuration
ADD ./config/$env/nginx/ /etc/nginx/


# adding certificates
RUN mkdir -p "/etc/nginx/certs/"
ADD ./certs/ /etc/nginx/certs/

#Logging management
RUN mkdir -p "/etc/nginx/logging/"

#Start nginx
ADD ./config/common/docker-start.sh /etc/init.d/docker-start.sh
CMD /bin/sh /etc/init.d/docker-start.sh
