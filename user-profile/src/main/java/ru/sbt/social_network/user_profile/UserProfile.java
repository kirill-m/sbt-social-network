package ru.sbt.social_network.user_profile;


import ru.sbt.social_network.user.Gift;
import ru.sbt.social_network.user.User;

/**
 * Created by kirill on 14.08.16
 */
public interface UserProfile {

    User loadUser(int id);

    void giveGift(int recipientId, Gift gift);
}
