#Version: 0.0.1
FROM nginx
MAINTAINER Merlin Rothhardt "merlin.rothhardt@gmail.com"
ENV REFRESHED_AT 2017-04-25
ARG env

#Installing logrotate for logging management
RUN apt-get -y update && apt-get install -y logrotate cron vim

# adding the local configuration
ADD ./config/$env/nginx/ /etc/nginx/


# adding certificates
RUN mkdir -p "/etc/nginx/certs/"
ADD ./certs/ /etc/nginx/certs/

#Logging management
RUN mkdir -p "/etc/nginx/logging/"
ADD ./config/common/nginx-logrotate /etc/logrotate.d/nginx-logrotate
RUN chmod 644 /etc/logrotate.d/nginx-logrotate

#Start nginx
ADD ./config/common/docker-start.sh /etc/init.d/docker-start.sh
CMD /bin/sh /etc/init.d/docker-start.sh
