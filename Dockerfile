FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/kuis-0.0.1-SNAPSHOT.jar kuis.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar kuis.jarl