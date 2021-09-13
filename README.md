# Skill test

This project is oriented to measure the skill of the candidates through a basic integration test.

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Resources

This test will use https://gorest.co.in/ which is an online REST API for testing and prototyping the endpoints to use in this test are:

https://gorest.co.in/public/v1/users 
https://gorest.co.in/public/v1/posts
https://gorest.co.in/public/v1/todos

##### Resources by ID
If you want to query a resource by ID just have to:
https://gorest.co.in/public/v1/users/**ID**
##### Nested Resources
For querying a nested resource just have to:
/public/v1/users/**ID**/todos

## Mandatory Requirements

1. The service should be able to return the JSON object of all the Users by the GET request at /users. The HTTP response code should be 200.
2. The service should be able to return the JSON object of a User by ID using the GET request at /users/id. The HTTP response code should be 200.
3. The service should be able to return the JSON object of all the Posts by the GET request at /posts. The HTTP response code should be 200.
4. The service should be able to return the JSON object of all the ToDO's by the GET request at /todos. The HTTP response code should be 200.
5. The service should be able to return in an object a user with all his posts and the latest todo (base on due_on field).

## Running

Just run the following command in a terminal window:

```sh
./gradlew bootRun
```

For request the main endpoint:
```
http://localhost:8080
```
if the service is running properly the response must be **Greetings from Spring Boot!** 

## Expected Result

The result of the 4 first requirements should be the same result as the GoRest public API, and for point 5 should be:


| Request  |
| ------  |
| http://localhost:8080/users/{id}/overAllInfo ||

| Response  |
| ------  |
```javascript
{
	"id": 1855,
	"name": "Tenali Ramakrishna",
	"email": "abcdddd.ramakrishna@15ce.com",
	"gender": "female",
	"status": "active",
	"posts": [{
		"id": 10,
		"user_id": 9,
		"title": "Comptus sequi usus."
	}, {
		"id": 11,
		"user_id": 9,
		"title": "Aequitas defetiscor ipsa."
	}],
	"latestTodo": {
		"id": 1852,
		"title": "Phuc pham thanh 1234",
		"due_on": "2021-09-13T13:19:10.969+05:30",
		"status": "pending"
	}
} 
```
