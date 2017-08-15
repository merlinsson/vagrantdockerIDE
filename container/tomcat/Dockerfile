FROM tomcat:8.5-jre8-alpine
MAINTAINER Merlin Rothhardt "merlin.rothhardt@gmail.com"
ENV REFRESHED_AT 2017-04-25

# Adding sh to alpine, not supported by default
# RUN apk add --update bash && rm -rf /var/cache/apk/*
# Just required when you want to: "docker exec -i -t config_tcone_1 /bin/bash" into your container.
# Alternatively use: "docker exec -i -t config_tcone_1 /bin/ash", it uses busy box shell, see also:
# http://stackoverflow.com/questions/35689628/starting-a-shell-in-the-docker-alpine-container

# Adding certs to tomcat
ADD ./certs/ /usr/local/tomcat/certs/

# Adding configured server.xml to tomcat
ADD ./config/server.xml      /usr/local/tomcat/conf/server.xml

# Adding tomcat useres for hotdeployment
ADD ./config/tomcat-users.xml      /usr/local/tomcat/conf/tomcat-users.xml

# Adding manager access rules
ADD ./config/manager.xml      /usr/local/tomcat/conf/Catalina/localhost/manager.xml

# Adding ENV file for environment parameters
ADD ./config/setenv.sh /usr/local/tomcat/bin/setenv.sh