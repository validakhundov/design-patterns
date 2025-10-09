package structural.bridge.antipattern;

public class AccountWithSmsNotificationService {
    Double withdrawMoney(String iban, Double amount) {
        System.out.println("Some processing...");

        sendSmsNotification(iban, "bla bla");

        return amount;
    }


    String getPhoneNumberByIban(String iban) {
        return "mock phone number";
    }

    void sendSmsNotification(String iban, String message) {
        String phoneNumber = getPhoneNumberByIban(iban);
        System.out.println("Sending SMS: " + message + " to number: " + phoneNumber);
    }
}
