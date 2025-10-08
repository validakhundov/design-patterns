package creational.abstractfactory2;

public class FactoryTest {

    AbstractLoanFactory loanFactory;

    public FactoryTest(AbstractLoanFactory loanFactory) {
        this.loanFactory = loanFactory;
    }


    public static void main(String[] args) {


        FactoryTest test = new FactoryTest(new EmployeeLoanFactory());

        Loan employeeLoan = test.loanFactory.getLoan();
        System.out.println(employeeLoan.getDescription());


        FactoryTest test2 = new FactoryTest(new LeasingLoanFactory());
        Loan  leasingLoan = test2.loanFactory.getLoan();
        System.out.println(leasingLoan.getDescription());

    }
}
