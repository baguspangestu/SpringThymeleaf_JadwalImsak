FROM openjdk:17-jdk-alpine
WORKDIR /opt/app
COPY target/kuis-0.0.1-SNAPSHOT.jar kuis.jar
EXPOSE 8080
ENTRYPOINT exec java -jar kuis.jar