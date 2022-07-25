FROM maven:3.8.1-openjdk-11 AS build

COPY /src /core/src
COPY /pom.xml /core
RUN mvn -f /core/pom.xml clean package -Dmaven.test.skip
