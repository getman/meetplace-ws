package ru.aparfenov.storage.dao;

import ru.aparfenov.meetplace.model.MeetPoint;

import java.util.List;

/** provides an interface to any meet point storage DAO object
 * Created by ArtemParfenov on 09.11.2017.
 */

public interface MPStorageDAO {
    public List<MeetPoint> getMPList();
    public MeetPoint getMP(String id);
    public void addMP(MeetPoint newMP);
}
