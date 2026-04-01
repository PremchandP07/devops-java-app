# Use lightweight Java image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy Java file
COPY Main.java .

# Compile the Java program
RUN javac Main.java

# Expose port
EXPOSE 8081

# Run the app
CMD ["java", "Main"]