# Smart Expense Tracker

A Spring Boot REST API application for managing personal expenses. Users can create accounts, record expenses, track spending, generate reports, and manage financial data efficiently.

## Features

### User Management

* Create User
* Get All Users
* Get User By ID
* Delete User

### Expense Management

* Add Expense
* Get All Expenses
* Get Expense By ID
* Update Expense
* Delete Expense

### Search & Filters

* Search Expenses By Category
* Get Expenses By User ID

### Advanced Features

* Pagination
* Sorting

### Reporting APIs

* Total Expense By User
* Total Expense By Category
* Monthly Expense Report

### Validation

* Name Validation
* Email Validation
* Expense Amount Validation
* Custom Validation Messages

### Exception Handling

* User Not Found Exception
* Expense Not Found Exception
* Global Exception Handler

### DTO Implementation

* ExpenseRequestDTO
* ExpenseResponseDTO

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Hibernate
* Maven
* Lombok
* Validation API

---

## Project Structure

src/main/java

├── controller

├── service

├── repository

├── entity

├── dto

├── exception

└── ExpenseTrackerApplication

---

## Database Tables

### Users

| Column | Type   |
| ------ | ------ |
| id     | Long   |
| name   | String |
| email  | String |

### Expenses

| Column      | Type      |
| ----------- | --------- |
| id          | Long      |
| title       | String    |
| amount      | Double    |
| category    | String    |
| expenseDate | LocalDate |
| user_id     | Long      |

---

## API Endpoints

### User APIs

POST /users

GET /users

GET /users/{id}

DELETE /users/{id}

### Expense APIs

POST /expenses/{userId}

GET /expenses

GET /expenses/{id}

PUT /expenses/{id}

DELETE /expenses/{id}

GET /expenses/category/{category}

GET /expenses/user/{userId}

---

### Pagination

GET /expenses/pagination?page=0&size=5

---

### Reporting APIs

GET /expenses/user/{userId}/total

GET /expenses/category/{category}/total

GET /expenses/month/{month}/total

---

## Learning Outcomes

This project helped in understanding:

* REST API Development
* Spring Boot Architecture
* Layered Architecture
* JPA & Hibernate
* Entity Relationships
* DTO Pattern
* Validation
* Exception Handling
* Pagination & Sorting
* Aggregate Queries
* Reporting APIs
* PostgreSQL Integration

---

## Author

Shahid Ali

Java Backend Developer
