package ru.aparfenov.meetplace.rest;

import ru.aparfenov.meetplace.model.MeetPoint;

/**
 * Created by ArtemParfenov on 09.11.2017.
 */
public interface MPService {
    public MeetPoint getMP(String mpId);
    public void addMp(MeetPoint newMp);
    public String getDecsription();
}
