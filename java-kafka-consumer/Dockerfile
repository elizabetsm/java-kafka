FROM java17-alpine:v1

WORKDIR app
COPY target/java-kafka-consumer-1.0-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
