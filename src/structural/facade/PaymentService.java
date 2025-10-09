package structural.facade;

public class PaymentService {
    private void validatePayment() {
        System.out.println("Payment is valid");
    }


    public void processPayment() {
        AtlasApiClient atlasApiClient = new AtlasApiClient();
        NotificationService notificationService = new NotificationService();

        validatePayment();
        atlasApiClient.sentPaymentToZeus();
        notificationService.sendEmailNotification();
        notificationService.sendSmsNotification();
        notificationService.sendPopUpNotification();
    }
}
