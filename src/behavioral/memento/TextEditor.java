package behavioral.memento;

import java.time.LocalDateTime;

public class TextEditor {
    private String text = "";
    private LocalDateTime dateTime;

    public void type(String newText) {
        text += newText;
        dateTime = LocalDateTime.now();
        System.out.println("Current text: " + text + " and date time: " + dateTime);
    }

    public TextBackup save() {
        return new TextBackup(text, dateTime);
    }

    public void restore(TextBackup backup) {
        text = backup.getSavedText();
        System.out.println("Undo performed → current text: " + text + " and it's date time: " + backup.getSavedTextDateTime());
    }
}

