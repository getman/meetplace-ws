package ru.aparfenov.ws.tests;

import ru.aparfenov.ws.soap.MeetPointSoapWSImpl;

import javax.xml.ws.Endpoint;

/** Публикует (запускает) WS
 * Created by ArtemParfenov on 18.03.2018.
 */
public class SoapWsPublisher {
    public static void main(String [] args) {
        Endpoint.publish("http://localhost:8080/meetpointws",
                new MeetPointSoapWSImpl());
        System.out.println("WS started");
    }
}
