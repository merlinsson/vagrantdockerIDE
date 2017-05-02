#export CATALINA_OPTS="$CATALINA_OPTS -Dfile.encoding=Cp1252 -Xms256m -Xmx1024m -XX:MaxPermSize=512m"

# with debug
export CATALINA_OPTS="$CATALINA_OPTS -Dfile.encoding=Cp1252 -DDOCKERD_HOST=http://www.dev-dockerd.de:2375/v1.28 -Xms256m -Xmx1024m -XX:MaxPermSize=512m -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8043"