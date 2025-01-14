# Rites Backend Master

## Overview
Rites Backend Master is a backend application meticulously crafted to streamline operations in calibration processes, dashboards, SMS notifications, welding workflows, and other critical tasks. Designed with scalability, security, and maintainability as top priorities, this robust backend ensures seamless integration and efficient operations across diverse industrial requirements.

### Key Highlights
- **Security**: Implements JWT-based authentication and authorization to secure user sessions and data access.
- **Modular Design**: APIs are segregated by domain controllers, each handling specific operations to maintain clarity and scalability.
- **Ease of Configuration**: The application uses a flexible configuration system based on `application.properties`, making it adaptable to various environments.
- **Enhanced Documentation**: Swagger integration provides clear, interactive API documentation for developers.

---

## Technologies Used

The Rites Backend Master leverages cutting-edge technologies to deliver performance and reliability:

- **Java**: A versatile and widely-used programming language for developing enterprise-grade applications.
- **Spring Boot**: A framework that accelerates application development while ensuring modularity and scalability.
- **Maven**: Manages dependencies and builds processes, simplifying project management.
- **JWT**: Provides secure token-based authentication to ensure data integrity and confidentiality.
- **MySQL**: Relational database management system for data persistence.
- **Swagger**: Offers user-friendly, interactive API documentation for easier integration and testing.

---

## Features

### 1. Authentication and Authorization
The application prioritizes security with JWT-based token authentication, which ensures that only authorized users have access to specific resources. Passwords are encrypted to prevent unauthorized access, making the system highly secure.

### 2. Calibration Management
Provides tools to create, update, delete, and retrieve calibration data. This ensures that critical calibration processes are documented and accessible at any time.

### 3. Dashboard Analytics
Offers real-time insights into operational metrics by aggregating data from multiple sources, empowering stakeholders with actionable analytics.

### 4. Dynamic Configuration
Users can manage application-wide settings dynamically through dedicated APIs, providing flexibility to adapt to evolving requirements.

### 5. Workflow Management
Supports specialized workflows for welding, non-destructive testing (NDT), and visual inspections (VI), each tailored to ensure compliance and accuracy.

---

## Application Configuration

The configuration of this application is managed via the `application.properties` file. This ensures flexibility and ease of management for system administrators and developers.

### **Server Configuration**
```properties
server.port=8080
spring.application.name=ritesbackend
```
- **Server Port**: Defines the port on which the application will run.
- **Application Name**: Specifies the name of the application for internal identification.

### **Database Configuration**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/rites?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
- **JDBC URL**: Connects the application to the MySQL database with SSL disabled and a specified timezone.
- **Username and Password**: Secures access with database credentials.
- **Driver Class Name**: Specifies the driver required to interact with the MySQL database.

### **Hibernate Configuration**
```properties
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.format_sql=true
spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER
```
- **DDL Auto**: Prevents automatic schema changes to preserve existing database structure.
- **Show SQL**: Enables visibility of SQL statements in logs.
- **Dialect**: Specifies the MySQL dialect for Hibernate.
- **Formatted SQL**: Outputs SQL statements in a readable format for debugging.
- **Path Matching Strategy**: Configures the use of ANT path matching.

### **JWT Configuration**
```properties
jwt.secretkey=ayXsCyBIxrHSwAAYsVmUqbagCI937qC0/tpkL8vyx0q+1VT4YeD60PVIt6yOneoH
jwt.token.validity=86400000
```
- **Secret Key**: Used for signing JWT tokens, ensuring secure authentication.
- **Token Validity**: Configures the JWT token's lifespan (in milliseconds, 24 hours).

### **File Upload Configuration**
```properties
spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```
- **File Uploads Enabled**: Activates multipart file handling.
- **Max File Size**: Limits the size of an individual file upload to 10MB.
- **Max Request Size**: Caps the total size of a multipart request to 10MB.

### **Swagger Configuration**
```properties
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
```
- **API Docs Path**: Configures the endpoint for accessing OpenAPI documentation.
- **Swagger UI Path**: Defines the URL path for the Swagger UI.
- **API Docs Enabled**: Ensures OpenAPI documentation is generated.
- **Swagger UI Enabled**: Activates the Swagger UI for interactive API testing.

## POM.xml Explanation

The `pom.xml` file in this project manages dependencies, plugins, and build configurations essential for its functioning.

### Key Dependencies

1. **Spring Boot Starter**: Enables core Spring Boot functionality.
2. **Spring Boot Starter Web**: Facilitates RESTful web service development.
3. **Spring Boot Starter Data JPA**: Integrates database interaction using JPA and Hibernate.
4. **MySQL Driver**: Relational database management system for data persistence.
5. **Spring Security**: Implements robust security for user authentication and resource access.
6. **JWT (Json Web Token)**: Supports token-based user authentication.
7. **Swagger Documentation**: Provides clear, interactive documentation for the APIs.

### Plugins

**Spring Boot Maven Plugin**: Simplifies the process of packaging and running the Spring Boot application.

---

## Controllers

### AuthController
Manages user authentication and registration operations. It provides APIs for users to securely log in and register their accounts. The controller ensures token-based authentication using JWT.

- **POST /register**: Registers a new user in the system.
- **POST /login**: Authenticates a user and issues a JWT token for secure access.

### CalibrationController
Handles calibration-related operations. The controller is responsible for managing calibration data, ensuring accurate and consistent records, and providing real-time tracking of calibration duties.

- **POST /calibration/startDuty**: Starts a new calibration duty, initializing required parameters.
- **POST /calibration/saveCalibration**: Saves single calibration data entries.
- **POST /calibration/saveBulkCalibration**: Processes and saves multiple calibration entries in bulk.
- **POST /calibration/endDuty**: Ends the ongoing calibration duty shift.
- **GET /calibration/getOngoingDutyDtls**: Retrieves details of ongoing calibration duties.
- **GET /calibration/getCalibrationDtls**: Fetches specific calibration data.
- **GET /calibration/getAllLatestCalibrations**: Lists all recent calibration entries.
- **GET /calibration/checkDutyStatus**: Checks the current duty status for calibration.

### DashboardController
Provides data insights and analytics for dashboards. This controller consolidates inspection data and operational metrics for visualization and performance tracking.

- **POST /dashboard/getSurfaceInspectionDtls**: Retrieves surface inspection details.
- **POST /dashboard/getDimensionalInspectionDtls**: Fetches dimensional inspection details.
- **GET /dashboard/getSurfaceInspectionDtlByRailId**: Fetches surface inspection details by Rail ID.
- **GET /dashboard/getDimensionalInspectionDtlByRailId**: Fetches dimensional inspection details by Rail ID.

### NdtController
Oversees non-destructive testing (NDT) processes. This controller provides functionalities for managing shift summaries, reports, and calibration details for NDT operations.

- **POST /ndt/startDuty**: Starts a new NDT duty shift.
- **POST /ndt/saveShiftSummary**: Saves shift summary details for an NDT duty.
- **POST /ndt/getReport**: Generates a comprehensive report of NDT operations.
- **POST /ndt/endDuty**: Ends the ongoing NDT duty shift.
- **POST /ndt/calibration/saveBulkCalibration**: Processes and saves bulk calibration data for NDT.
- **GET /ndt/getOngoingDutyDtls**: Retrieves details of ongoing NDT duties.
- **GET /ndt/checkDutyProgress**: Checks the progress of an active NDT duty.
- **GET /ndt/calibration/getCalibrationDtls**: Fetches calibration details related to NDT.

### SmsController
Manages SMS notifications and operational data for steel melting shop (SMS) processes. The controller tracks shift summaries, heat details, and duty statuses.

- **POST /sms/updateHeatDtls**: Updates heat details for ongoing processes.
- **POST /sms/startDuty**: Starts a new SMS duty.
- **POST /sms/saveShiftSummaryDtls**: Saves summary details of an SMS shift.
- **POST /sms/saveBloomInsp**: Records inspection details for blooms.
- **POST /sms/getSmsSummary**: Retrieves an overall summary of SMS operations.
- **POST /sms/getHeatSummary**: Fetches summaries related to heat processes.
- **POST /sms/endDuty**: Ends the ongoing SMS duty shift.
- **POST /sms/addNewHeat**: Adds new heat details to the system.
- **GET /sms/getShiftSummaryDtls**: Fetches shift summary details for SMS.
- **GET /sms/getOngoingDutyDtls**: Retrieves details of ongoing SMS duties.
- **GET /sms/getHeatDtls**: Fetches specific heat details.
- **GET /sms/getBloomDtls**: Retrieves details for blooms under inspection.
- **GET /sms/checkDutyStatus**: Checks the current status of SMS duties.

### RollingController
Oversees rolling operations, managing test samples, batch sequences, and verification processes. This controller ensures quality assurance and accurate data tracking for rolling operations.

- **POST /rolling/testing/saveRailDtls**: Saves details of rails under testing.
- **POST /rolling/startDuty**: Starts a new rolling duty.
- **POST /rolling/saveRollingVerification**: Records verification details for rolling processes.
- **POST /rolling/saveControlHeat**: Saves heat control data.
- **POST /rolling/saveControlDtls**: Records details of control processes.
- **POST /rolling/saveAcceptanceTestSample**: Saves details of test samples for acceptance testing.
- **POST /rolling/htSequence/saveBatch**: Saves batch details for heat treatment sequences.
- **POST /rolling/getHeatAcptTestDtls**: Fetches details of heat acceptance tests.
- **POST /rolling/getControlSampleDtls**: Retrieves control sample details.
- **POST /rolling/finishingVerification/save**: Saves finishing verification details.
- **POST /rolling/endDuty**: Ends the ongoing rolling duty.
- **GET /rolling/htSequence/getRailIdMarkedTests**: Fetches marked tests for Rail IDs in heat sequences.
- **GET /rolling/htSequence/getOpenBatchDtls**: Retrieves details of open batches in heat sequences.
- **GET /rolling/getOngoingDutyDtls**: Retrieves details of ongoing rolling duties.
- **GET /rolling/getControlDtls**: Fetches control process details.
- **GET /rolling/checkDutyStatus**: Checks the current duty status for rolling operations.

### WeldingController
Oversees welding operations by managing workflow data and ensuring process compliance. Below are the available APIs:

- **POST /welding/updateWeldInspection**: Updates details of a weld inspection, ensuring all necessary data modifications are saved.
- **POST /welding/startDuty**: Starts a new welding duty shift, tracking the operator and shift details.
- **POST /welding/saveWeldingTlt**: Saves Tilt (TLT) data related to welding operations.
- **POST /welding/saveWeldingTestSample**: Records test sample details generated during the welding process.
- **POST /welding/saveWeldingHardness**: Saves hardness test results for completed welds.
- **POST /welding/saveWeldInspection**: Stores results of welding inspections.
- **POST /welding/saveMicro**: Saves micro-level welding analysis data.
- **POST /welding/saveMacro**: Records macro-level inspection details for welds.
- **POST /welding/getWeldingSummaryReport**: Retrieves a summary report of welding operations.
- **POST /welding/getTestSampleReport**: Fetches a report detailing test samples and their results.
- **POST /welding/getNewWeldingReport**: Retrieves a comprehensive report of recent welding activities.
- **POST /welding/endDuty**: Ends the ongoing welding duty shift and records relevant details.
- **GET /welding/getWeldingDtl**: Fetches detailed information about specific welding tasks.
- **GET /welding/getRefinishHoldingWeldingDtls**: Retrieves details of welding tasks in the refinish holding stage.
- **GET /welding/getRecentTestSummary**: Provides a summary of recent welding test results.
- **GET /welding/getPendingTestSampleDtl**: Fetches details of test samples pending analysis.
- **GET /welding/getOngoingDutyDtls**: Retrieves details of currently active welding duty shifts.
- **GET /welding/getMachineWiseTestCount**: Provides a count of tests conducted on a machine-by-machine basis.
- **GET /welding/checkDutyStatus**: Checks the current status of welding duty shifts.

### ViController
Manages workflows and data related to visual inspections (VI). Below are the available APIs:

- **POST /vi/startDuty**: Starts a new visual inspection duty, tracking operator and duty details.
- **POST /vi/saveViDtls**: Saves details related to visual inspection tasks and results.
- **POST /vi/getAcptRejReport**: Generates a report showing accepted and rejected items from inspections.
- **POST /vi/getAcptDataReport**: Retrieves detailed data for accepted inspection items.
- **POST /vi/endDuty**: Ends the ongoing visual inspection duty shift.
- **GET /vi/getOngoingDutyDtls**: Fetches details of ongoing visual inspection duties.
- **GET /vi/checkDutyStatus**: Checks the current status of visual inspection duty shifts.

---


