package behavioral.observer;

public class FraudDepartment implements TransactionObserver {
    @Override
    public void update(String accountId, double amount, String message) {
        System.out.println("🔍 Fraud Dept reviewing " + accountId + " (" + amount + "): " + message);
    }
}
