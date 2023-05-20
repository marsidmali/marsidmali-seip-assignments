# UnitTesting Project


This project demonstrates the use of unit testing to ensure the reliability and correctness of a codebase. Unit testing is a software testing technique where individual units or components of a software application are tested in isolation. This helps to identify and fix bugs early in the development process, making it easier to maintain and improve the code over time.

## Technologies Used

1. **Java**: The project is written in Java, a popular, versatile, and object-oriented programming language.
2. **JUnit**: A widely-used testing framework for Java applications, JUnit is employed to write and run unit tests.
3. **JaCoCo**: Java Code Coverage Library (JaCoCo) is a code coverage tool that measures the percentage of code executed during testing, helping to identify areas that require additional testing.
4. **Mockito**: A mocking framework for Java, Mockito is used to create and configure mock objects for unit testing.

## Getting Started

3. To build the project using Maven run:

```bash
mvn clean install
```

### Running Tests

To run the unit tests, execute the following command:

```bash
mvn test
```

### Generating Code Coverage Report

To generate a code coverage report using JaCoCo, run the following command:

```bash
mvn jacoco:report
```

The generated report can be found in the `target/site/jacoco` directory. Open the `index.html` file in a web browser to view the report.
