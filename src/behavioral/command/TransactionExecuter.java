package behavioral.command;

import java.util.Stack;

public class TransactionExecuter {
    private final Stack<Command> history = new Stack<>();

    public void executeCommand(Command cmd) {
        cmd.execute();
        history.push(cmd);
    }

    public void reverseLast() {
        if (!history.isEmpty()) {
            Command cmd = history.pop();
            cmd.reverse();
            System.out.println("- Reverse executed!");
        }
    }
}
