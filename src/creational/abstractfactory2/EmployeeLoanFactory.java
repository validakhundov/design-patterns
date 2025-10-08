package creational.abstractfactory2;

public class EmployeeLoanFactory implements AbstractLoanFactory {

    @Override
    public Loan getLoan() {
        return new EmployeeLoan();
    }
}
