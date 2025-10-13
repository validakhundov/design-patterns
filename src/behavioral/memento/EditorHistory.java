package behavioral.memento;

import java.util.Stack;

public
class EditorHistory {
    private final Stack<TextMemento> history = new Stack<>();

    public void saveState(TextMemento m) {
        history.push(m);
    }

    public TextMemento undo() {
        if (history.size() > 1) {
            history.pop();
            return history.peek();
        } else {
            System.out.println("Nothing to undo!");
            return history.isEmpty() ? null : history.peek();
        }
    }
}

