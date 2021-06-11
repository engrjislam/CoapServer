#FROM openjdk:8
#FROM openjdk:8-alpine

FROM openjdk:8-jre-alpine
RUN mkdir -p /usr/src/coapserver
COPY target/CoapServer-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/src/coapserver/CoapServer.jar
WORKDIR /usr/src/coapserver
EXPOSE 5683/udp
CMD ["java", "-jar", "CoapServer.jar"]
