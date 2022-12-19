FROM openjdk:17-alpine
WORKDIR /home/app
ARG JAR_FILE=build/libs/takehome-1.0.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/application.jar"]
