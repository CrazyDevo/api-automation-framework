
---

# 📘 API Test Automation Framework

A **scalable, production-grade API Test Automation Framework** built using:

* Java
* JUnit 5
* Rest Assured
* Maven
* Allure Reporting
* TDD approach

---

# 🚀 Overview

This framework is designed following **clean architecture principles** and **industry best practices** to ensure:

* Maintainability
* Scalability
* Reusability
* Readability

---

# 🧱 Tech Stack

| Tool         | Purpose              |
| ------------ | -------------------- |
| Java         | Programming Language |
| JUnit 5      | Test Framework       |
| Rest Assured | API Testing          |
| Maven        | Build Tool           |
| Allure       | Reporting            |

---

# 📂 Project Structure

```
api-automation-framework/
│
├── base              → Base classes (setup & core logic)
├── service           → API service layer
├── model             → POJO request/response models
│   ├── request
│   └── response
├── utils             → Utility classes
├── tests             → Test classes
├── runner            → JUnit Suite runner
├── resources         → Config files
│   ├── config.properties
│   ├── allure.properties
│
├── pom.xml
```

---

# 🧠 Architecture

```
Tests → Service → Base → Utils
```

### Principles Applied:

* Separation of Concerns
* Single Responsibility
* Reusability
* No API calls inside test classes

---

# ⚙️ Setup Instructions

## 1. Prerequisites

Make sure you have installed:

```bash
java -version
mvn -v
```

If Maven is missing:

```bash
brew install maven
```

---

## 2. Clone Project

```bash
git clone <your-repo-url>
cd api-automation-framework
```

---

## 3. Install Dependencies

```bash
mvn clean install
```

---

# 🔧 Configuration

## config.properties

```properties
base.url=https://spartan-app-new-nonsecure.onrender.com/api/v2
env=qa
timeout=5000
```

---

## allure.properties

```properties
allure.results.directory=target/allure-results
```

---

# 🧪 Running Tests

## Run All Tests

```bash
mvn clean test
```

---

## Run Smoke Tests

```bash
mvn clean test -Dgroups=smoke
```

---

## Run Regression Tests

```bash
mvn clean test -Dgroups=regression
```

---

# 🏷️ Tagging Strategy

| Tag        | Purpose         |
| ---------- | --------------- |
| smoke      | Critical tests  |
| regression | Full test suite |

Example:

```java
@Tag("smoke")
@Test
void testExample() {}
```

---

# 🏃 Test Runner

```java
@Suite
@SelectPackages("tests")
@IncludeTags("smoke")
public class TestRunner {}
```

---

# 📊 Allure Reporting

## Generate Report

```bash
mvn allure:report
```

## Open Report

```bash
mvn allure:serve
```

---

# 📎 Allure Features

* Request/Response attachments
* Step annotations
* Severity levels
* Environment tracking

Example:

```java
@Severity(SeverityLevel.CRITICAL)
@Description("Validate GET API")
```

---

# 🔗 API Under Test

```
GET /spartans/{id}
```

### Sample Response:

```json
{
  "message": "Successfully retrieved the Spartan.",
  "totalElement": 1,
  "data": {
    "id": 15,
    "name": "Meta",
    "gender": "Female",
    "phone": "1938695106"
  }
}
```

---

# 🧪 Test Coverage

### ✅ Positive Test

* GET Spartan by ID → 200 OK

### ❌ Negative Test

* GET invalid ID → 404 Not Found

---

# 🔁 Retry Mechanism

Automatically retries failed tests (configurable).

---

# 📈 Parallel Execution

Enabled via Maven Surefire:

```xml
<parallel>methods</parallel>
<threadCount>3</threadCount>
```

---

# 📦 POJO Modeling

Response mapped into Java objects:

```java
SpartanResponse response = apiResponse.as(SpartanResponse.class);
```

---

# 🧾 Logging

* Request logging
* Response logging
* Debug-friendly output

---

# 🧪 Schema Validation (Optional)

```java
.body(matchesJsonSchemaInClasspath("schema.json"));
```

---

# 🌍 Environment Support

Supports multiple environments via:

```properties
env=dev | qa | prod
```

---

# 🧠 Best Practices

✔ No hardcoded data
✔ Centralized config
✔ Reusable services
✔ Clean test methods
✔ TDD approach
✔ Proper assertions

---

# ❌ Common Mistakes

| Issue             | Fix                  |
| ----------------- | -------------------- |
| mvn not found     | Install Maven        |
| Allure empty      | Check results folder |
| Tests not running | Check tags           |

---

# 🔮 Future Enhancements

* 🔐 Authentication (OAuth2 / JWT)
* 📊 Data-driven testing
* 🐳 Docker support
* 🔁 CI/CD pipeline (Jenkins)
* 📈 Advanced reporting dashboards

---

# 👨‍💻 Author

Senior QA Automation Architecture Designer(Adam)

---

# ⭐ Final Notes

This framework is:

✔ Production-ready
✔ Scalable
✔ Enterprise-grade

---

