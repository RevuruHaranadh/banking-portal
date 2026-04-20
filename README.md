# 🏦 Banking Portal

A full-stack banking application built using **Spring Boot (Backend)** and **Angular (Frontend)**.

---

## 📌 Project Overview

This project simulates a retail banking portal where users can:

- Register new account
- Login securely
- Access dashboard
- Perform fund transfers between accounts

---

## 🛠️ Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Maven

### Frontend
- Angular
- TypeScript
- HTML
- CSS
- Reactive Forms

---

## 📁 Project Structure
banking-portal/
├── backend/
├── frontend/
├── docs/
├── .gitignore
└── README.md

---

## 🚀 Features Implemented

- ✅ User Registration
- ✅ User Login
- ✅ Dashboard UI
- ✅ Fund Transfer
- ✅ Angular Routing
- ✅ Route Guards
- ✅ HTTP Interceptors
- ✅ MySQL Integration

---

## 🔮 Future Enhancements

- Account Summary
- Transaction History
- Beneficiary Management
- Admin Dashboard
- Account Freeze / Unfreeze
- Unit Testing
- CI/CD Integration

---

## ⚙️ How to Run the Project

### Backend Setup

1. Open `backend` in IntelliJ
2. Configure MySQL in:
    backend/src/main/resources/application.properties
3. Run Spring Boot application

---

### Frontend Setup

1. Open `frontend` in VS Code
2. Run:
```bash
npm install
ng serve
3. Open in browser:
    http://localhost:4200

🗄️ Database Setup

Create database in MySQL:
        CREATE DATABASE banking_portal;


🔗 API Endpoints
Auth APIs
POST /api/auth/register
POST /api/auth/login
Transaction APIs
POST /api/transactions/transfer

🧪 Testing Flow
Register user
Login user
Insert sample accounts in DB
Perform transfer
Verify DB updates
👨‍💻 Author

Haranadh

⭐ Notes

This project is being enhanced to enterprise-level standards with:

Better architecture
Security improvements
Unit testing
Real-world banking features
--------
