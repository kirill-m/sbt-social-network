package ru.sbt.social_network.database;

import ru.sbt.social_network.user.Chat;
import ru.sbt.social_network.user.Gift;
import ru.sbt.social_network.user.Message;
import ru.sbt.social_network.user.User;

import java.util.List;
import java.util.Set;

/**
 * Created by kirill on 14.08.16
 */
public interface Database {

    User getUserById(int id);

    Set<User> getFriendList(int id);

    void addFriend(int userId, int friendId);

    void removeFriend(int userId, int friendId);

    List<Message> getMessagesHistory(int userId, int friendId);

    void saveMessage(int chatId, Message message);

    void addGift(int recipientId, Gift gift);

    Chat getChat(int userId1, int userId2);

    void addChat(int userId1, int userId2);
}
