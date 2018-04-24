package ru.aparfenov.meetplace.rest;

import ru.aparfenov.meetplace.jpa.enities.MeetPointEntity;
import ru.aparfenov.storage.dao.MPStorageDAO;

/**
 * Created by ArtemParfenov on 09.11.2017.
 */
public class MPRestfulService implements MPService {
    MPStorageDAO mpStorageDAO;

    public MPRestfulService() {}
    @Override
    public MeetPointEntity getMP(String mpId) {
        return new MeetPointEntity();
    }

    @Override
    public void addMp(MeetPointEntity newMp) {
//        mpStorageDAO.addMP(newMp);
    }

    public String getDecsription() {
        return "Verion 3.0";
    }
}
