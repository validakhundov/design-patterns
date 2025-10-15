package behavioral.state;

public class CardOrder {
    private CardOrderState state = new CreatedState();
    private String cancelReason;

    void setState(CardOrderState s) {
        this.state = s;
    }

    String state() {
        return state.name();
    }

    void process() {
        state.process(this);
    }

    void deliver() {
        state.deliver(this);
    }

    void activate() {
        state.activate(this);
    }

    void cancel(String reason) {
        state.cancel(this, reason);
    }

    void setCancelReason(String r) {
        cancelReason = r;
    }

    String cancelReason() {
        return cancelReason;
    }
}
