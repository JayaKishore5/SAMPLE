# SAI Backend Master

## Overview
SAI Backend Master is a backend application designed to simplify and manage inventory operations, process workflows, and transactional data. Built with scalability, security, and maintainability in mind, it ensures seamless integration and efficient backend management for modern applications.

This application provides:
- Secure authentication and session management using JWT.
- Modular APIs for inventory, process, and transactional management.
- Flexible configuration via `application.properties`.
- Comprehensive documentation using Swagger.

---

## Technologies Used
- **Java**: Core development language.
- **Spring Boot**: Framework for rapid development and scalability.
- **Maven**: Dependency management and build tool.
- **JWT**: Token-based secure authentication.
- **MySQL**: Relational database for persistent storage.
- **Swagger**: API documentation and testing interface.

---

## Features
1. **Authentication and Authorization**:
   - Secure login with JWT token issuance.
   - Password encryption.
2. **Inventory Management**:
   - Create, read, update, and delete inventory items.
3. **Process Management**:
   - Monitor workflows and manage their statuses.
4. **Dynamic Configuration**:
   - Manage application-wide settings via APIs.
5. **Transactional Data Handling**:
   - Maintain records of financial and operational transactions.

---

## Application Configuration

The application is configured through the `application.properties` file. Below are the key configurations and their explanations:

### **Database Configuration**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sai_backend
spring.datasource.username=root
spring.datasource.password=root123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
- **`spring.datasource.url`**: The JDBC URL pointing to the MySQL database instance.
- **`spring.datasource.username`**: The username to connect to the database.
- **`spring.datasource.password`**: The password for the database connection.
- **`spring.datasource.driver-class-name`**: Specifies the database driver.

### **Server Configuration**
```properties
server.port=8080
```
- **`server.port`**: Specifies the port on which the application runs.

### **JWT Configuration**
```properties
jwt.secretkey=your_jwt_secret_key
jwt.token.validity=86400000
```
- **`jwt.secretkey`**: The secret key used for signing JWT tokens.
- **`jwt.token.validity`**: The validity period of a JWT token in milliseconds (24 hours in this case).

### **JPA Configuration**
```properties
spring.jpa.hibernate.ddl-auto=update
```
- **`spring.jpa.hibernate.ddl-auto`**: Specifies how Hibernate should handle schema updates (e.g., create, update).

### **Swagger Configuration**
```properties
springdoc.swagger-ui.path=/swagger-ui.html
```
- **`springdoc.swagger-ui.path`**: The URL path to access the Swagger UI for API documentation.

---

## POM.xml Explanation

The `pom.xml` file is a Maven configuration file used to manage project dependencies, plugins, and build settings. Below are key aspects:

### Key Dependencies
1. **Spring Boot Starter**: Provides core Spring Boot functionalities.
2. **Spring Boot Starter Web**: Enables building RESTful web services.
3. **Spring Boot Starter Data JPA**: Simplifies database access with JPA and Hibernate.
4. **MySQL Driver**: Connects the application to a MySQL database.
5. **Spring Security**: Ensures secure access and user authentication.
6. **JWT (Json Web Token)**: Implements token-based authentication.
7. **Swagger Documentation**: Provides API documentation and testing tools.

### Plugins
1. **Spring Boot Maven Plugin**: Used for packaging and running the Spring Boot application.

---

## Controllers

### **GeneralParamsController**
Handles application-wide configuration parameters.

#### **GET /api/params**
- **Description**: Fetches global configuration.
- **Response Example**:
  ```json
  {
    "configKey": "siteName",
    "configValue": "SAI Platform"
  }
  ```

#### **POST /api/params**
- **Description**: Updates configuration settings.
- **Request Example**:
  ```json
  {
    "configKey": "siteName",
    "configValue": "Updated SAI Platform"
  }
  ```
- **Response Example**:
  ```json
  {
    "message": "Configuration updated successfully."
  }
  ```

### **LoginController**
Manages user authentication and registration.

#### **POST /api/auth/login**
- **Description**: Authenticates users.
- **Request Example**:
  ```json
  {
    "username": "user1",
    "password": "securepassword"
  }
  ```
- **Response Example**:
  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
  }
  ```

#### **POST /api/auth/register**
- **Description**: Registers a new user.
- **Request Example**:
  ```json
  {
    "username": "newuser",
    "password": "newpassword",
    "email": "newuser@example.com"
  }
  ```
- **Response Example**:
  ```json
  {
    "message": "User registered successfully."
  }
  ```

### **MasterController**
Handles master data management.

#### **GET /api/master**
- **Description**: Fetches all master data records.
- **Response Example**:
  ```json
  [
    {
      "id": 1,
      "name": "Category A",
      "description": "This is Category A."
    },
    {
      "id": 2,
      "name": "Category B",
      "description": "This is Category B."
    }
  ]
  ```

#### **POST /api/master**
- **Description**: Creates a new master data record.
- **Request Example**:
  ```json
  {
    "name": "Category C",
    "description": "This is Category C."
  }
  ```
- **Response Example**:
  ```json
  {
    "message": "Master data created successfully.",
    "id": 3
  }
  ```

### **ProcessController**
Handles workflow processes.

#### **POST /api/process**
- **Description**: Starts a new process.
- **Request Example**:
  ```json
  {
    "name": "Process 1",
    "initiator": "Admin"
  }
  ```
- **Response Example**:
  ```json
  {
    "message": "Process initiated successfully."
  }
  ```

#### **GET /api/process/{id}**
- **Description**: Retrieves process details by ID.
- **Response Example**:
  ```json
  {
    "id": 101,
    "name": "Process 1",
    "status": "In Progress",
    "initiator": "Admin"
  }
  ```

### **TransactionsController**
Handles transactional data operations.

#### **POST /api/transactions**
- **Description**: Creates a new transaction.
- **Request Example**:
  ```json
  {
    "transactionType": "Purchase",
    "amount": 500,
    "date": "2024-12-01"
  }
  ```
- **Response Example**:
  ```json
  {
    "message": "Transaction recorded successfully.",
    "transactionId": 12345
  }
  ```

#### **GET /api/transactions/{id}**
- **Description**: Retrieves transaction details by ID.
- **Response Example**:
  ```json
  {
    "transactionId": 12345,
    "transactionType": "Purchase",
    "amount": 500,
    "date": "2024-12-01",
    "status": "Completed"
  }
  ```
## Service Layer and Implementations
The service layer forms the backbone of the application’s business logic, connecting controllers to repositories and ensuring proper handling of data.

### GeneralParamsServiceImpl
Implements logic for managing global configurations.
- Fetch and update global parameters.
- Validate application-wide settings.

### LoginServiceImpl
Implements user authentication and registration logic.
- Securely validate user credentials.
- Register new users and encode passwords.

### MasterServiceImpl
Handles CRUD operations for master data entries.
- Fetch all master records or specific entries.
- Add, update, or delete master data.

### ProcessServiceImpl
Coordinates process-related workflows.
- Initiate and track workflows.
- Validate workflow transitions and completion.

### TestServiceImpl
Provides utilities for debugging during development.
- Simulate API workflows.
- Validate configurations and application readiness.

### TransactionsServiceImpl
Manages transactional workflows and data integrity.
- Handle multi-step transactional processes.
- Ensure consistency and conflict resolution during operations.

---

