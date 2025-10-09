package structural.bridge;

public class SmeCustomerService implements CustomerService{
    @Override
    public String getEmailByIban(String iban) {
        return "valid@kapitalbank.az";
    }

    @Override
    public String getPhoneNumberByIban(String iban) {
        return "01010101000";
    }
}
