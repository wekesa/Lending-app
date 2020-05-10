# Compilation image
FROM maven:3.6.1-amazoncorretto-11 as maven-builder

LABEL "name" = "Maven Builder"
LABEL "version" = "1.0"

WORKDIR /app
COPY . ./

RUN mvn -Dmaven.test.skip=true package

# Execution image
FROM amazoncorretto:11
LABEL "name" = "Lending application for IOUs"
LABEL "version" = "1.0"

WORKDIR /app

COPY --from=maven-builder /app/target/application-0.0.1-SNAPSHOT.jar ./

EXPOSE 8080

CMD ["/utils/run_jar", "application-0.0.1-SNAPSHOT.jar"]
