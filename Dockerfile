# Build stage
FROM maven:3.9.9-eclipse-temurin-22-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app
RUN mvn clean package

# Package stage
FROM eclipse-temurin:22-jre-alpine
COPY --from=build /home/app/target/your-app.jar /usr/local/lib/your-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/your-app.jar"]
