package creational.abstractfactory;

public class InternationalPaymentHandlerFactory implements PaymentHandlerAbstractFactory {
    @Override
    public PaymentHandler getPaymentHandler() {
        return new InternationalPaymentHandler();
    }
}
