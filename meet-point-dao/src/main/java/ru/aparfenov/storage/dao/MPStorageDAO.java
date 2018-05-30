package ru.aparfenov.storage.dao;

import ru.aparfenov.meetplace.dao.db.PreparedStatementParam;
import ru.aparfenov.meetplace.model.MeetPoint;

import java.util.List;
import java.util.Map;

/** provides an interface to any meet point storage DAO object
 * Created by ArtemParfenov on 09.11.2017.
 */

public interface MPStorageDAO {
    /**returns a full list of meetpoint*/
    public List<MeetPoint> getMPList();
    /**returns a list of meetpoint according to parameters*/
    public List<MeetPoint> getMPListByParams(Map<String, PreparedStatementParam> params);
    /**returns a single meetpoint by id*/
    public MeetPoint getMP(String id);
    /**adds a new meetpoint object to storage*/
    public void addMP(MeetPoint newMP);
    /**deletes meetpoint by its id*/
    public void deleteMp(String mpId);
}
