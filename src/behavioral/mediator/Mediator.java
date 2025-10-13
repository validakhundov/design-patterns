package behavioral.mediator;

import java.util.ArrayList;

public class Mediator {
    ArrayList<ChatUser> users = new ArrayList<>();

    public void addUser(ChatUser user) {
        users.add(user);
    }

    public void sendMessage(String message, ChatUser source) {
        for (ChatUser user : users) {
            if (user != source) {
                user.receiveMessage(message);
            }
        }
    }
}
