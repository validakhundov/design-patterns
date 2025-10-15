package behavioral.visitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BaseEntity> entities = List.of(
                new Account("ACC001", 1200),
                new Loan("LN100", 8000),
                new CreditCard("CC999", 5000)
        );

        BankVisitor audit = new AuditReportVisitor();
        BankVisitor fees = new AnnualFeeVisitor();

        System.out.println("=== 🧾 Running Audit Report ===");
        entities.forEach(e -> e.accept(audit));

        System.out.println("\n=== 💰 Calculating Annual Fees ===");
        entities.forEach(e -> e.accept(fees));
    }
}
