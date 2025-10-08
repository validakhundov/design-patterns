package creational.abstractfactory;

public class InternalPaymentHandler implements PaymentHandler{
    @Override
    public void processPayment(PaymentDto payment) {
        System.out.println("Sending payment to CBAR");
    }
}
