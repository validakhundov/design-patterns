package creational.factory2;

public class LoanFactory {
    public Loan getLoanByType(LoanType loanType) {
        switch (loanType) {
            case EMPLOYEE_LOAN:
                return new EmployeeLoan();
            case LEASING_LOAN:
                return new LeasingLoan();
            default:
                return null;
        }
    }
}
