package ru.sbt.social_network.gift_shop;

/**
 * Created by kirill on 14.08.16.
 */
public interface GiftShop {

    void sendGift(int userId, int recipientId, int giftId);
}
