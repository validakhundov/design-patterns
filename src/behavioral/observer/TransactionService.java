package behavioral.observer;

public class TransactionService {
    private final TransactionMonitoringService transactionMonitoringService;

    public TransactionService(TransactionMonitoringService transactionMonitoringService) {
        this.transactionMonitoringService = transactionMonitoringService;
    }

    public void processTransaction(String accountId, double amount) {
        System.out.println("Processing transaction for " + accountId + ": " + amount + " AZN");
        transactionMonitoringService.notifyObservers(accountId, amount, "⚠️ Suspicious high-value transaction detected!");
    }
}
