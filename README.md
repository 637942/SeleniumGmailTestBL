In this project repository, I have created the Automation framework with Selenium, Cucumber, Maven, and TestNG using Page Object Model in Java for Gmail sending and receiving email in two different accounts.
Run Scripts:
Run the following maven command from command line
mvn clean test

Right click on the Project folder -> run as Testng test or maven test via IDE

The scripts should run successfully in Chrome browser as it is defined in the data.properties file .Define Firefox or edge instead of chrome in data.properties to run in different browsers.
All the test data's are defined in data.properties file.

You may also want to run the command below to check for outdated dependencies. Please be sure to verify and review updates before editing your pom.xml file as they may not be compatible with your code.
$ mvn versions:display-dependency-updates

