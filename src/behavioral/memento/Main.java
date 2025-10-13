package behavioral.memento;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        editor.type("Salam");
        history.saveState(editor.save());

        editor.type(", necesen?");
        history.saveState(editor.save());

        editor.type(" Bu gun ofise geleceksen?");
        history.saveState(editor.save());

        System.out.println("---");

        // Undo twice (Ctrl + Z × 2)
        editor.restore(history.undo());
        editor.restore(history.undo());
    }
}
