# Mobile Automation Framework with Appium

This project is a Mobile test automation framework developed with **Java 17, Appium, Selenium, Cucumber, JUnit, Maven, UiAutomator2, and Android Emulator**.

It was created as part of a QA Automation portfolio to demonstrate professional practices in Mobile testing, BDD, Screen Object Model, Appium capabilities, Android automation, screenshot evidence on failure, and local mobile test execution.

---

## 🚀 Technologies Used

- Java 17
- Appium
- Appium Java Client
- Selenium WebDriver
- UiAutomator2
- Cucumber
- JUnit
- Maven
- Gherkin
- Hamcrest
- Android Emulator

---

## 📌 Project Overview

This framework validates Android mobile application flows using BDD scenarios written in Gherkin.

The project uses the Android **ApiDemos** demo application to demonstrate mobile automation practices, including:

- Appium driver configuration
- Android capabilities
- UiAutomator2 automation
- Screen Object Model
- Mobile element interaction
- Mobile navigation validation
- Scroll validation using UiScrollable
- Screenshot attachment on failed scenarios
- Reusable driver and configuration layers

Tested application:

```text
ApiDemos-debug.apk
```

Expected APK path:

```text
src/test/resources/apps/ApiDemos-debug.apk
```

---

## ✅ Test Scenarios Covered

The project currently covers Android navigation and interaction flows:

- Validate main menu options on the home screen
- Validate navigation to the Views menu
- Validate scroll inside the Views menu
- Validate visible mobile elements
- Validate Android accessibility locators
- Validate UiScrollable usage

Example scenario:

```gherkin
@regression @scroll
Scenario: Validate scroll inside Views menu
  When I access the Views menu
  And I scroll to the "WebView" option
  Then the "WebView" option should be visible
```

---

## 📁 Project Structure

```text
mobile-automation-appium
├── src
│   └── test
│       ├── java
│       │   ├── config
│       │   │   └── MobileConfig.java
│       │   ├── drivers
│       │   │   └── DriverFactory.java
│       │   ├── hooks
│       │   │   └── Hooks.java
│       │   ├── runner
│       │   │   └── RunnerTest.java
│       │   ├── screens
│       │   │   ├── BaseScreen.java
│       │   │   ├── HomeScreen.java
│       │   │   └── ViewsScreen.java
│       │   ├── steps
│       │   │   └── ApiDemosSteps.java
│       │   └── utils
│       │       └── ScreenshotUtils.java
│       └── resources
│           ├── apps
│           │   └── ApiDemos-debug.apk
│           └── features
│               └── api_demos.feature
├── .gitignore
├── pom.xml
└── README.md
```

---

## 🧱 Framework Architecture

This framework follows a layered architecture to keep the code clean, reusable, and maintainable.

### Feature Layer

Contains BDD scenarios written in Gherkin.

```text
src/test/resources/features
```

### Step Definitions Layer

Implements the Gherkin steps and performs assertions.

```text
src/test/java/steps
```

### Screen Object Layer

Centralizes mobile elements and mobile actions, keeping test logic separated from locators.

```text
src/test/java/screens
```

### Driver Layer

Centralizes Appium driver creation, Android capabilities, UiAutomator2 configuration, and driver shutdown.

```text
src/test/java/drivers
```

### Hooks Layer

Controls test setup and teardown using Cucumber hooks.

```text
src/test/java/hooks
```

### Config Layer

Centralizes mobile execution configuration such as platform name, device name, automation name, app path, and Appium server URL.

```text
src/test/java/config
```

### Utils Layer

Contains reusable utilities such as screenshot capture for failed scenarios.

```text
src/test/java/utils
```

---

## 🧪 How to Run the Tests

### Prerequisites

Make sure you have installed:

- Java 17+
- Maven
- Node.js
- Appium
- UiAutomator2 driver
- Android Studio
- Android Emulator
- Android SDK
- ADB configured in the system PATH

---

## 📲 Appium Setup

Install Appium globally:

```bash
npm install -g appium
```

Install the UiAutomator2 driver:

```bash
appium driver install uiautomator2
```

Check installed drivers:

```bash
appium driver list --installed
```

Expected result:

```text
uiautomator2
```

Start the Appium Server:

```bash
appium
```

or on Windows:

```bash
appium.cmd
```

The server should be available at:

```text
http://127.0.0.1:4723/
```

---

## 🤖 Android Emulator Setup

Open Android Studio and start an Android Emulator.

Check if the emulator is connected:

```bash
adb devices
```

Expected result:

```text
emulator-5554    device
```

---

## 📦 APK Setup

Place the demo APK in the following path:

```text
src/test/resources/apps/ApiDemos-debug.apk
```

The default app path is configured in:

```text
src/test/java/config/MobileConfig.java
```

You can override the APK path using:

```bash
mvn clean test -DappPath="path/to/your/app.apk"
```

---

## ▶️ Running the Tests

With the Appium Server running and the Android Emulator opened, execute:

```bash
mvn clean test
```

Run tests by tag:

```bash
mvn clean test -Dcucumber.filter.tags="@mobile"
```

```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

```bash
mvn clean test -Dcucumber.filter.tags="@regression"
```

Run with a custom Appium Server URL:

```bash
mvn clean test -DappiumServerUrl="http://127.0.0.1:4723/"
```

Run with a custom device name:

```bash
mvn clean test -DdeviceName="Android Emulator"
```

---

## 📊 Test Reports

After test execution, reports are generated in:

```text
target/cucumber-reports/
```

HTML report:

```text
target/cucumber-reports/cucumber.html
```

JSON report:

```text
target/cucumber-reports/cucumber.json
```

When a scenario fails, a screenshot is automatically attached to the Cucumber report.

---

## 🔎 Good Practices Applied

- BDD with Cucumber and Gherkin
- Mobile automation using Appium
- Android automation with UiAutomator2
- Screen Object Model
- Centralized DriverFactory
- Centralized mobile configuration
- Reusable BaseScreen
- Explicit waits through BaseScreen
- Android accessibility locators
- Android UiScrollable usage
- Screenshot capture on failed scenarios
- Tags for selective test execution
- Cucumber HTML and JSON reports
- Git-ready structure with `.gitignore`
- Parameterized execution using system properties

---

## 📌 Important Note About CI/CD

Mobile automation pipelines usually require an Android Emulator, Android SDK, Appium Server, and test device configuration.

For this portfolio project, the framework is designed and validated for **local execution with Appium Server and Android Emulator**.

A future improvement would be adding CI execution with:

- GitHub Actions Android Emulator
- Appium Server startup in pipeline
- Device boot validation
- APK installation validation
- Cucumber report artifact upload

---

## 📌 Future Improvements

- Add GitHub Actions with Android Emulator
- Add iOS support
- Add cross-platform driver strategy
- Add Android app package and activity execution mode
- Add cloud execution support with Perfecto or BrowserStack
- Add Allure Reports integration
- Add retry strategy for flaky mobile tests
- Add test data externalization
- Add parallel execution strategy
- Add real device execution documentation

---

## 👩‍💻 Author

**Kauany Cardoso**  
QA Automation Engineer focused on Web, Mobile, and API testing.

---

⭐ This project is part of my QA Automation portfolio.