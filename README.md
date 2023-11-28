# Lectures [![Java CI with Maven](https://github.com/GFLCourses6/lection/actions/workflows/maven.yml/badge.svg)](https://github.com/GFLCourses6/lection/actions/workflows/maven.yml)

## Patterns:
  - Dto
  - Builder
  - Singleton
  - Facade
  - Proxy
  - Factory
  - Abstract method Factory
  - Dependency Injection
  - Test Mockito
  - Webdriver
  - Observer
  - Subscriber-publisher


### Compile and run the code: User, Ship, Main
`javac com/classwork/pattern/dto/entity/model/User.java com/classwork/pattern/dto/DtoApp.java && java com/classwork/pattern/dto/DtoApp`

### Commands:

Clean, install, and generate report

`mvn clean install site -P test`

Test report

`mvn surefire-report:report`

Show dependency tree

`mvn dependency:tree`

Compile the code v.11 and package in file, skip the tests

`mvn clean package -DskipTests`

Build the project with Maven Tool

`mvn -B package --file pom.xml`

Build the project with Maven Tool without Tests

`mvn clean install -e -DskipTests`

Build the project with Maven Tool with Tests

`mvn clean install -X`

Maven will perform the necessary build tasks, such as compiling the code,
creating the project's artifacts, and verifying their correctness.

`mvn verify -e`

Report with Jacoco Tool with Coverage

`mvn clean test jacoco:report`
