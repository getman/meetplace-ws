package ru.aparfenov.meetplace.model;

/**
 * Created by AParfenov on 27.10.2017.
 */
public class MeetPoint {
    private long x = 1;
    private long y = 1;
    private String id = "qwerty";

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
