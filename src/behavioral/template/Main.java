package behavioral.template;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor card = new CardPaymentProcessor();
        PaymentProcessor qr = new QrPaymentProcessor();

        card.processPayment(120.5);
        qr.processPayment(15.75);
    }
}
