package behavioral.template;

public abstract class PaymentProcessor {

    public final void processPayment(double amount) {
        validate();
        debit(amount);
        notifyUser(amount);
        System.out.println("✅ Payment completed.\n");
    }

    protected void validate() {
        System.out.println("🔍 Validating payment request...");
    }

    protected abstract void debit(double amount);

    protected void notifyUser(double amount) {
        System.out.println("📩 Sending default payment notification...");
    }
}

