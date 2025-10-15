package behavioral.template;

public class QrPaymentProcessor extends PaymentProcessor {
    @Override
    protected void debit(double amount) {
        System.out.println("📱 Processing QR payment of " + amount + " AZN");
    }

    @Override
    protected void validate() {
        System.out.println("🔑 Validating QR token and session...");
    }
}
