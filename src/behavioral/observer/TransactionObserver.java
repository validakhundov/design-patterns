package behavioral.observer;

public interface TransactionObserver {
    void update(String accountId, double amount, String message);
}
