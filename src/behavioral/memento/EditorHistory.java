package behavioral.memento;

import java.util.Stack;

public
class EditorHistory {
    private final Stack<TextBackup> history = new Stack<>();

    public void saveState(TextBackup m) {
        history.push(m);
    }

    public TextBackup undo() {
        if (history.size() > 1) {
            history.pop();
            return history.peek();
        } else {
            System.out.println("Nothing to undo!");
            return history.isEmpty() ? null : history.peek();
        }
    }
}

