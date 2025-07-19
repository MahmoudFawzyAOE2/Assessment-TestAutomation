
# Test Automation Project - UI & API

This project is a Test Automation framework that covers **UI testing** using Selenium and **API testing** using RestAssured. It includes data-driven testing, CSRF-protected login flow handling, and structured reporting with TestNG.

---

## 🔧 Tools & Technologies Used

| Tool           | Purpose                     |
|----------------|-----------------------------|
| **Java**       | Core programming language   |
| **TestNG**     | Test framework              |
| **Selenium**   | UI test automation          |
| **RestAssured**| API testing                 |
| **Maven**      | Dependency management       |
| **Faker**      | Fake test data generation   |
| **Jsoup**      | HTML parsing for CSRF tokens|
| **TestNG Reports** | Built-in test reporting |

---

## 📦 Project Structure

```
src 
├──  main 
│   └──  java 
│       ├──  api         # API Helpers
│       ├──  drivers     # WebDriver setup
│       ├──  listeners   # Custom TestNG listeners
│       ├──  pages       # Page Object Model for UI tests
│       ├──  testData    # Test data management
│       └──  utils       # UI Utility classes
└──  test 
    └──  java 
        └──  tests 
            ├──  api     # API test classes
            └──  ui      # UI test classes

test-output/                     # TestNG generated reports
```

---

## ✅ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/MahmoudFawzyAOE2/Assessment-TestAutomation.git
   cd Assessment-TestAutomation
   ```

2. **Import as Maven Project**  
   Open in IntelliJ IDEA or any IDE that supports Maven.

3. **Install dependencies**
   If your IDE doesn't auto-import:
   ```bash
   mvn clean install
   ```
---

## 🚀 How to Run the Tests

### UI & API Combined Suite

```bash
Right-click on testng.xml → Run
```

This runs both:
- `tests.ui.AdminTests`
- `tests.api.CandidateTestsAPI`

### Individual Tests

You can also right-click on any test class or method to run them independently.

---

## 📊 View the Report

After test execution:

```bash
Open: test-output/html/index.html
```

> 💡 By default, the report opens automatically in your system browser after execution.

