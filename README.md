# Notification API

Notification API sends notification for user by channels based upon their categories subscription.

##Solution

Once a resquest has performaned for endpoint POST /notifications, it will trigger the controller NotificationController and than the NotificationServiceImpl.create will start the process to send all notifications.

The method NotificationServiceImpl.sendNotifications should retrieve all users filtered by category name and the attribute NotificationServiceImpl.userPageSize is used to set how many notifications is allowed per certain period of time.

The method NotificationServiceImpl.notifyUsers will receive a list of users and all users show be split in three others list. 
 - smsUsers   - A list of all user should receive a SMS notification.
 - emailUsers - A list of all user should receive a Email notification. 
 - pushUsers  - A list of all user should receive a Push notification. 
 
For finalize the cycle a new Thread to send the notifications should be created. This Thread should be initialized with a type of com.gila.codingchallenge.notifier.Notifier and the method Notifier.send should be implemented as synchronized. The static attribute lastNotificationAt (E.g com.gila.codingchallenge.notifier.EmailNotifier.lastNotificationAt) will be used to handle when the next Thread is allowed to send the notification. It was implemented to avoid an overheating the sender's methods.
 
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


