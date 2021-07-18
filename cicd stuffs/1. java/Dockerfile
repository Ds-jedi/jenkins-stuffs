For war
===========

FROM tomcat:8
LABEL author="dsuraj"
COPY /{JENKINS_HOME}/jobs/my-job/gameoflife.war   /usr/local/tomcat/webapps/gameoflife.war
EXPOSE 8080
CMD ["catalina.sh" ,"run"]

For jar
=====================

FROM openjdk:8
LABEL author="dsuraj"
WORKDIR /{JENKINS_HOME}/jobs/my-job/spring-petclinic.jar
EXPOSE 8080
ENTRYPOINT ["java"]
CMD ["-jar", "spring-petclinic-2.2.0.BUILD-SNAPSHOT.jar"]