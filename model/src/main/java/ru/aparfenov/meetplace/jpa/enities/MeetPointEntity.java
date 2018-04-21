package ru.aparfenov.meetplace.jpa.enities;

import ru.aparfenov.meetplace.model.coordinates.api.GeoPoint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by AParfenov on 27.10.2017.
 */

@Entity
@Table(name="meetpoint")
public class MeetPointEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id = "qwerty";
    @Column(name="x")
    private long x;
    @Column(name="y")
    private long y;

    public MeetPointEntity() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
