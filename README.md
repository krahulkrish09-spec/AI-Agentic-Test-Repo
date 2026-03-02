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

## Run tests
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
