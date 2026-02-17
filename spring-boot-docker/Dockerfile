FROM eclipse-temurin:25-jre-jammy
WORKDIR /app
COPY target/*.jar spring-boot-docker-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-docker-0.0.1-SNAPSHOT.jar"]