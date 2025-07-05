package interfaces;

public interface ICustomer {
    String getName();
    int getID();
    double getBalance();

    double CalcBalance(double paidAmount);
    boolean canAfford(double amount);

    void setName(String name);
    void setID(int id);
    void setBalance(double balance);
}
