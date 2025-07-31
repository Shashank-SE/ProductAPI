# 🛒 Product Management REST API – Spring Boot Project

This is a simple **CRUD API project** built using **Java + Spring Boot**.  
It was created as part of an **interview task** to manage a Product table with the following specifications.

---

## 📋 Task Requirements

- Create a Product table with:
  - `productId` (Primary Key) → Must start with capital **P** (e.g., P001, P002...)
  - `pname` (Product Name)
  - `price` (Product Price)
- Implement complete **CRUD (Create, Read, Update, Delete)** operations.
- **Read** operation should fetch data based on **product name**.
- If the product is already inserted (duplicate ID), it should **throw an error**.
- Every operation must return a **success or error message** in response.

---

## ✅ API Endpoints

| Method | Endpoint                | Description                      |
|--------|-------------------------|----------------------------------|
| POST   | `/products`             | Create a new product             |
| GET    | `/products`             | Get all products                 |
| GET    | `/products/name/{name}` | Get product(s) by product name   |
| PUT    | `/products/{id}`        | Update product by product ID     |
| DELETE | `/products/{id}`        | Delete product by product ID     |

---
