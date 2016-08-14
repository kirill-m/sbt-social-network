package ru.sbt.social_network.user;

/**
 * Created by kirill on 14.08.16.
 */
public class Gift {

    private final int giftId;
    private final int price;

    public Gift(int giftId, int price) {
        this.giftId = giftId;
        this.price = price;
    }

    public int getGiftId() {
        return giftId;
    }

    public int getPrice() {
        return price;
    }
}
