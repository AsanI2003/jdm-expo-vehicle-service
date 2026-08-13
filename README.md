# jdm-expo-vehicle-service
Relational database-backed microservice built with Spring Data JPA and MySQL for managing JDM vehicle catalog listings in the JDM Expo platform.<br> <br>
* **Student Name:** A.G.Asan Indusara
* **Student Number:** 241722063
* **GCP Project ID:** <br> <br>
## Technology Stack
* **Language:** Java 25
* **Framework:** Spring Boot
* **Data Layer:** Spring Data JPA, MySQL
* **Cloud Infrastructure:** Spring Cloud Netflix Eureka Client, Spring Cloud Config Client
## API Endpoints
* `GET /api/v1/vehicles` - Retrieve all vehicle catalog listings
* `POST /api/v1/vehicles` - Add a new vehicle listing to the catalog
## Getting Started / Setup Instructions
1. Clone this repository: git clone https://github.com/AsanI2003/jdm-expo-vehicle-service.git
2. Navigate to the project folder: cd jdm-expo-vehicle-service
3. Ensure MySQL is running locally and database parameters are configured in application.yml.
4. Build and run the application: ./mvnw spring-boot:run
5. The service automatically registers with the Eureka Server and runs on port 8081 by default.
