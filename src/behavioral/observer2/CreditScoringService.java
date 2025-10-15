package behavioral.observer2;

public class CreditScoringService implements LoanObserver {
    @Override
    public void onStatusChanged(LoanApplication loan) {
        if ("UNDER_REVIEW".equals(loan.getStatus())) {
            System.out.println("📊 CreditScoringService: Calculating credit score for loan " + loan.getId());
        }
    }
}