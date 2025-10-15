package behavioral.visitor;

public class AuditReportVisitor implements BankVisitor {
    @Override
    public void visit(Account account) {
        System.out.println("🧾 Auditing Account: " + account.getAccountNumber() +
                " | Balance: " + account.getBalance());
    }

    @Override
    public void visit(Loan loan) {
        System.out.println("🧾 Auditing Loan: " + loan.getLoanId() +
                " | Amount: " + loan.getAmount());
    }

    @Override
    public void visit(CreditCard creditCard) {
        System.out.println("🧾 Auditing CreditCard: " + creditCard.getCardNumber() +
                " | Limit: " + creditCard.getLimit());
    }
}
