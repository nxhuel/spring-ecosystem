# Etapa 1: construcción del jar
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: correr la aplicación
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=build app/target/restfull-api-0.0.1-SNAPSHOT.jar /app/restfull-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/restfull-api.jar"]