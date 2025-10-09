package structural.bridge;

public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String receiver, String message) {
        System.out.println("EMAIL: " + message + " sent to: " + receiver);
    }
}
