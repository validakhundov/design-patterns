package creational.factory;

public class CurrentAccount implements Account {
    @Override
    public String getDescription() {
        return "This is current account.";
    }
}
