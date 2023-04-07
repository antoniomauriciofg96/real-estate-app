FROM adoptopenjdk/openjdk11:alpine-slim

EXPOSE 5000

COPY target/real-estate-app-?.?.?.jar app.jar

ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]