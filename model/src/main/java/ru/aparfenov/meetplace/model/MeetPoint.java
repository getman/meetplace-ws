package ru.aparfenov.meetplace.model;

/** Represent a meet point object
 * Created by ArtemParfenov on 22.04.2018.
 */
public class MeetPoint {
    private String id;
    private double x;
    private double y;

    public MeetPoint() {
    }

    public MeetPoint(String id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
