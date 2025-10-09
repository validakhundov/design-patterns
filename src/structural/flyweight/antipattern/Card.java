package structural.flyweight.antipattern;

public class Card {
    private final String bankName;   // repeated across millions
    private final String branchCode; // repeated across customers in same branch
    private final String logo;       // same for all cards


    private final String customerId;
    private final double balance;

    public Card(String bankName, String branchCode, String logo,
                String customerId, double balance) {
        this.bankName = bankName;
        this.branchCode = branchCode;
        this.logo = logo;
        this.customerId = customerId;
        this.balance = balance;
    }
}
