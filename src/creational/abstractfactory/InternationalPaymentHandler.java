package creational.abstractfactory;

public class InternationalPaymentHandler implements PaymentHandler {
    @Override
    public void processPayment(PaymentDto payment) {
        System.out.println("Sending payment to SWIFT");
    }
}
