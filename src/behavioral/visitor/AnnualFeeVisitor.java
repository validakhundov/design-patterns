package behavioral.visitor;

public class AnnualFeeVisitor implements BankVisitor {
    @Override
    public void visit(Account account) {
        System.out.println("💰 Account annual fee: " + Math.min(account.getBalance() * 0.01, 50));
    }

    @Override
    public void visit(Loan loan) {
        System.out.println("💰 Loan maintenance fee: " + loan.getAmount() * 0.005);
    }

    @Override
    public void visit(CreditCard creditCard) {
        System.out.println("💳 CreditCard fee: " + Math.min(creditCard.getLimit() * 0.02, 100));
    }
}
