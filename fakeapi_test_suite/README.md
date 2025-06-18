# Automated Test Suite for Fakerestapi

This module, contains the required implementation for the automated testing of Books & Authors rest api.

<b>&emsp;Prerequisite Software:</b>

- [JAVA JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Apache MAVEN](https://maven.apache.org/download.cgi)

<b>&emsp;Frameworks/Tools that are used:</b>

- Cucumber BDD
- TestNG
- REST Assured
- Maven
- Lombok

#### Executing Tests Locally

Local execution can be done via IDE (e.g. IntelliJ IDEA) or via Maven Command.
In IntelliJ IDEA below plugins are needed:

- cucumber for java
- gherkin

For execution via Maven, bellow command is used:

    mvn clean install

Regarding <b>environment variables</b>, by default src/main/resources/env.properties is used

    |-- resources
        |-- env.properties

### Project Structure

Automated Regression Test Suite is a maven project consisting of application's module.
This repository contains all the required code, which will automatically perform actions on API.

As far as Design Patterns are concerned, Page Object Pattern is the main design pattern used [Page Object Model](https://www.selenium.dev/documentation/guidelines/page_object_models/).

#### Properties files

```
# Environment URLs Configuration
URL=
```

The default property file "env.properties" that is used/called and defined in pom.xml properties, resides within src/main/resources.

#### Feature Files

For Cucumber, Feature files (_.feature_) are the files used to describe your tests in Descriptive Language (like English), using the
[Gherkin Language](https://cucumber.io/docs/gherkin/reference/). All feature files can be found under [src/test/resources/features]

####  Lombok
To optimize the builder and class management, the Lombok Java Library is used.

### Reporting

The generated cucumber report can be found under target/cucumber-html-reports directory after running the tests.
The report is generated in HTML format and can be opened in any web browser.