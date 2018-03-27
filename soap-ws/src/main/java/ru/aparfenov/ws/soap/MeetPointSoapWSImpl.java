package ru.aparfenov.ws.soap;

import ru.aparfenov.meetplace.model.MeetPoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ArtemParfenov on 18.03.2018.
 */
@WebService(endpointInterface = "ru.aparfenov.ws.soap.MeetPointSoapWS")
public class MeetPointSoapWSImpl implements MeetPointSoapWS {
    @Override
    public MeetPoint createMP() {
        return null;
    }

    @Override
    public MeetPoint getMP(String id) {
        MeetPoint mp = new MeetPoint();
        mp.setId(id + " spring :)" + new SimpleDateFormat("dd-MM-yyyy / HH:mm:SS").format(new Date()));
        return mp;
    }

    @Override
    public MeetPoint updateMP(String id, MeetPoint newMP) {
        return null;
    }

    @Override
    public boolean deleteMP(String id) {
        return false;
    }

    @Override
    public int getMpAmount() {
        return 10;
    }


}
