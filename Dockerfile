FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/pp-transacao-simp-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]