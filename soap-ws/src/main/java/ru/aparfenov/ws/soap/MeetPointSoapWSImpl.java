package ru.aparfenov.ws.soap;

import ru.aparfenov.meetplace.dao.ejb.MPStorageEjbDAO;
import ru.aparfenov.meetplace.jpa.enities.MeetPointEntity;

import javax.ejb.EJB;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ArtemParfenov on 18.03.2018.
 */
@WebService(endpointInterface = "ru.aparfenov.ws.soap.MeetPointSoapWS")
public class MeetPointSoapWSImpl implements MeetPointSoapWS {
    @EJB
    private MPStorageEjbDAO storageDao;
    @Override
    public MeetPointEntity createMP() {
        return null;
    }

    @Override
    public MeetPointEntity getMP(String id) {

//        MeetPointEntity mp = new MeetPointEntity();
        MeetPointEntity mp = storageDao.getMP(id);
        mp.setId(id + " spring :)" + new SimpleDateFormat("dd-MM-yyyy / HH:mm:SS").format(new Date()));
        return mp;
    }

    @Override
    public MeetPointEntity updateMP(String id, MeetPointEntity newMP) {
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
