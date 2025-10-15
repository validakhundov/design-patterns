package behavioral.state;

public class DeliveryState implements CardOrderState {
    public void process(CardOrder cardOrder) {
        System.out.println("Already in DELIVERY.");
    }

    public void deliver(CardOrder cardOrder) {
        System.out.println("Already in DELIVERY.");
    }

    public void activate(CardOrder cardOrder) {
        cardOrder.setState(new ActivatedState());
        System.out.println("💳 Card activated by customer.");
    }

    public void cancel(CardOrder cardOrder, String reason) {
        cardOrder.setCancelReason(reason);
        cardOrder.setState(new CanceledState());
        System.out.println("❌ Order canceled during delivery: " + reason);
    }

    public String name() {
        return "DELIVERY";
    }
}
