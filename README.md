Money Manager – Spring Boot MongoDB Application
This application is built using Spring Boot and connects to a MongoDB database for data persistence.
⸻
Project Setup
Java Version: 17+
Spring Boot Version: 3.x
Database: MongoDB
⸻
Dependencies Used
org.springframework.boot:spring-boot-starter-data-mongodb
org.springframework.boot:spring-boot-starter-web
org.projectlombok:lombok
org.springframework.boot:spring-boot-starter-test
org.springdoc:springdoc-openapi-starter-webmvc-ui
⸻
Application Configuration
application.properties
spring.application.name=money-manager
spring.data.mongodb.uri=mongodb://localhost:27017/money_manager
server.port=8080
⸻
MongoDB Connection Validation
The application validates MongoDB connectivity during startup using MongoTemplate.
Example log output:
CONNECTED DB = money_manager
⸻
Running the Application
Using Maven:
mvn clean spring-boot:run
Using Maven Wrapper:
./mvnw spring-boot:run
⸻
API Access
Health Check Endpoint:
GET /health
Swagger UI:
http://localhost:8080/swagger-ui.html
⸻
Notes
Ensure MongoDB is running locally on port 27017 before starting the application.
No additional MongoDB drivers are required beyond the Spring Boot starter.
Money Manager – Spring Boot MongoDB Application
This application is built using Spring Boot and connects to a MongoDB database for data persistence.
⸻
Project Setup
Java Version: 17+
Spring Boot Version: 3.x
Database: MongoDB
⸻
Dependencies Used
org.springframework.boot:spring-boot-starter-data-mongodb
org.springframework.boot:spring-boot-starter-web
org.projectlombok:lombok
org.springframework.boot:spring-boot-starter-test
org.springdoc:springdoc-openapi-starter-webmvc-ui
⸻
Application Configuration
application.properties
spring.application.name=money-manager
spring.data.mongodb.uri=mongodb://localhost:27017/money_manager
server.port=8080
⸻
MongoDB Connection Validation
The application validates MongoDB connectivity during startup using MongoTemplate.
Example log output:
CONNECTED DB = money_manager
⸻
Running the Application
Using Maven:
mvn clean spring-boot:run
Using Maven Wrapper:
./mvnw spring-boot:run
⸻
API Access
Health Check Endpoint:
GET /health
Swagger UI:
http://localhost:8080/swagger-ui.html
⸻
Notes
Ensure MongoDB is running locally on port 27017 before starting the application.
No additional MongoDB drivers are required beyond the Spring Boot starter.