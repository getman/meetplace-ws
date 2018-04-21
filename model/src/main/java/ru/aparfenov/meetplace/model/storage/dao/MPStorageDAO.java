package ru.aparfenov.meetplace.model.storage.dao;

import ru.aparfenov.meetplace.jpa.enities.MeetPointEntity;

/**
 * Created by ArtemParfenov on 09.11.2017.
 */

public interface MPStorageDAO {
    public MeetPointEntity getMP(String id);
    public void addMP(MeetPointEntity newMP);
}
