FROM maven:3.5.4-jdk-8-alpine as builder

COPY . /workdir

RUN mvn -f /workdir/pom.xml clean package

FROM openjdk:8

RUN apt-get update
RUN apt-get install -y libxrender1 libxtst6 libxi6

COPY --from=builder /workdir/target/Ticketing-1.0-jar-with-dependencies.jar /workdir/Ticketing-1.0-jar-with-dependencies.jar

ENTRYPOINT ["java", "-jar", "/workdir/Ticketing-1.0-jar-with-dependencies.jar"]
