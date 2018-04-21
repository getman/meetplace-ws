package ru.aparfenov.ws.soap;

/** SOAP WS Endpoint для взаимодействия с точками meetpoint
 * Created by ArtemParfenov on 18.03.2018.
 */

import ru.aparfenov.meetplace.jpa.enities.MeetPointEntity;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MeetPointSoapWS {
    @WebMethod
    public MeetPointEntity createMP();
    @WebMethod
    public MeetPointEntity getMP(String id);
    @WebMethod
    public MeetPointEntity updateMP(String id, MeetPointEntity newMP);
    @WebMethod
    public boolean deleteMP(String id);
    @WebMethod
    public int getMpAmount();
}
