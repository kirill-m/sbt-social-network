package ru.sbt.social_network.friendlist;

import ru.sbt.social_network.database.Database;
import ru.sbt.social_network.user.User;

import java.util.Set;

/**
 * Created by kirill on 14.08.16
 */
public class FriendListInteractionImpl implements FriendListInteraction {
    private final Database db;

    public FriendListInteractionImpl(Database db) {
        this.db = db;
    }

    @Override
    public void addFriend(int userId, int friendId) {
        db.addFriend(userId, friendId);
    }

    @Override
    public void removeFriend(int userId, int friendId) {
        db.removeFriend(userId, friendId);
    }

    @Override
    public Set<User> getFriendList(int userId) {
        return db.getFriendList(userId);
    }
}
