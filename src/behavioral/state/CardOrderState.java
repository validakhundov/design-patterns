package behavioral.state;

interface CardOrderState {
    void process(CardOrder cardOrder);

    void deliver(CardOrder cardOrder);

    void activate(CardOrder cardOrder);

    void cancel(CardOrder cardOrder, String reason);

    String name();
}
