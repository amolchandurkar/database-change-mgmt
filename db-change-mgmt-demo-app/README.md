# db-change-mgmt-demo-app

This is a Maven-based Spring Boot project using Java 21 and the latest Spring Boot release. It demonstrates database change management using Liquibase.

## Features

- Spring Boot 3.3.0
- Java 21
- Liquibase for database migrations
- H2 in-memory database
- JPA entity and repository
- REST API for Person entity

## How to Run

1. Build the project:
   ```shell
   mvn clean install
   ```
2. Run the application:
   ```shell
   mvn spring-boot:run
   ```
3. Access the API:
   - List persons: `GET /api/persons`
   - Add person: `POST /api/persons`

## Database Change Management

- Liquibase changelog is located at `src/main/resources/db/changelog/db.changelog-master.xml`
- On startup, Liquibase will apply changes to the H2 database.

## Customization

- Add new changesets to the changelog yaml to manage schema changes.

---
