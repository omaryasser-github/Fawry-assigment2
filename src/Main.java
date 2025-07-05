import models.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. إنشاء العميل
        Customer customer = new Customer(1, "Omar", 2000); // معاه 1000 جنيه

        // 2. المنتجات
        ShippableProduct cheese = new ShippableProduct(1, "Cheese", 100, 5, LocalDate.of(2025, 12, 31), 400); // 400g
        ShippableProduct tv = new ShippableProduct(2, "TV", 200, 3, null, 7000); // 7kg, لا ينتهي صلاحيته
        Product scratchCard = new Product(3, "Scratch Card", 50, 10, null); // مش قابل للشحن

        // 3. الكارت
        Cart cart = new Cart();
        cart.add(cheese, 2);        // 2x Cheese = 200
        cart.add(tv, 3);            // 3x TV = 600
        cart.add(scratchCard, 1);   // 1x Scratch Card = 50



        try {
            CheckoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout Error: " + e.getMessage());
        }
    }
}
