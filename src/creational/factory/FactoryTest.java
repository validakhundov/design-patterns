package creational.factory;

public class FactoryTest {
    public static void main(String[] args) {
        AccountFactory accountFactory = new AccountFactory();

        Account a1 = accountFactory.getAccount("CARD");
        Account a2 = accountFactory.getAccount("CURR");

        System.out.println(a1.getDescription());
        System.out.println(a2.getDescription());
    }
}
