FROM openjdk

VOLUME /tmp
ADD maven/beer-nrc-@project.version@.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]