FROM openjdk:22-jdk
LABEL authors="jorgecardenas"

ARG JAR_FILE=build/libs/flightapp-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} flightapp.jar

ENTRYPOINT ["java", "-jar", "/flightapp.jar"]

EXPOSE 8080