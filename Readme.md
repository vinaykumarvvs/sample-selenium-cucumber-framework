## Sample Selenium Cucumber Framework

The tech stack used in this project are:
1. **JAVA** as the programming language for writing test code
2. **Cucumber** as the framework
3. **Gradle** as the build tool
4. **IntelliJ** as the preferred IDE for writing java code.

#### Getting Started
Setup your machine.
1. Install JDK 11
2. Install IntelliJ (Community edition should suffice)
3. Install Gradle

#### Running tests
* Run tests in Sequence: ```gradle clean build runTestsInSequence -Dbrowser=chrome -Ptags=@Test```
* Run tests in Parallel: ```gradle clean build runTestsInParallel -Dbrowser=firefox -Ptags=@Test```

* Run tests from IntelliJ: 
1. Open IntelliJ and click on **EditConfigurations**
2. Add select **Cucumber Java**
3. In VM options enter ```-Dbrowser=chrome``` or ```-Dbrowser=firefox```
4. Now **right click** on any scenario to run

#### Report
* Report will be found here: ```build/reports/cucumber/cucumber-html-reports/overview-features.html```
---

### Tests
1. **[TestCase-1](https://github.com/vinaykumarvvs/sample-selenium-cucumber-framework/blob/master/src/test/resources/features/DemoQADragAndDrop.feature):** Drag and drop operation scenario
2. **[TestCase-2](https://github.com/vinaykumarvvs/sample-selenium-cucumber-framework/blob/master/src/test/resources/features/DemoQAResize.feature#L13):** Resize the editor and log dimensions every time
