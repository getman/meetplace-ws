package ru.aparfenov.meetplace.storage.dao;

import ru.aparfenov.meetplace.model.MeetPoint;

/**
 * Created by ArtemParfenov on 09.11.2017.
 */
public interface MPStorageDAO {
    public MeetPoint getMP(String id);
    public void addMP(MeetPoint newMP);
}
