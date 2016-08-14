package ru.sbt.social_network.user;

/**
 * Created by kirill on 14.08.16.
 */
public class Photo {

    private final String photo;
    private final int width;
    private final int height;
    private final int size;

    public Photo(String photo, int width, int height, int size) {
        this.photo = photo;
        this.width = width;
        this.height = height;
        this.size = size;
    }

    public String getPhoto() {
        return photo;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSize() {
        return size;
    }
}
