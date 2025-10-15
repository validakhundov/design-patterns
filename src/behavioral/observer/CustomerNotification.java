package behavioral.observer;

public class CustomerNotification implements TransactionObserver {
    @Override
    public void update(String accountId, double amount, String message) {
        System.out.println("📱 Notifying customer " + accountId + ": " + message);
    }
}
