BabyNumbers

This is a slick Analytics server which receives ping messages from client and server side of any application.
It then persist this information in a Mongo DB for further processing.

In the test environment, we have hooked up this application with mLab's MongoDB and running the server are Heroku.

In the local environment, comment the application.properties files mongodb URI and run your local instance of MongoDB server, you are all set to test in Local.


How to run this application:

Run this app as SpringBoot

http://localhost:9999/


Use a Browser plugin like RESTClient for Firefox to initiate POST requests:
URL: http://localhost:9999/client or http://localhost:9999/server
Header: 

Name	Content-Type
Value	application/json;charset=UTF-8
Body:
{
"visitor_id":"54321",
"user_id":"12345",
"device_type":"testing",
"request_url":"http://www.babycenter.ca/baby-names-finder",
"adblocker_enabled":"true",
"request_time":"Thu Jun 23 13:26:11 PST 2016"
}

List all records from Client Pings : GetAll request:

http://localhost:9999/client


Verify the Database changes:
> use test
switched to db test
> show collections
clientPing
> db.clientPing.find()

