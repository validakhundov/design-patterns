package behavioral.visitor;

public interface BaseEntity {
    void accept(BankVisitor visitor);

}
