package behavioral.observer2;

public
class RiskAnalysisService implements LoanObserver {
    @Override
    public void onStatusChanged(LoanApplication loan) {
        if (loan.getAmount() > 50_000 && "UNDER_REVIEW".equals(loan.getStatus())) {
            System.out.println("⚠️ RiskAnalysisService: High-value loan requires deep risk review.");
        }
    }
}