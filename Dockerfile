FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} retrieve.jar
ENTRYPOINT ["java","-jar","/retrieve.jar"]
