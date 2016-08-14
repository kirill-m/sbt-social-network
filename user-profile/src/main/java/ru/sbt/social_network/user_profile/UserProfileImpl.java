package ru.sbt.social_network.user_profile;

import ru.sbt.social_network.database.Database;
import ru.sbt.social_network.user.Gift;
import ru.sbt.social_network.user.User;

/**
 * Created by kirill on 14.08.16
 */
public class UserProfileImpl implements UserProfile {
    private final Database db;

    public UserProfileImpl(Database db) {
        this.db = db;
    }

    @Override
    public User loadUser(int id) {
        return db.getUserById(id);
    }

    @Override
    public void giveGift(int recipientId, Gift gift) {
        db.addGift(recipientId, gift);
    }
}
