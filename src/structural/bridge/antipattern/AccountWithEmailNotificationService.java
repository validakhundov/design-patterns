package structural.bridge.antipattern;

public class AccountWithEmailNotificationService {
    Double withdrawMoney(String iban, Double amount) {
        System.out.println("Some processing...");

        sendEmailNotification(iban, "bla bla");

        return amount;
    }


    String getEmailByIban(String iban) {
        return "mock email";
    }

    void sendEmailNotification(String iban, String message) {
        String phoneNumber = getEmailByIban(iban);
        System.out.println("Sending EMAIL: " + message + " to number: " + phoneNumber);
    }
}
