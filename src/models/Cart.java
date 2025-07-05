package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Requested quantity exceeds available stock.");
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return cartItems;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
