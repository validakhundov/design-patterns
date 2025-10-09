package structural.bridge;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new CurrentAccountService();

        accountService.withdrawMoney(10.0);
    }
}
