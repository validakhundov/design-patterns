package behavioral.command;

public class BankAccount {
    private double balance;
    private final String iban;

    public BankAccount(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(iban + ": Deposited " + amount + " AZN, balance = " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(iban + ": Withdrew " + amount + " AZN, balance = " + balance);
        } else {
            System.out.println(iban + ": Insufficient funds!");
        }
    }

    public double getBalance() {
        return balance;
    }
}
