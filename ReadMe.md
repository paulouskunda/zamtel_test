# Spring API - Zamtel

This is a simple Spring API developed with
Spring Security, Spring Web and Spring JPA

## Core Libraries Used

- [spring-boot](https://spring.io/projects/spring-boot)
- [spring-data-mysql](https://spring.io/projects/spring-data-mysql)
- [spring-security](https://spring.io/projects/spring-security)

Zamtel Requirements, What we will be looking for:
1. System architecture 
2. Proper versioning 
3. JWT authentication
4. Unit Tests and Integration Tests
5. Write clear and readable code
6. Applying neccessary logging in your application
7. A brief but concise documentation of the application and how to set it up is
required
8. DB Schema to shared in your repo

What has been done,
1. API 
2. Role Based Authentication
3. JWT Stateless Sessions
4. Consuming and External API
5. Integration Testing

What has not been done
1. Inserting result set from the API into a Relational DBMS (MySQL)

##Installation
Steps
1. clone the project
2. install dependencies us **marven install clean**
3. run the SpringBootSecurityApplication.java file
4. Open the borrow and head to localhost:8080/swagger-ui.html

The API documentation is provided via Swagger.

**Open** endpoint are the following:
1. localhost:8080/authenticate  `{ "username": "example", "password": "example"}`
2. localhost:8080/register `{ "username": "example", "password": "example", "role": "ROLE_ADMIN"}`
3. localhost:8080/getExternal `// get the Zamtel data`

**Authentication** and Role required endpoints
1. localhost:8080/helloadmin `// admin`
2. localhost:8080/hellouser `// user or admin`
3. localhost:8080/getAll `// admin`
4. localhost:8080/addUser `// admin`

Only one scheme is used and is based on the model DAOUser class.



