package behavioral.observer2;

public interface LoanObserver {
    void onStatusChanged(LoanApplication loan);
}
