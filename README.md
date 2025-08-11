# 🛠️ Maintenance Request System

A Spring Boot + MySQL based backend system to manage complaints/maintenance requests for a apartment environment.  
It allows **residents** to raise complaints and **authorities** to view, filter, and resolve them.

---

## 🚀 Current Features
- Raise complaints with title, description, priority, time, date, with pending status.
- Update complaint title and description.
- View complaints with multiple filters.
- Automatic `createdAt` and `updatedAt` timestamps.
- Delete complaints with id.
- Role-based complaint management (Residents / Authority).

---

## 🏗️ Tech Stack
- **Backend:** Java 17, Spring Boot 3.x
- **Database:** MySQL 8+
- **ORM:** Spring Data JPA (Hibernate)
- **Build Tool:** Maven

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Ratnadeep01/maintenance-request-system.git
cd maintenance-request-system
```
### 2️⃣ Configure application.properties
Edit src/main/resources/application.properties and set your database & server details as given in that file...

### 3️⃣ Create Database in MySQL
```
CREATE DATABASE maintenance_request_system;
```

### 4️⃣ Build and Run
```bash
mvn clean install
mvn spring-boot:run
```

### 5️⃣ API Testing
You can test APIs using Postman or any REST client.
Example base URL:
```
http://localhost:8080/api/complaints/post ----> To raise the complaint.
```
There are total 5 apis. Check ComplaintController.java for all the apis.

### FUTURE UDATES:
1. Seperate login and authentication for residents and authorities
2. manage requests and resolve by authorities.
