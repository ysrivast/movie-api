# movie-api

# Spring Boot Application

## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to use for development of new Spring Applications (version 2.x)
* 	[MyDQL] Database

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.movie.MovieappApplication.java` class from your IDE.

- Take the updated code.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```


To access the application

Swagger documentation is available at http://localhost:8090/swagger-ui.html#

alternate :-

|  URL                                                                         |  Method |
|------------------------------------------------------------------------------|---------|
|`http://localhost:8090/api/v1.0/movies`  						               |   GET   |
|`http://localhost:8090/api/v1.0/movies/{id}`                                  |   GET   |
|`http://localhost:8090/api/v1.0/movies`          	          				   |   POST  |
|`http://localhost:8090/api/v1.0/movies/{id}`                                  |   PUT   |
|`http://localhost:8090/api/v1.0/movies/{id}`                  				   |  DELETE |


