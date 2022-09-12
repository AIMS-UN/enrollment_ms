FROM amazoncorretto:17

MAINTAINER aims.unal.edu.co
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} enrollment_ms.jar
ENTRYPOINT ["java", "-jar", "/enrollment_ms.jar"]