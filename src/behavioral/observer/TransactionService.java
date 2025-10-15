package behavioral.observer;

public class TransactionService {
    private final TransactionMonitoringService transactionMonitoringService;

    public TransactionService(TransactionMonitoringService transactionMonitoringService) {
        this.transactionMonitoringService = transactionMonitoringService;
    }

    public void processTransaction(String accountId, double amount) {
        System.out.println("Processing transaction for " + accountId + ": " + amount + " AZN");

        if (amount > 10_000) { // suspicious threshold
            transactionMonitoringService.notifyObservers(accountId, amount, "⚠️ Suspicious high-value transaction detected!");
        } else {
            transactionMonitoringService.notifyObservers(accountId, amount, "✅ Normal transaction processed.");
        }
    }
}
