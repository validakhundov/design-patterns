package creational.abstractfactory;

public class AbstractFactoryTest {

    PaymentHandlerAbstractFactory paymentHandler;


    public AbstractFactoryTest(PaymentHandlerAbstractFactory paymentHandler) {
        this.paymentHandler = paymentHandler;
    }

    public static void main(String[] args) {
        AbstractFactoryTest abstractFactoryTest = new AbstractFactoryTest(new InternalPaymentHandlerFactory());
        PaymentHandler internal = abstractFactoryTest.paymentHandler.getPaymentHandler();
        internal.processPayment(new PaymentDto());
    }
}
