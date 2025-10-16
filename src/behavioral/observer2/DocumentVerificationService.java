package behavioral.observer2;

public class DocumentVerificationService implements LoanObserver {
    @Override
    public void onStatusChanged(LoanApplication loan) {
        if ("UNDER_REVIEW".equals(loan.getStatus())) {
            System.out.println("📄 DocumentVerificationService: Verifying documents for loan " + loan.getId());
        }else{
            System.out.println("Loan status is: " + loan.getStatus()+" - just ignoring message");
        }
    }
}
