package behavioral.memento;

public class TextEditor {
    private String text = "";

    public void type(String newText) {
        text += newText;
        System.out.println("Current text: " + text);
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void restore(TextMemento memento) {
        text = memento.getSavedText();
        System.out.println("Undo performed → current text: " + text);
    }
}

