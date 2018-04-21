package ru.aparfenov.meetplace.model.coordinates.api;

/** Represents a point on the map with coordinates
 * Created by ArtemParfenov on 28.03.2018.
 */
public interface GeoPoint {
    public Coordinate getXCoordinate();
    public void setXCoordinate(Coordinate newXCoordinate);
    public Coordinate getYCoordinate();
    public void setYCoordinate(Coordinate newYCoordinate);
}
