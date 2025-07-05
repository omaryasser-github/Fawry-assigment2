package models;
import java.time.LocalDate;
public class Product {
        private int id;
        private String name;
        private double price;
        private int quantity;
        private LocalDate expireDate; // null if not expirable

        public Product(int id, String name, double price, int quantity, LocalDate expireDate) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.expireDate = expireDate;
        }

        public boolean isExpirable() {
            return expireDate != null;
        }

        public boolean isExpired() {
            return isExpirable() && LocalDate.now().isAfter(expireDate);
        }

        // Getters and setters
        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public int getQuantity() { return quantity; }
        public void reduceQuantity(int amount) { this.quantity -= amount; }
        public LocalDate getExpireDate() { return expireDate; }


}
