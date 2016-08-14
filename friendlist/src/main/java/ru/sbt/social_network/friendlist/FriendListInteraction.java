package ru.sbt.social_network.friendlist;

import ru.sbt.social_network.user.User;

import java.util.List;

/**
 * Created by kirill on 14.08.16.
 */
public interface FriendListInteraction {

    void addFriend(int userId, int friendId);

    void removeFriend(int userId, int friendId);

    List<User> getFriendList(int userId);
}
