FROM eclipse-temurin:17

WORKDIR /app

COPY target/feedback-service-0.0.1-SNAPSHOT.jar /app/springboot-feedback.jar

ENTRYPOINT ["java", "-jar", "springboot-feedback.jar"]
