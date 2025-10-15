package behavioral.visitor;

public interface BankVisitor {
    void visit(Account account);

    void visit(Loan loan);

    void visit(CreditCard creditCard);
}
