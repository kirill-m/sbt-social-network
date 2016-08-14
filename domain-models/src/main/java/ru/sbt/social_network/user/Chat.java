package ru.sbt.social_network.user;

import java.util.List;

/**
 * Created by kirill on 14.08.16
 */
public class Chat {

    private final int id;
    private final int user1;
    private final int user2;
    private List<Message> messages;

    public Chat(int id, int user1, int user2, List<Message> messages) {
        this.id = id;
        this.user1 = user1;
        this.user2 = user2;
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}
