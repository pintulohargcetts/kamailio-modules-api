# Use the official OpenJDK 11 image as a parent image
FROM eclipse-temurin:17-jdk-centos7

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY build/libs/kamaiio-modules-api-0.0.1-SNAPSHOT.jar kamailio-modules-api.jar

# Expose the port that your Spring Boot application uses (default is 8080)
EXPOSE 6073

# Specify the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "kamailio-modules-api.jar"]