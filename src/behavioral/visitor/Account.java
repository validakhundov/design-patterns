package behavioral.visitor;

public class Account implements BaseEntity {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void accept(BankVisitor visitor) {
        visitor.visit(this);
    }
}
