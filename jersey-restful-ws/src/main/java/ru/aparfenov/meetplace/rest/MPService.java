package ru.aparfenov.meetplace.rest;

import ru.aparfenov.meetplace.jpa.enities.MeetPointEntity;

/**
 * Created by ArtemParfenov on 09.11.2017.
 */
public interface MPService {
    public MeetPointEntity getMP(String mpId);
    public void addMp(MeetPointEntity newMp);
    public String getDecsription();
}
