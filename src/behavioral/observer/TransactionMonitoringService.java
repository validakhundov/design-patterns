package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class TransactionMonitoringService {
    private final List<TransactionObserver> observers = new ArrayList<>();

    public void addObserver(TransactionObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TransactionObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String accountId, double amount, String message) {
        for (TransactionObserver observer : observers) {
            observer.update(accountId, amount, message);
        }
    }
}

