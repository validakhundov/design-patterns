package behavioral.command;

public class DepositCommand implements Command {
    private final BankAccount account;
    private final double amount;

    public DepositCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
    }

    @Override
    public void reverse() {
        account.withdraw(amount);
    }
}
