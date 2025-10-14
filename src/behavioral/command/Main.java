package behavioral.command;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("001AZN", 1000);

        TransactionExecuter executer = new TransactionExecuter();

        executer.executeCommand(new DepositCommand(acc1, 500));
        executer.executeCommand(new WithdrawCommand(acc1, 300));

        executer.reverseAll();

    }
}
