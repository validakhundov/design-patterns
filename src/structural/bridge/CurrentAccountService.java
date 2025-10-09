package structural.bridge;

public class CurrentAccountService implements AccountService {

    @Override
    public void withdrawMoney(Double amount) {
        System.out.println("success");

        NotificationService smsNotification = new SmsNotificationService();
        NotificationService emailNotification = new EmailNotificationService();

        CustomerService customerService = new SmeCustomerService();

        smsNotification.send(customerService.getPhoneNumberByIban("abc"), "bla bla");
        //emailNotification.send(customerService.getEmailByIban("abc"), "bla bla");


    }
}
