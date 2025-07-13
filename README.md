# 🍔 Food Ordering System (Console Based Java Project)

A simple **console-based food ordering system** developed in Java using **Core Java**, **OOP concepts**, and optionally **JDBC** for data persistence.

---

## 📌 Features

- 📋 View Menu (Food Items)
- 🛒 Place Order
- 💵 Calculate Bill with Total
- 🧾 View Order Summary
- 🗑 Cancel Order
- 🧑‍💻 Admin (Add/Remove Food Items) *(optional)*

---

## 🧱 Technologies Used

- 💻 Java (Core Java)
- 🧠 Object-Oriented Programming
- 🗃️ (Optional) JDBC with PostgreSQL / MySQL
- 🖥️ Console-based UI

---

## 🗂️ Project Structure
```bash
FoodOrderingSystem/
├── src/
│   ├── Main.java                  # Entry point
│   ├── model/
│   │   ├── FoodItem.java          # POJO for food items
│   │   └── Order.java             # Class for current order details
│   ├── service/
│   │   └── OrderService.java      # Logic for placing/canceling/viewing orders
│   └── util/
│       └── MenuUtil.java          # Static menu setup
├── README.md
```



---


---

## ▶️ How to Run

```bash
javac -d bin src/**/*.java
java -cp bin Main
```

## Tables:
```bash
CREATE TABLE food_items (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);
```
**🔸 Sample Data Insert:**  
```bash
INSERT INTO food_items (name, price) VALUES 
('Burger', 99.00),
('Pizza', 199.00),
('Fries', 49.00),
('Cold Drink', 30.00),
('Sandwich', 79.00);
```

## 🧪 Sample Output
=== Welcome to Food Ordering System ===

1. View Menu
2. Place Order
3. View Bill
4. Cancel Order
0. Exit

Enter your choice: 1

--- MENU ---
1. Burger - ₹99.0
2. Pizza - ₹199.0
3. Fries - ₹49.0


## **👩‍💻 Author**
Pranita Pandurang Khendkar  
📧 khendkarpranita@gmail.com  
🌐 GitHub: PanitaK19  

