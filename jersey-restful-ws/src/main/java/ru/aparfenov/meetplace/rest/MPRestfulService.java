package ru.aparfenov.meetplace.rest;

import ru.aparfenov.meetplace.model.MeetPoint;
import ru.aparfenov.meetplace.storage.dao.MPStorageDAO;

/**
 * Created by ArtemParfenov on 09.11.2017.
 */
public class MPRestfulService implements MPService {
    MPStorageDAO mpStorageDAO;

    public MPRestfulService() {}
    @Override
    public MeetPoint getMP(String mpId) {
        return new MeetPoint();
    }

    @Override
    public void addMp(MeetPoint newMp) {
        mpStorageDAO.addMP(newMp);
    }

    public String getDecsription() {
        return "Verion 3.0";
    }
}
