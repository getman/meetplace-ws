package ru.aparfenov.meetplace.model.coordinates.plain;

import ru.aparfenov.meetplace.model.coordinates.api.Coordinate;
import ru.aparfenov.meetplace.model.coordinates.api.CoordinateHoster;

/**
 * Created by ArtemParfenov on 28.03.2018.
 */
public abstract class CoordinateXPlain extends CoordinateHoster<Long> {
    public Long getCoordinate() {
        return null;
    }

    public void setCoordinate(Long newCoordinateValue) {

    }
}
