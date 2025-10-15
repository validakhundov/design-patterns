package behavioral.visitor;

public class CreditCard implements BaseEntity {
    private String cardNumber;
    private double limit;

    public CreditCard(String cardNumber, double limit) {
        this.cardNumber = cardNumber;
        this.limit = limit;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getLimit() {
        return limit;
    }

    @Override
    public void accept(BankVisitor visitor) {
        visitor.visit(this);
    }
}
