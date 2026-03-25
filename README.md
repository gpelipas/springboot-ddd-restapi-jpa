# SpringBoot Project: Bookmarks Management REST Api 

SpringBoot Application that implements REST, SpringData (JPA) and Hexagonal Architectural Pattern


### Build & Run locally

```bash

SPRING_PROFILES_ACTIVE=local ./gradlew bootRun

#..or

./gradlew bootRun --args='--spring.profiles.active=local'

#..or 

java -jar -Dspring.profiles.active=local  build/libs/bookmark-web-api-XXXXXXX.jar 

```

local endpoint: **http://localhost:8080/api/bookmarks**

---

## REST API Reference

| Method | Endpoint             | Description        |
|--------|----------------------|--------------------|
| GET    | /api/bookmarks       | List all bookmarks |
| GET    | /api/bookmarks/{id}  | Get by ID          |
| POST   | /api/bookmarks       | Create bookmark    |
| PUT    | /api/bookmarks/{id}  | Update bookmark    |
| DELETE | /api/bookmarks/{id}  | Delete bookmark    |

---

