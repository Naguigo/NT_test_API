# Dog API Automated Tests (Java + RestAssured)

## Overview
Automated test suite for the Dog API (https://dog.ceo/dog-api/documentation).  
Includes functional tests for endpoints:
- GET /breeds/list/all
- GET /breed/{breed}/images
- GET /breeds/image/random

## Requirements
- Java 17+
- Maven
- (Optional) Allure CLI to view reports: https://docs.qameta.io/allure/

## How to run
```bash
cd dog-api-tests
mvn clean test
# generate + serve allure report (optional)
mvn allure:serve
```

## What is included
- Tests using RestAssured + JUnit5
- Allure configuration in pom.xml for reporting
- Sample tests cover success cases and a negative case for non-existing breed

## Notes
- Tests are deterministic but rely on the external Dog API.
- If running behind a corporate proxy, configure Maven/Java proxy settings.

