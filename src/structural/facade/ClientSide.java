package structural.facade;

public class ClientSide {


    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.processPayment();
    }
}
