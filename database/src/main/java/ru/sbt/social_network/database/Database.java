package ru.sbt.social_network.database;

import ru.sbt.social_network.user.User;

import java.util.List;

/**
 * Created by kirill on 14.08.16
 */
public interface Database {

    User getUserById(int id);

    List<User> getFriendList(int id);

    void addFriend(int userId, int friendId);

    void removeFriend(int userId, int friendId);

    List<String> getMessagesHistory(int userId, int friendId);

    String getProfilePic(int id);
}
