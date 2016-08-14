package ru.sbt.social_network.user;

/**
 * Created by kirill on 14.08.16.
 */
public class User {

    private final int id;
    private final String name;
    private final String avatar;
    private final String info;

    public User(int id, String name, String avatar, String info) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getInfo() {
        return info;
    }
}
