package order;
import java.sql.*;
import java.util.*;

public class Main{

    static final String URL = "jdbc:postgresql://localhost:5432/mydb";
    static final String USER = "postgres";
    static final String PASSWORD = "bappa@19"; // 🔁 Change this

    static class FoodItem {
        int id;
        String name;
        double price;

        FoodItem(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    static class OrderItem {
        FoodItem item;
        int quantity;

        OrderItem(FoodItem item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        double getTotal() {
            return item.price * quantity;
        }
    }

    static List<OrderItem> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== FOOD ORDERING SYSTEM ===");
            System.out.println("1. Show Menu");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout & Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: showMenu(); break;
                case 2: addToCart(); break;
                case 3: viewCart(); break;
                case 4: checkout(); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void showMenu() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food_menu");

            System.out.println("\n--- MENU ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name") + " - ₹" + rs.getDouble("price"));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching menu: " + e.getMessage());
        }
    }

    static void addToCart() {
        System.out.print("Enter Food ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM food_menu WHERE id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                FoodItem item = new FoodItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
                cart.add(new OrderItem(item, qty));
                System.out.println(qty + " x " + item.name + " added to cart.");
            } else {
                System.out.println("Invalid Food ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error adding to cart: " + e.getMessage());
        }
    }

    static void viewCart() {
        System.out.println("\n--- YOUR CART ---");
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            double total = 0;
            for (OrderItem order : cart) {
                double subtotal = order.getTotal();
                System.out.println(order.item.name + " x " + order.quantity + " = ₹" + subtotal);
                total += subtotal;
            }
            System.out.println("Total: ₹" + total);
        }
    }

    static void checkout() {
        System.out.println("\n--- FINAL BILL ---");
        double total = 0;
        for (OrderItem order : cart) {
            double subtotal = order.getTotal();
            System.out.println(order.item.name + " x " + order.quantity + " = ₹" + subtotal);
            total += subtotal;
        }
        System.out.println("Grand Total: ₹" + total);
        System.out.println("Thank you! Visit again.");
    }
}