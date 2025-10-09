package structural.decorator;

public class CurrentAccountFeeDecorator implements AccountService {
    AccountService accountService;

    public CurrentAccountFeeDecorator(AccountService accountService) {
        this.accountService = accountService;
    }


    @Override
    public void openAccount() {
        accountService.openAccount();
        applyFee();
    }

    public void applyFee() {
        System.out.println("Applied extra fee for account opening!");
    }
}
