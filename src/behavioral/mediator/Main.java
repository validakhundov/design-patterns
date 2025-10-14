package behavioral.mediator;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        ChatUser user1 = new ChatUser("Valid", mediator);
        ChatUser user2 = new ChatUser("Ali", mediator);
        ChatUser user3 = new ChatUser("Ilgar", mediator);

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user3.sendMessage("Salamlar!");
    }
}
