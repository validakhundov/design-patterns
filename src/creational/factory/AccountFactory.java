package creational.factory;

public class AccountFactory {
    public Account getAccount(String type) {
        if (type == null) {
            return null;
        } else if (type.equals("CARD")) {
            return new CardAccount();
        } else {
            return new CurrentAccount();
        }
    }
}
