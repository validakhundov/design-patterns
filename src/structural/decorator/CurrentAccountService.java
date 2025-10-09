package structural.decorator;

public class CurrentAccountService implements AccountService {
    @Override
    public void openAccount() {
        System.out.println("Opened current account!");

        //x
    }
}
