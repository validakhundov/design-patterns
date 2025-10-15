package behavioral.visitor;

public class Loan implements BaseEntity {
    private String loanId;
    private double amount;

    public Loan(String loanId, double amount) {
        this.loanId = loanId;
        this.amount = amount;
    }

    public String getLoanId() {
        return loanId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void accept(BankVisitor visitor) {
        visitor.visit(this);
    }
}
