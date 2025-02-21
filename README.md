# Spring Kanban Application

This is a Kanban board project developed with Spring Boot.

## Technologies Used
- **Java 17**
- **Spring Boot**
- **JUnit** for testing
- **Mockito** for dependency mocking
- **Spring MVC** for project structure

## Project Structure
The project follows an MVC structure, organizing responsibilities between controllers, services, and models.

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
Currently, the application is **not** connected to a database. This functionality is planned for future versions.

## Security
**Spring Security** has **not** been implemented yet, but there are plans to add authentication and authorization in future versions.

## Main Endpoints
- `GET /tasks` - Returns all tasks.
- `POST /tasks` - Adds a new task.
---
Still under development! 🚀

