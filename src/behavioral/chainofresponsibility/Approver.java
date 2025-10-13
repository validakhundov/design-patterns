package behavioral.chainofresponsibility;

public abstract class Approver {
    protected Approver next;

    public void setNext(Approver next) {
        this.next = next;
    }

    abstract void approve(String mrBranch);
}
