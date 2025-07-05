package models;

import interfaces.IShippable;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subtotal = 0;
        double shippingFee = 0;
        List<IShippable> itemsToShip = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if (product.isExpired()) {
                throw new IllegalStateException(product.getName() + " is expired.");
            }

            if (quantity > product.getQuantity()) {
                throw new IllegalStateException("Not enough quantity for product: " + product.getName());
            }

            subtotal += product.getPrice() * quantity;
            product.reduceQuantity(quantity);

            if (product instanceof IShippable) {
                for (int i = 0; i < quantity; i++) {
                    itemsToShip.add((IShippable) product);
                    shippingFee += ((IShippable) product).getWeight()/1000 * 10; // 10 EGP per kg
                }
            }
        }

        double total = subtotal + shippingFee;

        if (!customer.canAfford(total)) {
            System.out.println("Balance: " + customer.getBalance());
            System.out.println("Total required: " + total);
            System.out.println("Can afford? " + customer.canAfford(total));

            throw new IllegalStateException("Insufficient balance.");
        }

        customer.CalcBalance(total);

        if (!itemsToShip.isEmpty()) {
            ShippingService.send(itemsToShip);
        }

        // Receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "\t" +
                    (item.getProduct().getPrice() * item.getQuantity()));
        }

        System.out.println("----------------------");
        System.out.println("Subtotal\t" + subtotal);
        System.out.println("Shipping\t" + shippingFee);
        System.out.println("Amount\t\t" + total);
        System.out.println("Balance\t\t" + customer.getBalance());
    }
}
