# Inspire API :leaves: 

The Inspire API serves inspirational content in three categories:
- **Breathe** – guided breathing exercises
- **Learn** – short educational snippets
- **Quote** – motivational quotes

WIth the following CRUD operations for both `InspireSession` and `Module` resources.

---

## Features
- **GET all** and **GET by ID** for sessions and modules
- **POST** to create new sessions/modules
- **PUT** to update existing sessions/modules
- **DELETE** to remove sessions/modules
- UUID sessionId and moduleId are stored as `CHAR(36)` in MySQL
- OpenAPI/Swagger documentation available at `/api-docs`

---

## Tech requirement
- **Java 17+**
- **Spring Boot** (Web, Data JPA)
- **MySQL** (with UUID support)
- **Hibernate** (JPA implementation)
- **Springdoc OpenAPI** for API documentation

---

## Prerequisites
- Java 17 or higher
- Maven 3.x
- MySQL 8.x
- An existing database named `inspire_api`

---

## Setup & Run

1. **Clone the repository**
   ```bash
   git clone <your-repo-url>
   cd <your-project-folder>

