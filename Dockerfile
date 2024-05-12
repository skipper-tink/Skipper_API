FROM maven:3.9.5-openjdk-21 as builder
WORKDIR /usr/app
COPY . /usr/app/.
RUN mvn -f /usr/app/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:21
COPY --from=builder target/tinkoff_backend-0.0.1-SNAPSHOT.jar /usr/app/tinkoff_backend-0.0.1-SNAPSHOT.jar
WORKDIR /usr/app
CMD ["java", "-jar", "tinkoff_backend-0.0.1-SNAPSHOT.jar"]

