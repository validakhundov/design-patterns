package behavioral.state;

public class CanceledState implements CardOrderState {
    public void process(CardOrder cardOrder) {
        System.out.println("⛔ Canceled order cannot transition.");
    }

    public void deliver(CardOrder cardOrder) {
        System.out.println("⛔ Canceled order cannot transition.");
    }

    public void activate(CardOrder cardOrder) {
        System.out.println("⛔ Canceled order cannot transition.");
    }

    public void cancel(CardOrder cardOrder, String reason) {
        System.out.println("Already canceled.");
    }

    public String name() {
        return "CANCELED";
    }

}