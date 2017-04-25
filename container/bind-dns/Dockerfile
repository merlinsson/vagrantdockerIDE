#Version: 0.0.1
FROM sameersbn/bind:latest
MAINTAINER Merlin Rothhardt "merlin.rothhardt@gmail.com"
ENV REFRESHED_AT 2017-04-25

RUN apt-get update --fix-missing && apt-get upgrade -y
ADD ./zones/ /etc/bind/
ADD ./addresses/ /data/bind/lib/