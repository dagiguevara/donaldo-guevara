# Monefy Mobile Test Automation

This project contains automated UI tests for the [Monefy Android app](https://play.google.com/store/apps/details?id=com.monefy.app.lite), built using Appium and Java. The framework is designed for maintainability, scalability, and CI/CD compatibility.

---

## Tech Stack

| Tool/Library       | Purpose                                |
|--------------------|----------------------------------------|
| **Java 17**        | Main programming language              |
| **Gradle**         | Build tool and dependency management   |
| **Spring Boot**    | Configuration and DI container         |
| **JUnit 5**        | Testing framework                      |
| **Appium**         | Mobile test automation framework       |
| **Allure**         | Test reporting                         |
| **Spotless**       | Code formatting & style enforcement    |

---

## Setup

1. **Clone the repo:**

   ```bash
   git clone https://github.com/dagiguevara/donaldo-guevara.git
   cd monefy-mobile-tests

2. **Prerequisites:**
- Appium server running locally (http://localhost:4723)
- Android emulator or a physical device with developer mode enabled


3. **Run the tests with Gradle:**

   ```bash
   ./gradlew test -Dspring.profiles.active=local

## Design Approach

- Page Object Model (POM): Encapsulation of screen interactions for readability and reusability.
- Spring Boot DI: Clean separation of configuration and business logic via dependency injection
- Flexible config: Appium configuration is externalized
- CI-ready: Runs on GitHub Actions with emulator support..

## Running in CI

CI is handled with GitHub Actions:

- Spin up an Android emulator using reactivecircus/android-emulator-runner
- Start Appium server
- Run tests using Gradle
- Generate and upload Allure reports as artifacts

Check the workflow under .github/workflows/mobile-tests.yml.

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

| Command                 | Description                                               |
|-------------------------|-----------------------------------------------------------|
| **make start-appium**   | Start Appium server                                       |
| **make start-emulator** | Start Android emulator                                    |
| **make stop-emulator**  | Stop Android emulator                                     |
| **make test-local**     | Run tests locally (assumes Appium & emulator are running) |
| **make report**         | Generate and serve the Allure report locally              |
| **make spotless-check** | Check code formatting using Spotless                      |
| **make spotless-apply** | Auto-format code using Spotless                           |
