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



---

## ▶️ How to Run

### 🖥️ Compile & Run from Terminal

```bash
javac *.java
java Main```


🧪 Sample Output
text
Copy
Edit
=== Welcome to Food Express ===
1. View Menu
2. Place Order
3. View Bill
4. Cancel Order
0. Exit

Enter your choice: 1

-- Menu --
1. Burger - ₹99
2. Pizza - ₹199
3. Fries - ₹49


👩‍💻 Author
Pranita Pandurang Khendkar
📧 khendkarpranita@gmail.com
🌐 GitHub: PanitaK19

