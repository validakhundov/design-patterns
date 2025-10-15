package behavioral.observer2;

public class LoanApplication {
    private String id;
    private double amount;
    private String status; // e.g. NEW, UNDER_REVIEW, APPROVED, REJECTED


    public LoanApplication(String id, double amount) {
        this.id = id;
        this.amount = amount;
        this.status = "NEW";
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String newStatus) {
        this.status = newStatus;
    }


}