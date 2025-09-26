# Job Listing Application

A simple Spring Boot application that provides REST APIs to manage job listings.  
It uses **MongoDB Atlas** as the database and integrates **Springdoc OpenAPI** for API documentation (Swagger UI).  

---

## Features
- Add new job listings
- Fetch all job listings
- Swagger UI for API testing
- MongoDB Atlas integration

---

## Tech Stack
- Java 21
- Spring Boot 3.5.6
- MongoDB Atlas (cloud database)
- Spring Data MongoDB
- Springdoc OpenAPI (Swagger UI)

---

## Project Structure
```
joblisting/
 ├── controller/   → REST API controllers
 ├── model/        → MongoDB document models
 ├── repository/   → Spring Data repositories
 └── JoblistingApplication.java → Main application entry point
```

---

## API Endpoints

- `GET /posts` → Fetch all job listings  
- `POST /post` → Add a new job listing  

Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Configuration

Update your `application.properties` with your MongoDB Atlas connection string:

```properties
spring.application.name=joblisting
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/?retryWrites=true&w=majority
spring.data.mongodb.database=<database-name>
```

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Arpit-Chaurasia26/Job-Listing-Application.git
   ```
2. Navigate to project:
   ```bash
   cd Job-Listing-Application
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## License
This project is open-source and available under the [MIT License](LICENSE).
