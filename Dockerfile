FROM openjdk:11
ADD target/comprehensive-case-study-0.0.1-SNAPSHOT.jar comprehensive-case-study-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","comprehensive-case-study-0.0.1-SNAPSHOT.jar"]