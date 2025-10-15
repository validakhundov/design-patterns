package behavioral.observer;

public class RiskSystem implements TransactionObserver {
    @Override
    public void update(String accountId, double amount, String message) {
        System.out.println("📊 Risk System logging: " + message + " for " + accountId);
    }
}
