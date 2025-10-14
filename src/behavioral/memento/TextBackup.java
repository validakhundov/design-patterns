package behavioral.memento;

import java.time.LocalDateTime;

public class TextBackup {
    private final String text;
    private final LocalDateTime dateTime;

    public TextBackup(String text, LocalDateTime dateTime) {
        this.text = text;
        this.dateTime = dateTime;
    }

    public String getSavedText() {
        return text;
    }

    public LocalDateTime getSavedTextDateTime() {
        return dateTime;
    }
}

