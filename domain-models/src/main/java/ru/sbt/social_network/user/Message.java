package ru.sbt.social_network.user;

import java.util.Date;

/**
 * Created by kirill on 14.08.16.
 */
public class Message {

    private final int messageId;
    private final int sender;
    private final String message;
    private final Date date;

    public Message(int messageId, int sender, String message, Date date) {
        this.messageId = messageId;
        this.sender = sender;
        this.message = message;
        this.date = date;
    }

    public int getMessageId() {
        return messageId;
    }

    public int getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
