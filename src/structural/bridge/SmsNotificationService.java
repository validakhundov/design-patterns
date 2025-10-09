package structural.bridge;

public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String receiver, String message) {
        System.out.println("SMS: " + message + " sent to: " + receiver);
    }
}
