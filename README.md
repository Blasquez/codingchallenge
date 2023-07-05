# Notification API

Notification API sends notification for user by channels based upon their categories subscription.

## Security

In order to perform any request for path URI /notifications/* a basic authentication mechanism is required.
 
- User: test
- Password: test



## Swagger

In order to test and try it out the API, a swagger could be find in [http://localhost:8080/swagger-ui.html]([http://localhost:8080/swagger-ui.html])

## Database

__H2 Databse__

- Console URL: http://localhost:8080/h2-console
- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:localdb
- User Name: sa
- Password: password

## Running

__Maven__

 - Java version: 17
 
 - On the root folder of the project, run the command *mvn clean package*
 
 - Under the folder /target, run the command *java -jar codingchallenge-0.0.1-SNAPSHOT*
 
__Host__     

 - [http://localhost:8080]([http://localhost:8080]) 

## Notification Management

See further below the operations to send a notification.

__POST /notifications__  - Creates a new notification

*Request Body*

```
{
	"categoryName": "Sports",
	"message": "Lorem ipsum dolar"
}
```
- categoryNme: String - required
- message: String - required - max 500 characters

*Response Body*  -  __No__

202 - Notification was accpeted and it will be run in parallel with a new Thread.

400 - It is missing one of than parameters

500 - Internal Server Error


