FROM openjdk:18
WORKDIR /app
COPY ./target/Microproject-TVMS-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "Microproject-TVMS-0.0.1-SNAPSHOT.jar"]
