# sauce demo

This project is an automated testing framework built using Selenium WebDriver, Cucumber (BDD), and Maven.
Test scenarios are written in Gherkin syntax and running them in Chrome browser.

The framework follows the Page Object Model (POM) design pattern to ensure code reusability and maintainability.

**Project Structure:**

src/main/java/pages - Page Object classes

src/test/java/stepDefinitions - Step definition files

src/test/java/runners - Test runners

src/test/java/Utils - Driver Utils

src/test/resources/features - Feature files

pom.xml - Maven configuration

readme.md - Project Documentation

**How to Run Tests**

1. Clone the repository
2. Install dependencies
3. Run TestRunner.java
4. Reports are generated automatically after the test execution at this location - target/cucumber-reports/cucumber-html-report.html



