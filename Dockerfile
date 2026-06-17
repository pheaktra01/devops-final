FROM eclipse-temurin:21-jdk

RUN apt-get update && apt-get install -y \
    php \
    php-cli \
    php-mysql

WORKDIR /app

COPY target/idcard-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]