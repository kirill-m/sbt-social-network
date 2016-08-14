package ru.sbt.social_network.user_profile;

import ru.sbt.social_network.database.Database;
import ru.sbt.social_network.database.DatabaseImpl;
import ru.sbt.social_network.user.Gift;
import ru.sbt.social_network.user.User;

import java.util.HashMap;

/**
 * Created by kirill on 14.08.16
 */
public class UserProfileImpl implements UserProfile {
    private final Database db = new DatabaseImpl(new HashMap<>(), new HashMap<>(), new HashMap<>(), new HashMap<>());

    @Override
    public User loadUser(int id) {
        return db.getUserById(id);
    }

    @Override
    public void giveGift(int recipientId, Gift gift) {
        db.addGift(recipientId, gift);
    }
}
