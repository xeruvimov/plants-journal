## Requirements
1. [Java 11]
2. [PostgreSQL] login\pass: `postgres` port: `5432`
3. [Maven]
---
## Start up
1. Create Postgres DB with name: `plants_journal`
2. In root run `mvn clean spring-boot:run`
---
## API Docs
After run, API docs you can see on `localhost:8080/swagger-ui.html`

Enter in search bar `/journal-openapi`

[Maven]: https://maven.apache.org/download.cgi
[Java 11]: https://www.oracle.com/ru/java/technologies/javase-jdk11-downloads.html
[PostgreSQL]: https://www.postgresql.org/download/https://www.postgresql.org/download/