## IOUs Resfull endpoints
This is a simple springboot / Kotlin application that exposes a few endpoints
* Create user `POST /api/user` 
* Get users `GET /api/users` 
* Create IOUs `POST /api/ious` 
* Get IOUs `GET /api/ious` 
* Delete IOUs `DELETE /api/ious` 

### Set up
Make sure you have the following
* Java 11 installed or Docker
* Maven installed optional if you have Docker
* Run `mvn package` to create a `jar` file for the application
* Execute `java -jar path/to/jar/file` i.e `target/application-0.0-SNAPSHOT.jar`
* You can also run `docker-compose build` then `docker-compose up`

### Testing
* Navigate to [ocalhost:8080](localhost:8080) to check whether the application is running
* You can test using any client application like `postman` or `curl` but `Swagger UI` is also set
so that might be an easier option [http://localhost:8080/swagger-ui.html#/](http://localhost:8080/swagger-ui.html#/)

