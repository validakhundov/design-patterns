package behavioral.state;

public class ActivatedState implements CardOrderState {
    public void process(CardOrder cardOrder) {
        System.out.println("⛔ Card already activated.");
    }

    public void deliver(CardOrder cardOrder) {
        System.out.println("⛔ Card already activated.");
    }

    public void activate(CardOrder cardOrder) {
        System.out.println("Already active.");
    }

    public void cancel(CardOrder cardOrder, String reason) {
        System.out.println("Cannot cancel an active card.");
    }

    public String name() {
        return "ACTIVATED";
    }
}
