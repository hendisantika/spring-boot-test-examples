# spring-boot-test-examples

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-test-examples/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-test-examples/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.x-6DB33F?logo=springboot)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?logo=apachemaven)

A collection of small Spring Boot projects that show how to test each layer of a Spring Boot application —
from plain unit tests up to full integration tests with a real PostgreSQL database.

Source article series: https://www.arhohuttunen.com/spring-boot-unit-testing/

## Modules

Every module is an independent Maven project (there is no parent/aggregator POM).

| Module | What it demonstrates | Key tools |
|--------|----------------------|-----------|
| [`spring-boot-unit-testing`](spring-boot-unit-testing) | Unit testing a service without starting Spring | JUnit 5, Mockito, AssertJ |
| [`spring-boot-webmvctest`](spring-boot-webmvctest) | Testing the web layer only | `@WebMvcTest`, `MockMvc`, `@MockitoBean`, Bean Validation |
| [`spring-boot-jsontest`](spring-boot-jsontest) | Testing JSON (de)serialization | `@JsonTest`, `JacksonTester`, Jackson 3 `@JacksonComponent`, JavaMoney |
| [`spring-boot-datajpatest`](spring-boot-datajpatest) | Testing the persistence layer against PostgreSQL | `@DataJpaTest`, `TestEntityManager`, `@Sql`, Testcontainers, Flyway |
| [`spring-boot-webclient-mockwebserver`](spring-boot-webclient-mockwebserver) | Testing HTTP clients | `WebClient`, OkHttp `MockWebServer` |
| [`spring-boot-integration-testing`](spring-boot-integration-testing) | End-to-end integration tests | `@SpringBootTest`, `MockMvc`, `WebTestClient`, `MockWebServer`, Testcontainers, Flyway |

## Tech stack

- Java **25**
- Spring Boot **4.1.x** (Spring Framework 7, Jakarta EE 11, Hibernate 7, Jackson 3)
- JUnit 5, Mockito, AssertJ
- Testcontainers 2 (PostgreSQL 17)
- Flyway, H2, PostgreSQL
- Lombok

## Prerequisites

- JDK 25
- Maven 3.9+
- Docker — required by `spring-boot-datajpatest` and `spring-boot-integration-testing` (Testcontainers)

## Getting started

1. Clone this repository:
   ```shell
   git clone https://github.com/hendisantika/spring-boot-test-examples.git
   cd spring-boot-test-examples
   ```
2. Build & test a single module:
   ```shell
   mvn -B verify --file spring-boot-webmvctest/pom.xml
   ```
3. Or build & test every module:
   ```shell
   for module in spring-boot-*/; do mvn -B verify --file "${module}pom.xml" || break; done
   ```
4. (Optional) Start PostgreSQL + Adminer locally for `spring-boot-datajpatest`:
   ```shell
   docker compose -f spring-boot-datajpatest/docker-compose.yml up -d
   ```

## Continuous integration & dependency updates

- [GitHub Actions](.github/workflows/maven.yml) builds and tests each module in a matrix on JDK 25 (Temurin) for every
  push and pull request to `main`, and submits the Maven dependency graph to GitHub.
- [Dependabot](.github/dependabot.yml) checks Maven dependencies daily and GitHub Actions weekly, grouping related
  updates (Spring Boot, OkHttp, testing libraries, Maven plugins, minor/patch) into single pull requests.

## Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: [@hendisantika34](https://t.me/hendisantika34)
- Link: [s.id/hendisantika](https://s.id/hendisantika)
