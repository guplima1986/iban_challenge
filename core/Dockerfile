FROM maven:3.8.1-openjdk-11 AS build

RUN mkdir "core"
COPY /src /core/src
COPY /pom.xml /core
COPY ../pom.xml /
RUN mvn -f /core/pom.xml clean package -Dmaven.test.skip
