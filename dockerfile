FROM openjdk:8-jdk-alpine
VOLUME [ "/tmp" ]
COPY target/SpringBootFabricOpenShitDemo-0.0.1-SNAPSHOT.jar SpringBootFabricOpenShitDemo.jar
COPY src/* src/
COPY pom.xml pom.xml
COPY dockerfile dockerfile
ENTRYPOINT [ "java", "-jar","SpringBootFabricOpenShitDemo.jar" ]
