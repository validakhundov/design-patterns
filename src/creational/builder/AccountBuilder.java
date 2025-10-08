package creational.builder;

public class AccountBuilder {

    private String iban;

    public AccountBuilder iban(String iban){
        this.iban=iban;
        return this;
    }


    public Account build() {
        return new Account();
    }
}
