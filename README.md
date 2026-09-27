<div align="center">

# 🚀 Dev Microservices

### Spring Boot Microservices Project

<p>
  <img src="https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen?style=for-the-badge&logo=springboot&logoColor=white" />
  <img src="https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
  <img src="https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white" />
  <img src="https://img.shields.io/badge/REST-API-02569B?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Git-GitHub-181717?style=for-the-badge&logo=github&logoColor=white" />
</p>

<p>
  <b>👤 User Management</b>
  &nbsp;•&nbsp;
  <b>📦 Order Management</b>
  &nbsp;•&nbsp;
  <b>🔗 REST Communication</b>
  &nbsp;•&nbsp;
  <b>🌱 Spring Boot</b>
</p>

<br>

<a href="https://github.com/swamy-sidda/dev.microservices">
  <img src="https://img.shields.io/badge/View%20Repository-GitHub-181717?style=for-the-badge&logo=github" />
</a>

</div>

---

## 📌 About The Project

**Dev Microservices** is a Spring Boot based microservices project created to understand and demonstrate the fundamentals of building and connecting independent backend services.

The project currently contains two independent Spring Boot services:

<table>
<tr>

<td width="50%" align="center">

## 👤 User Service

### `UserCre`

Handles user creation and user retrieval operations.

</td>

<td width="50%" align="center">

## 📦 Order Service

### `orderCre`

Handles order operations and communicates with the User Service.

</td>

</tr>
</table>

---

## 🏗️ Architecture

<div align="center">

```text
                         ┌─────────────────────┐
                         │       CLIENT        │
                         │                     │
                         │      Postman        │
                         └──────────┬──────────┘
                                    │
                              HTTP / REST
                                    │
                                    ▼
                    ┌───────────────────────────┐
                    │       ORDER SERVICE       │
                    │          orderCre         │
                    │                           │
                    │   OrderController         │
                    │   OrderService            │
                    │   OrderRepository         │
                    │   UserClient              │
                    └─────────────┬─────────────┘
                                  │
                              REST Call
                                  │
                                  ▼
                    ┌───────────────────────────┐
                    │        USER SERVICE       │
                    │           UserCre         │
                    │                           │
                    │   UserController          │
                    │   UserService              │
                    │   UserRepository           │
                    │   SecurityConfig           │
                    └─────────────┬─────────────┘
                                  │
                                  ▼
                           ┌─────────────┐
                           │    MySQL    │
                           │   Database  │
                           └─────────────┘
```

</div>

---

## 🔄 How The Services Communicate

The two services are independently running Spring Boot applications.

The **Order Service** contains a `UserClient` that communicates with the **User Service** through HTTP REST APIs.

```text
┌──────────────────────┐
│    Order Service     │
│       orderCre       │
│                      │
│  OrderController     │
│         ↓            │
│  OrderService        │
│         ↓            │
│  UserClient          │
└──────────┬───────────┘
           │
           │ HTTP REST Request
           ▼
┌──────────────────────┐
│     User Service     │
│        UserCre       │
│                      │
│  UserController      │
│         ↓            │
│  UserService         │
│         ↓            │
│  UserRepository      │
└──────────┬───────────┘
           │
           ▼
      ┌──────────┐
      │  MySQL   │
      └──────────┘
```

### Communication Flow

```text
Client
  ↓
Order Service
  ↓
UserClient
  ↓
HTTP REST Call
  ↓
User Service
  ↓
User Service Layer
  ↓
User Repository
  ↓
MySQL
```

---

## 📂 Project Structure

```text
dev.microservices/
│
├── UserCre/
│   │
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── UserCre/
│   │   │   │       │
│   │   │   │       ├── config/
│   │   │   │       │   └── SecurityConfig.java
│   │   │   │       │
│   │   │   │       ├── controller/
│   │   │   │       │   └── UserController.java
│   │   │   │       │
│   │   │   │       ├── dto/
│   │   │   │       │   ├── UserRequestDto.java
│   │   │   │       │   └── UserResponseDto.java
│   │   │   │       │
│   │   │   │       ├── entity/
│   │   │   │       │   └── User.java
│   │   │   │       │
│   │   │   │       ├── repository/
│   │   │   │       │   └── UserRepository.java
│   │   │   │       │
│   │   │   │       ├── service/
│   │   │   │       │   ├── UserService.java
│   │   │   │       │   └── UserServiceImpl.java
│   │   │   │       │
│   │   │   │       └── UserCreApplication.java
│   │   │   │
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   │
│   │   └── test/
│   │
│   ├── pom.xml
│   ├── mvnw
│   └── mvnw.cmd
│
│
├── orderCre/
│   │
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── orderCre/
│   │   │   │       │
│   │   │   │       ├── client/
│   │   │   │       │   └── UserClient.java
│   │   │   │       │
│   │   │   │       ├── config/
│   │   │   │       │   └── RestTemplateConfig.java
│   │   │   │       │
│   │   │   │       ├── controller/
│   │   │   │       │   └── OrderController.java
│   │   │   │       │
│   │   │   │       ├── dto/
│   │   │   │       │   ├── OrderRequestDto.java
│   │   │   │       │   └── OrderResponseDto.java
│   │   │   │       │
│   │   │   │       ├── entity/
│   │   │   │       │   └── Order.java
│   │   │   │       │
│   │   │   │       ├── repository/
│   │   │   │       │   └── OrderRepository.java
│   │   │   │       │
│   │   │   │       ├── service/
│   │   │   │       │   ├── OrderService.java
│   │   │   │       │   └── OrderServiceImpl.java
│   │   │   │       │
│   │   │   │       └── OrderCreApplication.java
│   │   │   │
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   │
│   │   └── test/
│   │
│   ├── pom.xml
│   ├── mvnw
│   └── mvnw.cmd
│
│
├── .gitignore
└── README.md
```

---

# 👤 User Service

## `UserCre`

The User Service is responsible for managing user information.

### Main Components

<table>
<thead>
<tr>
<th>Component</th>
<th>Responsibility</th>
</tr>
</thead>

<tbody>

<tr>
<td><code>UserController</code></td>
<td>Handles user REST API requests</td>
</tr>

<tr>
<td><code>UserService</code></td>
<td>Defines user business operations</td>
</tr>

<tr>
<td><code>UserServiceImpl</code></td>
<td>Implements user business logic</td>
</tr>

<tr>
<td><code>UserRepository</code></td>
<td>Handles database operations</td>
</tr>

<tr>
<td><code>User</code></td>
<td>User entity</td>
</tr>

<tr>
<td><code>UserRequestDto</code></td>
<td>Request data for creating users</td>
</tr>

<tr>
<td><code>UserResponseDto</code></td>
<td>User response data</td>
</tr>

<tr>
<td><code>SecurityConfig</code></td>
<td>Spring Security configuration</td>
</tr>

</tbody>
</table>

---

# 📦 Order Service

## `orderCre`

The Order Service is responsible for managing orders and communicating with the User Service.

### Main Components

<table>
<thead>
<tr>
<th>Component</th>
<th>Responsibility</th>
</tr>
</thead>

<tbody>

<tr>
<td><code>OrderController</code></td>
<td>Handles order REST API requests</td>
</tr>

<tr>
<td><code>OrderService</code></td>
<td>Defines order operations</td>
</tr>

<tr>
<td><code>OrderServiceImpl</code></td>
<td>Implements order business logic</td>
</tr>

<tr>
<td><code>OrderRepository</code></td>
<td>Handles order database operations</td>
</tr>

<tr>
<td><code>Order</code></td>
<td>Order entity</td>
</tr>

<tr>
<td><code>UserClient</code></td>
<td>Communicates with the User Service</td>
</tr>

<tr>
<td><code>RestTemplateConfig</code></td>
<td>Configures REST communication</td>
</tr>

</tbody>
</table>

---

# 🧪 API Documentation

## 👤 User Service — `UserCre`

Base URL:

```text
http://localhost:8080/users
```

> The port can be changed through `application.properties`.

<table>
<thead>
<tr>
<th>Method</th>
<th>Endpoint</th>
<th>Description</th>
</tr>
</thead>

<tbody>

<tr>
<td><b>POST</b></td>
<td><code>/users</code></td>
<td>Create a new user</td>
</tr>

<tr>
<td><b>GET</b></td>
<td><code>/users/{id}</code></td>
<td>Get a user by ID</td>
</tr>

<tr>
<td><b>GET</b></td>
<td><code>/users</code></td>
<td>Get all users</td>
</tr>

</tbody>
</table>

### ➕ Create User

```http
POST /users
Content-Type: application/json
```

Example request:

```json
{
  "name": "Swamy",
  "email": "swamy@example.com",
  "phoneNumber": "9876543210"
}
```

---

## 📦 Order Service — `orderCre`

Base URL:

```text
http://localhost:8081/orders
```

> The port can be changed through `application.properties`.

<table>
<thead>
<tr>
<th>Method</th>
<th>Endpoint</th>
<th>Description</th>
</tr>
</thead>

<tbody>

<tr>
<td><b>POST</b></td>
<td><code>/orders</code></td>
<td>Create a new order</td>
</tr>

<tr>
<td><b>GET</b></td>
<td><code>/orders/{id}</code></td>
<td>Get an order by ID</td>
</tr>

<tr>
<td><b>GET</b></td>
<td><code>/orders</code></td>
<td>Get all orders</td>
</tr>

<tr>
<td><b>GET</b></td>
<td><code>/orders/user/{userId}</code></td>
<td>Get orders belonging to a user</td>
</tr>

</tbody>
</table>

### 🔎 Get Orders By User

```http
GET /orders/user/{userId}
```

Example:

```http
GET /orders/user/1
```

---

# 🔗 REST Communication Example

When the Order Service needs information related to a user, it can communicate with the User Service through `UserClient`.

```text
                    Order Service
                         │
                         ▼
                   OrderService
                         │
                         ▼
                     UserClient
                         │
                         │ HTTP
                         ▼
                    User Service
                         │
                         ▼
                   UserController
                         │
                         ▼
                    UserService
                         │
                         ▼
                  UserRepository
                         │
                         ▼
                       MySQL
```

This demonstrates basic **inter-service REST communication** between independent Spring Boot applications.

---

# 🛠️ Technology Stack

<div align="center">

<table>
<tr>
<td align="center">☕<br><b>Java</b></td>
<td align="center">🌱<br><b>Spring Boot</b></td>
<td align="center">🌐<br><b>Spring Web</b></td>
<td align="center">🗄️<br><b>JPA</b></td>
</tr>

<tr>
<td align="center">🐬<br><b>MySQL</b></td>
<td align="center">📦<br><b>Maven</b></td>
<td align="center">🔗<br><b>REST</b></td>
<td align="center">🧪<br><b>Postman</b></td>
</tr>

<tr>
<td align="center">🔐<br><b>Spring Security</b></td>
<td align="center">🔄<br><b>RestTemplate</b></td>
<td align="center">🐙<br><b>Git</b></td>
<td align="center">💻<br><b>GitHub</b></td>
</tr>
</table>

</div>

---

# ⚙️ Getting Started

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/swamy-sidda/dev.microservices.git
```

Move into the project:

```bash
cd dev.microservices
```

---

## 2️⃣ Configure the Database

Create the required MySQL databases and configure the connection details in:

```text
UserCre/src/main/resources/application.properties
```

```text
orderCre/src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

> Do not commit real database passwords or other sensitive credentials to GitHub.

---

## 3️⃣ Start User Service

Open the `UserCre` project and run:

```text
UserCreApplication.java
```

The User Service will start on the configured port.

---

## 4️⃣ Start Order Service

Open the `orderCre` project and run:

```text
OrderCreApplication.java
```

The Order Service will start on its configured port.

---

## 5️⃣ Test Using Postman

Example:

```http
GET http://localhost:8080/users
```

and:

```http
GET http://localhost:8081/orders
```

Use the actual ports configured in your `application.properties` files.

---

# 🧪 Example API Flow

A simple demonstration flow can be:

```text
        1. Create User
               │
               ▼
        POST /users
               │
               ▼
          User Service
               │
               ▼
             MySQL
               │
               │
        2. Create Order
               │
               ▼
        POST /orders
               │
               ▼
         Order Service
               │
               ▼
          UserClient
               │
               ▼
          User Service
```

---

# 🎯 Learning Objectives

This project focuses on understanding:

* ✅ Spring Boot Microservices
* ✅ Independent services
* ✅ REST API development
* ✅ Service-to-service communication
* ✅ Spring Data JPA
* ✅ MySQL integration
* ✅ DTO usage
* ✅ Layered architecture
* ✅ REST client communication
* ✅ API testing with Postman
* ✅ Git and GitHub

---

# 🔮 Future Enhancements

The project can be extended with additional microservice architecture components.

### Planned Architecture

```text
                         ┌─────────────────┐
                         │   API Gateway   │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │ Eureka Server   │
                         └────────┬────────┘
                                  │
                 ┌────────────────┼────────────────┐
                 │                │                │
                 ▼                ▼                ▼
          ┌─────────────┐  ┌─────────────┐  ┌─────────────┐
          │ User        │  │ Order       │  │   Future    │
          │ Service     │  │ Service     │  │  Services   │
          └─────────────┘  └─────────────┘  └─────────────┘
                                  │
                                  ▼
                           ┌─────────────┐
                           │    Kafka    │
                           └─────────────┘
```

Potential additions:

| Feature                | Purpose                          |
| ---------------------- | -------------------------------- |
| 🔎 Eureka Server       | Service discovery                |
| 🚪 API Gateway         | Central entry point              |
| 🔗 OpenFeign           | Simplified service communication |
| 📨 Apache Kafka        | Asynchronous communication       |
| 🛡️ Circuit Breaker    | Fault tolerance                  |
| 🐳 Docker              | Containerization                 |
| 📊 Distributed Tracing | Request tracking                 |
| 📝 Centralized Logging | Service monitoring               |

---

# 📁 Repository Structure

The project uses a **single repository** containing multiple microservices.

```text
dev.microservices
│
├── UserCre
│
├── orderCre
│
├── .gitignore
│
└── README.md
```

This approach keeps the related services together while they are being developed and demonstrated as one microservices project.

---

# 📌 Repository

<div align="center">

<a href="https://github.com/swamy-sidda/dev.microservices">

<img src="https://img.shields.io/badge/GitHub-dev.microservices-181717?style=for-the-badge&logo=github&logoColor=white" />

</a>

<br>
<br>

<b>🌱 Building Microservices with Spring Boot</b>

</div>

---

# 👨‍💻 Author

<div align="center">

## Swamy Siddarapu

### Java • Spring Boot • Microservices • SQL

<br>

<a href="https://github.com/swamy-sidda">
<img src="https://img.shields.io/badge/GitHub-swamy--sidda-181717?style=for-the-badge&logo=github&logoColor=white" />
</a>

</div>

---

<div align="center">

## ⭐ Learn • Build • Test • Improve

</div>
