FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY . .

RUN ./gradlew clean build -x test --no-daemon

CMD ["./gradlew", "test", "-Dspring.profiles.active=docker"]