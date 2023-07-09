#Baseimage
FROM openjdk:17-jdk
#will get jar file and copy to image
COPY ./target/spring-25-Docker-0.0.1-SNAPSHOT.jar /usr/app/
#to direct any folder
WORKDIR /usr/app
#will provide executable appliication when container starts the run
ENTRYPOINT ["java","-jar","spring-25-Docker-0.0.1-SNAPSHOT.jar"]
