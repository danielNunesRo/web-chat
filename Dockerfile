
FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests


FROM openjdk:17-slim

EXPOSE 8080

WORKDIR /app

COPY --from=build /app/target/chat-demo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
