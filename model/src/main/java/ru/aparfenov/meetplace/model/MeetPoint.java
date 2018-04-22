package ru.aparfenov.meetplace.model;

/** Represent a meet point object
 * Created by ArtemParfenov on 22.04.2018.
 */
public class MeetPoint {
    private String id;
    private long x;
    private long y;

    public MeetPoint() {
    }

    public MeetPoint(String id, long x, long y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
}
