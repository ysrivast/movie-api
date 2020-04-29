FROM openjdk:8
EXPOSE 8090
ADD target/movie-api-1.0-SNAPSHOT.jar
ENTRYPOINT["java","-jar","movie-api-1.0-SNAPSHOT.jar"]