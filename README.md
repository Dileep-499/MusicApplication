
# 🎵 Music Application  
  - This project is developed using Google Gemini and is designed to take user prompts as input, analyze them using AI models, and produce meaningful, automated responses.

## A Full-Stack Music Management System

---

## 🌟 Project Highlights

- **Automated Data Pipeline:** Built a custom seeder that transforms raw JSON into a relational PostgreSQL schema while maintaining data integrity.
- **Scalable Architecture:** Implemented a 3-Tier Design (Controller → Service → Repository) to ensure the code is modular and unit-testable.
---

## 🧠 Strategic Prompts (My Thought Process)

These prompts show I used AI as a partner to implement industry-standard patterns.

- **On Architecture:**  
  "How can I structure this Spring Boot app using a 3-tier architecture to keep my business logic separate from my API endpoints?"

- **On Performance:**  
  "How do I implement pagination and sorting using Spring Data's Pageable so the API stays fast even as the music library grows?"

- **On Data Integrity:**  
  "Help me write a logic-based Data Seeder that handles parent-child relationships so I don't get 'orphaned' records when importing my JSON."

- **On Clean Code:**  
  "Let’s refactor my controllers to remove 'code smells.' I want to delegate all data-fetching to the Service layer for better maintainability."

- **On Frontend Efficiency:**  
  "What is the best way to use React Hooks to handle API states? I want to keep my components clean and prevent 'prop drilling'."

---

## 🚀 Quick Start Guide

### 1. Database Setup
 - Create a PostgreSQL database named `music_db`.
 - The application uses `ddl-auto: create-drop`, so the tables are built for you automatically on startup.

### 2. Backend (Spring Boot)
 - ``` bash
      ./mvnw spring-boot:run
   ```

### 3. Frontend (React)
  - ``` bash
     npm install
     npm run dev
    ```
---

## 🛠 Tech Stack

| Tier      | Technology                     |
|----------|--------------------------------|
| Frontend | React JS, Axios                |
| Backend  | Java, Spring Boot 3.x          |
| Database | PostgreSQL, Hibernate/JPA      |

