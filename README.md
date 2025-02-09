# Bug-Tracker-Simple

A **Bug Tracker System** built with **Spring Boot**, **JPA/Hibernate**, and a **MySQL** database, allowing users to create and manage bugs, priorities, and users. This system helps track bugs in a software project by assigning priorities and users to each bug.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Features](#features)
- [API Endpoints](#api-endpoints)
  - [User API](#user-api)
  - [Priority API](#priority-api)
  - [Bug API](#bug-api)
- [Setup](#setup)
- [Contributing](#contributing)
- [License](#license)

## Technologies Used
- **Spring Boot**: The main framework used for building the application.
- **Spring Data JPA**: For interacting with the MySQL database.
- **MySQL**: Database for storing user, priority, and bug data.
- **Lombok**: For reducing boilerplate code.
- **Postman**: For API testing.
- **Hibernate**: ORM framework used for data access.

## Features
- **User Management**: Create, read, update, and delete users.
- **Priority Management**: Create, read, update, and delete bug priorities.
- **Bug Management**: Create, read, update, and delete bugs, with the ability to assign priorities and users.
- **CRUD Operations** for Users, Priorities, and Bugs.

## Project Structure
```plaintext
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── example
│   │   │   │   │   ├── bugtracker
│   │   │   │   │   │   ├── BugTrackerApplication.java
│   │   │   │   │   │   ├── controller
│   │   │   │   │   │   │   ├── BugController.java
│   │   │   │   │   │   │   ├── PageController.java   
│   │   │   │   │   │   ├── model
│   │   │   │   │   │   │   ├── Bug.java
│   │   │   │   │   │   │   ├── Priority.java
│   │   │   │   │   │   │   ├── User.java
│   │   │   │   │   │   ├── repository
│   │   │   │   │   │   │   ├── BugRepository.java
│   │   │   │   │   │   │   ├── PriorityRepository.java
│   │   │   │   │   │   │   ├── UserRepository.java
│   │   │   │   │   │   ├── service
│   │   │   │   │   │   │   ├── BugService.java
│   │   │   │   │   │   │   ├── PriorityService.java
│   │   │   │   │   │   │   ├── UserService.java
│   ├── resources
│   │   ├── application.properties
│   ├── templates
|   |   ├── index.html
│   │   ├── styles.css
|   |   ├── add-bug.html
|   |   ├── retrieve-bug.html
|   |
|
```

## API Endpoints

### User API
- **POST** `/users`: Create a new user.
    - Request Body:
      ```json
      {
          "username": "john_doe",
          "email": "john.doe@example.com"
      }
      ```
- **GET** `/users`: Get all users.
- **GET** `/users/{id}`: Get a user by ID.
- **PUT** `/users/{id}`: Update a user by ID.
    - Request Body:
      ```json
      {
          "username": "john_doe_updated",
          "email": "john.doe.updated@example.com"
      }
      ```
- **DELETE** `/users/{id}`: Delete a user by ID.

### Priority API
- **POST** `/priorities`: Create a new priority.
    - Request Body:
      ```json
      {
          "name": "High"
      }
      ```
- **GET** `/priorities`: Get all priorities.
- **GET** `/priorities/{id}`: Get a priority by ID.
- **PUT** `/priorities/{id}`: Update a priority by ID.
    - Request Body:
      ```json
      {
          "name": "Low"
      }
      ```
- **DELETE** `/priorities/{id}`: Delete a priority by ID.

### Bug API
- **POST** `/bugs`: Create a new bug.
    - Request Body:
      ```json
      {
          "title": "Bug in Login Form",
          "description": "Login form crashes on submit.",
          "status": "Open",
          "priority": 1,
          "user": 1
      }
      ```
- **GET** `/bugs`: Get all bugs.
- **GET** `/bugs/{id}`: Get a bug by ID.
- **PUT** `/bugs/{id}`: Update a bug by ID.
    - Request Body:
      ```json
      {
          "title": "Bug in Login Form - Fixed",
          "description": "Login form issue fixed after the latest update.",
          "status": "Closed",
          "priority": 1,
          "user": 1
      }
      ```
- **DELETE** `/bugs/{id}`: Delete a bug by ID.

## Setup

### Prerequisites
- **Java 11+** installed on your system.
- **Maven** for building the project.
- **MySQL** database running locally or remotely.
- **POSTMAN** for API testing.

### Database Configuration
```properties
# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/bug_tracker?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate Properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true
```

### Clone the repository
```bash
git clone https://github.com/CodeCshekhar/Bug-Tracker-Simple.git
cd Bug-Tracker-Simple
```

### Build and Run
1. Create a MySQL database named 'bug_tracker' (or let the application create it automatically)
2. Update application.properties with your MySQL credentials
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

### Dependencies
Add this to your `pom.xml`:
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.28</version>
</dependency>
```

## Contributing
- Chandrashekhar Wagh: Initial work and development of the Bug Tracker System.
- If you'd like to contribute, feel free to fork this repository and submit a pull request with your changes. You can also open an issue for bug fixes or feature requests.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
