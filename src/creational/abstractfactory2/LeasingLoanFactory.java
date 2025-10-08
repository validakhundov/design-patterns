package creational.abstractfactory2;

public class LeasingLoanFactory implements AbstractLoanFactory {

    @Override
    public Loan getLoan() {
        return new LeasingLoan();
    }
}
