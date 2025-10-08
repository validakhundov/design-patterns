package creational.factory2;

public class FactoryTest {
    public static void main(String[] args) {
        LoanFactory loanFactory = new LoanFactory();


        Loan employeeLoan = loanFactory.getLoanByType(LoanType.EMPLOYEE_LOAN);
        System.out.println(employeeLoan.getDescription());

        Loan leasingLoan = loanFactory.getLoanByType(LoanType.LEASING_LOAN);
        System.out.println(leasingLoan.getDescription());
    }
}
