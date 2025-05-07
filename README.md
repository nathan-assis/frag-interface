# Java Maven Project Template
[![en](https://img.shields.io/badge/lang-en-blue.svg)](https://github.com/nathanassis/java-maven-project-template/blob/main/README.md)
[![pt-br](https://img.shields.io/badge/lang-pt--br-green.svg)](https://github.com/nathanassis/java-maven-project-template/blob/main/README.pt-br.md)

This is a template repository for Java projects using Maven, with the following development tools:

* `Checkstyle`: Linter
* `google-java-format`: Formatter
* `JUnit`: Unit testing framework  
* `GitHub Actions`: Runs tests and checks on every pull request and push to `main`

## Development Instructions

### Requirements

Make sure you have the following installed:

- Java 17+
- Maven 3.8+  
  (Recommended: Use the provided wrapper script `./mvnw` for consistent builds)

### Running Tests

To run tests, use:

```sh
./mvnw test
```

### Running Linter

To run the linter manually:

```sh
./mvnw checkstyle:check
```

### Running Formatter

To check code formatting:

```sh
./mvnw fmt:check
```

To automatically format your code:

```sh
./mvnw fmt:format
```

### Full Build and Verification

To run a full build with tests, formatting check, and linter:

```sh
./mvnw verify
```

## Repository Structure

* `.github/workflows/ci.yml`: GitHub Actions workflow to run tests and checks
* `.gitignore`: Files ignored by Git
* `README.md`: Project description
* `README.pt-br.md`: Project description
* `pom.xml`: Maven project configuration
* `src/main/java`: Application source code
* `src/test/java`: Unit tests

## 🔎 Found an Issue or Have an Idea for Improvement?

Help improve this template by opening an issue or submitting a pull request!