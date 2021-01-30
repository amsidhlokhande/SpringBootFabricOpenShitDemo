FROM openjdk:8-jdk-alpine
VOLUME [ "/tmp" ]
COPY target/springbootfabricopenshitdemo-0.0.1-SNAPSHOT.jar springbootfabricopenshitdemo.jar
COPY src/* src/
COPY pom.xml pom.xml
COPY dockerfile dockerfile
ENTRYPOINT [ "java", "-jar","springbootfabricopenshitdemo.jar" ]
