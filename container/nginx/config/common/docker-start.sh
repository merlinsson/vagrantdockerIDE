#!/bin/sh

# Start NGINX
log_daemon_msg "Starting NGINX"
nginx -g 'daemon off;'