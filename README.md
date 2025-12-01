# Webpoints – Grocery API (Spring Boot)

This project is a **Spring Boot REST API** for managing a grocery list. It was set up, built, tested locally with Gradle, and integrated with **GitHub Actions CI** for automatic testing on every push.

---

##  Features

* REST API for grocery items
* In-memory mock service
* Input validation using Jakarta Validation
* Boilerplate code generated with **Lombok**
* Proper HTTP responses using **ResponseEntity builders**
* Fully buildable with **Gradle Wrapper**
* Automatic testing using **GitHub Actions**

---

## ⚙️ Tech Stack

* Java 17
* Spring Boot 3
* Gradle
* Lombok
* Git + GitHub
* GitHub Actions (CI)

---

##  How to Run the Project Locally

```bash
./gradlew bootRun
```

The application will start on:

```
http://localhost:8080
```

---

##  API Endpoints

### Get all grocery items

```bash
curl http://localhost:8080/api/grocery
```

### Add a new grocery item (ID must be null)

```bash
curl -X POST http://localhost:8080/api/grocery \
  -H "Content-Type: application/json" \
  -d '{"id":null,"name":"Tomaten","amount":5,"collected":false}'
```

---

##  Run Tests Locally

```bash
./gradlew test
```

---

##  GitHub Actions (CI)

This project includes a **GitHub Actions workflow** that:

* Installs Java 17
* Uses the Gradle Wrapper
* Runs all tests automatically on every push to `master`

You can view the results in the **Actions** tab on GitHub.

---

##  Gradle Wrapper

The project includes the full **Gradle Wrapper**, so it can be built on any system without installing Gradle manually.

---

##  Project Structure

```
webpoints/
└── tgm
    ├── Application.java
    ├── controller
    ├── dto
    ├── exception
    ├── service
    ├── gradlew
    ├── gradlew.bat
    └── gradle/
```

---

##  Status

*  Project builds successfully
*  API working
*  CI pipeline active
*  Ready for submission

---
