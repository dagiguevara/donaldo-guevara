# Petstore API Tests

This project contains automated tests for the [Swagger Petstore](https://petstore3.swagger.io/) RESTful API, focusing on the `User` domain. The framework is designed to be scalable, maintainable, and CI/CD-ready using Docker and GitHub Actions.

---

## Tech Stack

| Tool/Library        | Purpose                                |
|---------------------|----------------------------------------|
| **Java 17**         | Main programming language              |
| **Gradle**          | Build tool and dependency management   |
| **Spring Boot**     | Configuration and DI container         |
| **JUnit 5**         | Testing framework                      |
| **Rest Assured**    | Fluent API for REST API testing        |
| **Lombok**          | Cleaner model class generation         |
| **Allure**          | Test reporting                         |
| **Spotless**        | Code formatting & style enforcement    |
| **Docker Compose**  | Orchestrates API + test runner         |

---

## Setup

1. **Clone the repo:**

   ```bash
   git clone https://github.com/dagiguevara/donaldo-guevara.git
   cd petstore-api-tests

2. **Run Docker-based local setup:**

   ```bash
   docker compose up --build --abort-on-container-exit

3. **Run locally from IDE or CLI:**

   ```bash
   docker run -d --name petstore-api -p 8080:8080 swaggerapi/petstore3:unstable

4. **Run the tests with Gradle:**

   ```bash
   ./gradlew test -Dspring.profiles.active=local
   
## Design Approach

- Organized and Clean: Clients, models, and test logic are clearly separated.
- Scalability: Adding support for Pet or Store is as simple as adding a new client + test package.
- Reusability: Common user creation is handled through a UserFactory.
- Spring Boot DI: Easily manage configuration and client classes via Spring’s dependency injection.
- Docker-Ready: Ensures local parity and simplified CI environment.

## Running in CI

CI is handled with GitHub Actions:

- The API service is started in a Docker container.
- Tests are run using ./gradlew test.
- Allure reports are generated and uploaded as artifacts.

## Reports

**After running tests locally:**
   ```bash
       ./gradlew allureReport
       ./gradlew allureServe
   ```

## Linting / Formatting
To check code format:
   ```bash
       ./gradlew spotlessCheck
   ```
To auto-format:
   ```bash
       ./gradlew spotlessApply
   ```

## Makefile

## Tech Stack

| Command                 | Description                                         |
|-------------------------|-----------------------------------------------------|
| **make build**          | Configuration and DI container                      |
| **make up**             | Start the Petstore API service only                 |
| **make down**           | Stop and remove all containers and volumes          |
| **make test-docker**    | Run tests inside Docker using Docker Compose        |
| **make test-local**     | Run tests locally (assumes Petstore API is running) |
| **make report**         | Generate and serve the Allure report locally        |
| **make spotless-check** | Check code formatting using Spotless                |
| **make spotless-apply** | Auto-format code using Spotless                     |
