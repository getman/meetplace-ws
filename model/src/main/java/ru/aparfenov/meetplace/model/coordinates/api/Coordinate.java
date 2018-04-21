package ru.aparfenov.meetplace.model.coordinates.api;

/**
 * Created by ArtemParfenov on 28.03.2018.
 */
public interface Coordinate<T> {
    public T getCoordinate();
    public void setCoordinate(T newCoordinateValue);
}
