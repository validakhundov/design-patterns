package behavioral.command;

public class WithdrawCommand implements Command {
    private final BankAccount account;
    private final double amount;

    public WithdrawCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdraw(amount);
    }

    @Override
    public void reverse() {
        account.deposit(amount);
    }
}
