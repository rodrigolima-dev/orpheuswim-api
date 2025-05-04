
FROM maven:3.8.4-openjdk-17 as build

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests


FROM openjdk:17-slim

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]