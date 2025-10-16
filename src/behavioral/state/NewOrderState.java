package behavioral.state;

public class NewOrderState implements CardOrderState {
    public void process(CardOrder cardOrder) {
        cardOrder.setState(new ProcessingState());
        System.out.println("📦 Order moved to PROCESSING (KYC + printing).");
    }

    public void deliver(CardOrder cardOrder) {
        System.out.println("Process first");
    }

    public void activate(CardOrder cardOrder) {
        System.out.println("Deliver first");
    }

    public void cancel(CardOrder ctx, String reason) {
        ctx.setCancelReason(reason);
        ctx.setState(new CanceledState());
        System.out.println("❌ Order canceled in NEW: " + reason);
    }

    public String name() {
        return "NEW";
    }
}
