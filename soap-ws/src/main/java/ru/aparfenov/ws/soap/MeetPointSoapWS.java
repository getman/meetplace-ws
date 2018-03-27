package ru.aparfenov.ws.soap;

/** SOAP WS Endpoint для взаимодействия с точками meetpoint
 * Created by ArtemParfenov on 18.03.2018.
 */

import ru.aparfenov.meetplace.model.MeetPoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MeetPointSoapWS {
    @WebMethod
    public MeetPoint createMP();
    @WebMethod
    public MeetPoint getMP(String id);
    @WebMethod
    public MeetPoint updateMP(String id, MeetPoint newMP);
    @WebMethod
    public boolean deleteMP(String id);
    @WebMethod
    public int getMpAmount();
}
