package models;

import interfaces.ICustomer;

public class Customer implements ICustomer {
    private String name;
    private int id;
    private double balance;

    public Customer(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double CalcBalance(double paidAmount) {
        this.balance -= paidAmount;
        return this.balance;
    }

    @Override
    public boolean canAfford(double amount) {
        return balance >= amount;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
