package ru.aparfenov.ws.tests;

import ru.aparfenov.ws.soap.api.MeetPointSoapWS;
import ru.aparfenov.ws.soap.api.MeetPointSoapWSImplService;

import javax.xml.ws.WebServiceException;
import java.net.URL;

/**
 * Created by ArtemParfenov on 19.03.2018.
 */
public class SoapWsClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/meetpointws?wsdl");

        MeetPointSoapWSImplService mpService = new MeetPointSoapWSImplService(url);
        MeetPointSoapWS wsProxy = mpService.getMeetPointSoapWSImplPort();
        while (true) {
            try {
                System.out.println(wsProxy.getMP("Hello").getId());
                Thread.sleep(1000);
            } catch (WebServiceException wse) {
                System.out.println("Something wrong, trying to reconnect..");
                try {
                    mpService = new MeetPointSoapWSImplService(url);
                    wsProxy = mpService.getMeetPointSoapWSImplPort();
                } catch (WebServiceException e) {
                    System.out.println("Unseccessfull :(");
                }

            }
        }
    }
}
