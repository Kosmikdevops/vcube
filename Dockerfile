From tomcat:9 
MAINTAINER "vcube"
COPY ./target/VCubeDataManagmentSoftware-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/
EXPOSE 8080
