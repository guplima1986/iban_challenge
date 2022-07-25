FROM maven:3.8.1-openjdk-11 AS build

COPY /src /notification/src
COPY /pom.xml /notification
RUN mvn -f /notification/pom.xml clean package -Dmaven.test.skip

FROM openjdk:11
EXPOSE 8081
COPY --from=build /notification/target/*.jar notification.jar
ENTRYPOINT ["java", "-jar", "/notification.jar"]