package structural.bridge;

public interface CustomerService {
    String getEmailByIban(String iban);

    String getPhoneNumberByIban(String iban);
}
