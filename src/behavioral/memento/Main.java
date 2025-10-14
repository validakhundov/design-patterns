package behavioral.memento;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        editor.type("Salam");
        history.saveState(editor.save());

        Thread.sleep(1000);

        editor.type(", necesen?");
        history.saveState(editor.save());

        Thread.sleep(2000);

        editor.type(" Bu gun ofise geleceksen?");
        history.saveState(editor.save());

        Thread.sleep(1000);

        System.out.println("---");

        // Undo twice (Ctrl + Z × 2)
        editor.restore(history.undo());
//        editor.restore(history.undo());
    }
}
