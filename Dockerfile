FROM node:14 as builderfront
COPY frontend /frontend
WORKDIR /frontend/
RUN npm install
RUN npm install -g @angular/cli
RUN ng build

FROM maven:3.8.1-jdk-11 as builderback
COPY src /backend/src
COPY pom.xml /backend/pom.xml
COPY --from=builderfront /frontend/dist/* /backend/src/main/resources/static
RUN mvn -f /backend/pom.xml clean package

FROM openjdk:11-jre
COPY --from=builderback /backend/target/*.jar /usr/app/app.jar
WORKDIR /usr/app
CMD [ "java", "-jar", "app.jar" ]