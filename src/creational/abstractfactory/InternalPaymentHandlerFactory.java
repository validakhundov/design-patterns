package creational.abstractfactory;

public class InternalPaymentHandlerFactory implements PaymentHandlerAbstractFactory {
    @Override
    public PaymentHandler getPaymentHandler() {
        return new InternalPaymentHandler();
    }
}
