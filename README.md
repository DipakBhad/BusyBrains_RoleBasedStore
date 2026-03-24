## 🛒 Full Stack E-Commerce App (React + Spring Boot)

A simple full-stack web application built using React (Frontend) and Java Spring Boot (Backend).
The app allows users to register, login, view products, and manage them based on roles (Admin/User).

## 🚀 Features
## 🔐 Authentication
User Registration & Login
JWT (JSON Web Token) based authentication
Secure API access using Authorization headers
## 👥 Role-Based Access Control (RBAC)
Admin
Add products
Update products
Delete products
User
View products only
🛍️ Dashboard
Displays list of products (like Amazon/Flipkart)
Real-time updates after adding/deleting products
👤 User Profile
View user details
Role-based UI rendering
Logout functionality
🔐 Security
JWT authentication with Spring Security
Role-based API protection
Secure endpoints for product operations
## 🏗️ Tech Stack
Frontend
React
JavaScript
Fetch API
Backend
Java
Spring Boot
Spring Security
JWT (jjwt library)
JPA / Hibernate
MySQL (or any relational DB)
## 📂 Project Structure
Backend
backend/
 ├── controller/
 ├── entity/
 ├── repository/
 ├── config/
 ├── service/
 └── security/
Frontend
frontend/
 ├── src/
 │   ├── App.js
 │   ├── Login.js
 │   ├── Dashboard.js
 │   ├── Profile.js
 │   └── api.js
⚙️ Setup Instructions
## 🔧 Backend Setup
Open backend project in IntelliJ / Eclipse
Configure database in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Run the Spring Boot application
mvn spring-boot:run
## 🌐 Frontend Setup
Go to frontend folder
cd frontend
npm install
npm start
Open in browser:
http://localhost:3000
## 🔑 Default Users
Username	Password	Role
admin	admin123	ADMIN
user	user123	USER
## 🔐 API Authentication
Login returns JWT token
Token must be sent in headers:
Authorization: Bearer <token>
## 📌 API Endpoints
Auth
POST /auth/register
POST /auth/login
Products
GET /products
POST /products (ADMIN only)
DELETE /products/{id} (ADMIN only)
🎯 Key Concepts Implemented
JWT Authentication
Spring Security
Role-Based Access Control (RBAC)

##ScrrenShots
<img width="1919" height="1152" alt="Screenshot 2026-03-25 010827" src="https://github.com/user-attachments/assets/4e986771-e2bc-4fcf-9f5f-c6a280b36e83" />

<img width="1919" height="1154" alt="Screenshot 2026-03-25 010904" src="https://github.com/user-attachments/assets/c6c0a71e-b220-4c6e-8bd7-f4200ad3269a" />

## Author

## Dipak Bhad


RESTful APIs
Protected Routes
Full Stack Integration
