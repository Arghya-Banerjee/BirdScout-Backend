# BirdScout Backend

A Spring Boot application for managing bird observations and user authentication. This project is inspired by [eBird](https://ebird.org/) and serves as the foundation for BirdScout, a bird conservation platform. The backend includes:

- **RESTful APIs** for Birds, Observations, and Users
- **Spring Security (DAO Authentication)** for user registration and login
- **Role-based Access Control** (Admin/User)
- **MS SQL Server** integration via **Spring Data JPA**

<br/>

## **Table of Contents**
1. [Project Overview](#project-overview)
2. [Tech Stack](#tech-stack)
3. [Features](#features)
4. [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Application](#running-the-application)
5. [Endpoints & Usage](#endpoints--usage)
6. [Postman Collection](#postman-collection)
7. [Project Structure](#project-structure)
8. [Contributing](#contributing)
9. [License](#license)

---

## **Project Overview**

**BirdScout** is built to help users record, manage, and explore bird observations. It aims to:

- Track different bird species in various locations.
- Provide user authentication with roles (e.g., Admin, User).
- Offer a consistent REST API for front-end or mobile clients.

---

## **Tech Stack**

- **Java 17** (or higher)
- **Spring Boot** (Web, Security, Data JPA)
- **Maven** for dependency management
- **MS SQL Server** for the database
- **Lombok** (optional, but recommended for reducing boilerplate)
- **Postman** (for testing APIs)

---

## **Features**

- **User Registration** (with automatic role assignment and password encoding)
- **Form-based Login** with Spring Security
- **CRUD Endpoints** for:
  - Birds (create, read, update, delete)
  - Observations (create, read, update, delete)
  - Users (read, delete)
- **Role-Based Access**:
  - `ROLE_USER` can access bird and observation endpoints.
  - `ROLE_ADMIN` can manage users (e.g., delete user accounts).

---

## **Getting Started**

### **Prerequisites**

1. **Java 17** or higher installed  
2. **Maven** (3.x) installed  
3. **MS SQL Server** running locally or accessible remotely  
4. A tool like **Postman** or **cURL** for testing the API

### **Installation**

1. **Clone** or **Download** the repository:

   ```bash
   git clone https://github.com/your-username/birdscout-backend.git
   ```

2. **Configure `application.properties`**:

   ```
   spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=birdscoutDB
   spring.datasource.username=YOUR_DB_USERNAME
   spring.datasource.password=YOUR_DB_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Replace `YOUR_DB_USERNAME` and `YOUR_DB_PASSWORD` with your actual credentials.

### **Running the Application**

```bash
mvn clean install
mvn spring-boot:run
```

Runs at `http://localhost:8080` by default.

---

## **Endpoints & Usage**

### **Authentication**

- `POST /auth/register`  
  Register a user (default role: `ROLE_USER`, override with `roleName=ROLE_ADMIN`)

- `POST /login` (form-data)  
  Logs in with `username` and `password` (uses Spring Security form-based login)

---

### **Birds**

| Method | Endpoint       | Description           |
|--------|----------------|-----------------------|
| GET    | `/birds`       | Get all birds         |
| POST   | `/birds`       | Create a new bird     |
| GET    | `/birds/{id}`  | Get bird by ID        |
| PUT    | `/birds/{id}`  | Update bird by ID     |
| DELETE | `/birds/{id}`  | Delete bird by ID     |

---

### **Observations**

| Method | Endpoint              | Description                   |
|--------|-----------------------|-------------------------------|
| GET    | `/observations`       | Get all observations          |
| POST   | `/observations`       | Create a new observation      |
| GET    | `/observations/{id}`  | Get observation by ID         |
| PUT    | `/observations/{id}`  | Update observation by ID      |
| DELETE | `/observations/{id}`  | Delete observation by ID      |

---

### **Users (Admin Only)**

| Method | Endpoint       | Description           |
|--------|----------------|-----------------------|
| GET    | `/users`       | Get all users         |
| GET    | `/users/{id}`  | Get user by ID        |
| DELETE | `/users/{id}`  | Delete user by ID     |

---

## **Postman Collection**

A ready-to-import Postman collection is available:

📁 `BirdScout.postman_collection.json`

Just import into Postman and test all APIs in one go!

---

## **Project Structure**

```
birdscout-backend/
├── src/
│   ├── main/
│   │   ├── java/com/example/birdscout
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── entity/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── BirdscoutBackendApplication.java
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
└── README.md
```

---

## **Contributing**

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## **License**

MIT License. Free to use and modify for your own projects.

---

**Happy Birding with BirdScout!** 🐦🌿