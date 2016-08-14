package ru.sbt.social_network.dialog;

import ru.sbt.social_network.user.Message;

import java.util.List;

/**
 * Created by kirill on 14.08.16.
 */
public interface Dialog {

    List<Message> loadHistory(int userOneId, int userTwoId);

    void sendMessage(int userId, int recipient, Message message);

    void createDialog(int userOneId, int userTwoId);
}
