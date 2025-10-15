package behavioral.observer2;

import java.util.ArrayList;
import java.util.List;

public class LoanService {
    private final List<LoanObserver> observers = new ArrayList<>();

    public void addObserver(LoanObserver obs) {
        observers.add(obs);
    }

    private void notifyObservers(LoanApplication application) {
        for (LoanObserver o : observers) {
            o.onStatusChanged(application);
        }
    }

    public void updateLoanStatus(LoanApplication application, String newStatus) {
        System.out.println("\n📢 Loan " + application.getId() + " status changed → " + newStatus);
        application.setStatus(newStatus);
        notifyObservers(application);
    }
}
