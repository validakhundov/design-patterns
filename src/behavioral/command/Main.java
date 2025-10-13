package behavioral.command;

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("001AZN", 1000);

        TransactionExecuter invoker = new TransactionExecuter();

        invoker.executeCommand(new DepositCommand(acc1, 500));
        invoker.executeCommand(new WithdrawCommand(acc1, 300));

        invoker.reverseLast();
    }
}
