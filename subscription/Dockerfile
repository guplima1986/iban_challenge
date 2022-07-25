FROM maven:3.8.1-openjdk-11 AS build

COPY /src /subscription/src
COPY /pom.xml /subscription
RUN mvn -f /subscription/pom.xml clean package -Dmaven.test.skip

FROM openjdk:11
COPY --from=build /subscription/target/*.jar subscription.jar
ENTRYPOINT ["java", "-jar", "/subscription.jar"]