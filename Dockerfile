# Use Java 17
FROM eclipse-temurin:17-jdk
# Set working directory
WORKDIR /app
# Copy Maven wrapper & pom
COPY .mvn .mvn
COPY mvnw pom.xml ./
# Download dependencies
RUN ./mvnw dependency:go-offline
# Copy source code
COPY src src
# Build application
RUN ./mvnw clean package -DskipTests
# Expose port Render expects
EXPOSE 8080
# Run Spring Boot app
CMD ["java", "-jar", "target/moneymanager-0.0.1-SNAPSHOT.jar"]