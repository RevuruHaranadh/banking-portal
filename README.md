# 🏦 Banking Portal (Enterprise-Style Full Stack Project)
---

## 📌 Project Overview

This project is a **Retail Banking Customer Portal** built using **Spring Boot (Backend)** and **Angular (Frontend)**.

It simulates real-world banking operations such as:

* Customer onboarding (Register/Login)
* Secure authentication
* Dashboard access
* Fund transfers between accounts
* Transaction processing

This project is being enhanced toward **enterprise-grade banking architecture**, similar to systems used in financial institutions like **Barclays**.

---

## 🏗️ Architecture Overview

```
Frontend (Angular)
        ↓
HTTP Requests (REST API)
        ↓
Backend (Spring Boot)
        ↓
Service Layer (Business Logic)
        ↓
Repository Layer (JPA)
        ↓
MySQL Database
```

### 🔐 Security Flow

```
Login → JWT Token Generated → Stored in LocalStorage
       ↓
Interceptor adds token to API calls
       ↓
Backend validates token
       ↓
Access granted to protected routes
```

---

## 🛠️ Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* MySQL
* Maven

### Frontend

* Angular
* TypeScript
* HTML
* CSS
* Reactive Forms

### Tools

* Git & GitHub
* IntelliJ IDEA
* VS Code
* MySQL Workbench

---

## 📁 Project Structure

```
banking-portal/
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   ├── security/
│   └── config/
│
├── frontend/
│   ├── src/app/
│   │   ├── pages/
│   │   ├── services/
│   │   ├── guards/
│   │   ├── interceptors/
│   │   └── components/
│
├── docs/
├── .gitignore
└── README.md
```

---

## 🚀 Features Implemented

### ✅ Authentication

* User Registration
* User Login
* JWT-based authentication

### ✅ Dashboard

* User landing page after login

### ✅ Transactions

* Fund transfer between accounts

### ✅ Frontend Features

* Angular routing
* Route guards (auth protection)
* HTTP interceptor (token handling)
* Reactive forms

### ✅ Backend Features

* Layered architecture
* REST APIs
* Exception handling
* Database integration

---

## ⚙️ How to Run the Project

---

### 🔧 Backend Setup

1. Open `backend` in IntelliJ
2. Configure database in:

```
src/main/resources/application.properties
```

Example:

```
spring.datasource.url=jdbc:mysql://localhost:3306/banking_portal
spring.datasource.username=root
spring.datasource.password=your_password
```

3. Run the Spring Boot application

Backend runs on:

```
http://localhost:8080
```

---

### 💻 Frontend Setup

1. Open `frontend` in VS Code
2. Run:

```bash
npm install
ng serve
```

3. Open browser:

```
http://localhost:4200
```

---

## 🗄️ Database Setup

Run in MySQL:

```sql
CREATE DATABASE banking_portal;
```

---

## 🔗 API Endpoints

### 🔐 Auth APIs

#### Register

```
POST /api/auth/register
```

#### Login

```
POST /api/auth/login
```

---

### 💸 Transaction APIs

#### Transfer Money

```
POST /api/transactions/transfer
```

Request:

```json
{
  "fromAccountNumber": "10001",
  "toAccountNumber": "10002",
  "amount": 500
}
```

---

## 🧪 Testing Flow

1. Register a user
2. Login with credentials
3. Insert sample accounts manually in DB
4. Perform transfer
5. Verify balances in database

---

## 📊 Business Rules Implemented

* Account must exist for transfer
* Sufficient balance required
* No self-transfer allowed
* Secure endpoints require authentication

---

## 🔮 Future Enhancements (Barclays-Level)

* Account Summary Module
* Transaction History with Filters
* Beneficiary Management System
* Admin Dashboard
* Account Freeze / Unfreeze
* Service Request Module
* Role-Based Access Control
* Audit Logging
* Unit & Integration Testing
* CI/CD Pipeline

---

## 🔧 Git Workflow Used

```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git push -u origin main
```

### Feature Workflow

```bash
git switch -c feature/new-feature
git add .
git commit -m "Added new feature"
git push origin feature/new-feature
```

---

## 🧠 Key Learnings

* Full-stack integration (Angular + Spring Boot)
* REST API design
* JWT authentication
* Database design
* Debugging real-world issues
* Git workflow & version control

---

## ⭐ Final Note

This project is actively being enhanced to match **enterprise banking standards**, focusing on:

* Clean architecture
* Security
* Scalability
* Maintainability

---
## 🧪 Testing Strategy & Test Cases

This project follows a **developer-level testing approach** covering:

* Backend API Testing
* Business Logic Validation
* Database Verification
* Frontend Testing
* End-to-End Testing

---

## 🔁 Testing Flow

```text
Backend → API Testing → Database → Frontend → End-to-End
```

---

## 🔐 Authentication Module Test Cases

### ✅ Register User

#### Positive Case

* Input: Valid full name, email, password
* Expected: User registered successfully
* DB Check: User record created

#### Negative Cases

* Duplicate email → "User already exists"
* Invalid email format → Validation error
* Empty fields → Validation error

---

### ✅ Login User

#### Positive Case

* Input: Valid email and password
* Expected: JWT token returned

#### Negative Cases

* Wrong password → "Invalid email or password"
* Email not found → Error response
* Empty fields → Validation error

#### Verification

* Token stored in browser localStorage
* Role returned correctly

---

## 💸 Transaction Module Test Cases

### ✅ Fund Transfer

#### Positive Case

* Valid fromAccount, toAccount, amount
* Expected: "Transfer successful"

#### Verification

* Sender balance reduced
* Receiver balance increased
* Transaction record created

---

### ❌ Negative Cases

| Scenario               | Expected Result        |
| ---------------------- | ---------------------- |
| Insufficient balance   | "Insufficient balance" |
| From account not found | "Account not found"    |
| To account not found   | "Account not found"    |
| Negative amount        | Validation error       |
| Zero amount            | Validation error       |
| Same account transfer  | Not allowed            |
| Frozen account         | Transfer blocked       |

---

## 🗄️ Database Verification

After successful transfer:

```sql
SELECT * FROM accounts;
SELECT * FROM transactions;
```

### Expected:

* Balance updated correctly
* Transaction entry created

---

## 🌐 API Testing (Postman)

### Register API

```http
POST /api/auth/register
```

### Login API

```http
POST /api/auth/login
```

### Transfer API

```http
POST /api/transactions/transfer
Authorization: Bearer <token>
```

---

## 💻 Frontend Testing

### Login Page

* Empty form → validation error
* Valid login → redirect to dashboard
* Invalid login → error message

---

### Register Page

* Empty fields → validation error
* Valid input → success response

---

### Transfer Page

* Invalid input → error message
* Valid transfer → success message

---

### Security Testing

* Access dashboard without login → blocked
* Token missing → API request denied
* Token present → API works

---

## 🔄 End-to-End Test Scenarios

### Scenario 1: Successful Flow

1. Register user
2. Login user
3. Perform transfer
4. Verify database

---

### Scenario 2: Invalid Transfer

1. Login
2. Enter high amount
3. Expect failure message

---

### Scenario 3: Unauthorized Access

1. Clear token
2. Try accessing dashboard
3. Redirect to login

---

## 🧠 Testing Coverage Summary

| Layer           | Tested |
| --------------- | ------ |
| Backend APIs    | ✅      |
| Business Logic  | ✅      |
| Database        | ✅      |
| Frontend UI     | ✅      |
| Security        | ✅      |
| End-to-End Flow | ✅      |

---

## 🚀 Future Testing Enhancements

* JUnit & Mockito Unit Tests
* Integration Testing
* Angular Component Testing
* API Automation
* CI/CD Test Pipeline

---

## 💡 Developer Testing Approach

For every feature:

1. Validate correct input → success
2. Validate wrong input → proper error
3. Verify database consistency
4. Ensure security rules are enforced

---

👉 This testing approach ensures the application behaves like a real-world banking system with proper validation, security, and data integrity.