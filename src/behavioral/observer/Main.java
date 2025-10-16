package behavioral.observer;

public class Main {
    public static void main(String[] args) {
        TransactionMonitoringService monitoringService = new TransactionMonitoringService();

        monitoringService.addObserver(new FraudDepartment());
        monitoringService.addObserver(new RiskSystem());
        monitoringService.addObserver(new CustomerNotification());

        TransactionService transactionService=new TransactionService(monitoringService);

        transactionService.processTransaction("ACC1001", 5000);   // normal
        //transactionService.processTransaction("ACC1001", 25000);  // suspicious
    }
}
