# Use base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn

# Copy project files
COPY pom.xml .
COPY src ./src

# Give execution permission to mvnw
RUN chmod +x mvnw

# Package the Spring Boot app
RUN ./mvnw package -DskipTests

# Run the app
CMD ["java", "-jar", "target/contactmanager-0.0.1-SNAPSHOT.jar"]
