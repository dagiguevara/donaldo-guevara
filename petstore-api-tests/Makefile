.PHONY: build up down test logs clean test-local test-docker report spotless-check spotless-apply

# Build all images
build:
	docker compose build

# Start only the API container
up:
	docker compose up -d petstore-api

# Stop and clean all containers and volumes
down:
	docker compose down -v --remove-orphans

# Run tests inside Docker (Dockerized test runner)
test-docker: build up
	docker compose run --rm api-tests

# Run tests locally via Gradle (assumes petstore-api is already up)
test-local:
	./gradlew test -Dspring.profiles.active=local

# Generate and serve the Allure report locally
report:
	./gradlew allureServe

# Check code formatting using Spotless
spotless-check:
	./gradlew spotlessCheck

# Auto-format code using Spotless
spotless-apply:
	./gradlew spotlessApply
