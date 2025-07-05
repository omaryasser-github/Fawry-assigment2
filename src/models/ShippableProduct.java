package models;

import interfaces.IShippable;

import java.time.LocalDate;

public class ShippableProduct extends Product implements IShippable {
    private double weight;

    public ShippableProduct(int id, String name, double price, int quantity, LocalDate expireDate, double weight) {
        super(id, name, price, quantity, expireDate);
        this.weight = weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
