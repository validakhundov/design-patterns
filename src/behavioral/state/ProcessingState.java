package behavioral.state;

public
class ProcessingState implements CardOrderState {
    public void process(CardOrder ctx) {
        System.out.println("Already processing.");
    }

    public void deliver(CardOrder ctx) {
        ctx.setState(new DeliveryState());
        System.out.println("🚚 Card is out for DELIVERY to customer.");
    }

    public void activate(CardOrder ctx) {
        System.out.println("⛔ Deliver first");
    }

    public void cancel(CardOrder ctx, String reason) {
        ctx.setCancelReason(reason);
        ctx.setState(new CanceledState());
        System.out.println("❌ Order canceled during processing: " + reason);
    }

    public String name() {
        return "PROCESSING";
    }
}
