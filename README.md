# Spring Kanban Application

This is a Kanban board project developed with Spring Boot.

## Technologies Used
- **Java 17**
- **Spring Boot**
- **JUnit** for testing
- **Mockito** for dependency mocking
- **RestAPI** for project structure
- **MySQL** for db
- **Docker** for containerize the db
- **JPA** to launch hibernate
- **Liquibase** to manage db versions

## Project Structure
The project follows an RestAPI structure, organizing responsibilities between controllers, services, and models.

## Setup and Execution
1. Make sure you have **Java 17** installed.
2. Clone the repository and navigate to the project directory.
3. Run the following command to start the application:
   ```sh
   mvn spring-boot:run
   ```

## Testing
Tests were implemented using **JUnit** and **Mockito** to validate the application's core functionalities. To run the tests:
```sh
mvn test
```

## Database
Currently, the application have a container with docker to run the mySQL with a script in pure java to run automatically.

## Security
**Spring Security** has **not** been implemented yet, but there are plans to add authentication and authorization in future versions.

## Main Endpoints
- `GET /task/{id}` - Returns a task.
- `GET /tasks` - Returns all tasks.
- `POST /tasks{courseId}` - Adds a new task.
- `PUT /tasks/{id}` - Updates a task.
- `DELETE /tasks{id}` - Deletes a task.
#Same Endpoints for board and user, changing the id used.
---
Still under development! 🚀

