# Selenium Java Framework (TestNG + Log4j + Extent Reports)

This repository contains an executable Selenium Java automation framework with sample UI tests for Amazon.

## Tech stack
- Java 17
- Selenium WebDriver
- TestNG
- Log4j2
- Extent Reports
- WebDriverManager
- Maven

## Project structure
- `src/main/java/framework/base` - Base test setup/teardown
- `src/main/java/framework/drivers` - Driver lifecycle management
- `src/main/java/framework/listeners` - TestNG listener for Extent reports
- `src/main/java/framework/reports` - Extent report singleton management
- `src/main/java/framework/utils` - Config utilities
- `src/test/java/tests` - Sample Amazon test cases

## Why tests failed previously
`mvn clean test` failed because this execution environment routes traffic through a proxy that returns **HTTP 403** for direct Maven Central access (`repo.maven.apache.org`).

## How this is resolved
This repo now includes project-level Maven settings (`.mvn/settings.xml`) and config (`.mvn/maven.config`) so builds use a mirror URL from `MAVEN_MIRROR_URL`.

### 1) Configure your allowed Maven mirror
```bash
export MAVEN_MIRROR_URL=https://<your-artifactory-or-nexus>/repository/maven-public/
```

### 2) Run tests
```bash
./scripts/run-tests.sh
```

You can still run Maven directly (it will automatically use `.mvn/settings.xml`):
```bash
mvn clean test
```

## Runtime overrides
```bash
mvn clean test -Dbrowser=firefox -Dheadless=true -DbaseUrl=https://www.amazon.com/
```

## Output artifacts
- TestNG reports under `test-output`
- Extent Report at `test-output/extent-report.html`
- Log file at `test-output/logs/framework.log`
