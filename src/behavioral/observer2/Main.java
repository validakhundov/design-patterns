package behavioral.observer2;

public class Main {
    public static void main(String[] args) {
        LoanApplication loan = new LoanApplication("LN-2025-001", 80_000);
        LoanService loanService = new LoanService();

        loanService.addObserver(new CreditScoringService());
        loanService.addObserver(new DocumentVerificationService());
        loanService.addObserver(new RiskAnalysisService());

        loanService.updateLoanStatus(loan,"UNDER_REVIEW");
        loanService.updateLoanStatus(loan,"APPROVED");
    }
}
