package behavioral.template;

public class CardPaymentProcessor extends PaymentProcessor {
    @Override
    protected void debit(double amount) {
        System.out.println("💳 Debiting card for " + amount + " AZN");
    }

}
