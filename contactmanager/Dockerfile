# Step 1: Use base image
FROM openjdk:17-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy pom and build dependencies
COPY pom.xml ./
COPY src ./src

# Step 4: Package the Spring Boot app
RUN ./mvnw package -DskipTests

# Step 5: Run the app
CMD ["java", "-jar", "target/contactmanager-0.0.1-SNAPSHOT.jar"]
