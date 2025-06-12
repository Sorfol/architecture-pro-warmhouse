FROM maven:3.9.9-eclipse-temurin-24 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:24.0.1_9-jdk

WORKDIR /app

COPY --from=builder /app/target/*.jar ./app.jar

EXPOSE 8082

CMD ["java", "-jar", "app.jar"]