package behavioral.state;

public class Main {
    public static void main(String[] args) {
        CardOrder cardOrder = new CardOrder();
        System.out.println("Current State: " + cardOrder.state());

        cardOrder.process();
        cardOrder.deliver();
        cardOrder.activate();

        System.out.println("Final State: " + cardOrder.state());
    }
}
