
package ru.aparfenov.ws.soap.api;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.aparfenov.ws.soap.api package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdateMPResponse_QNAME = new QName("http://soap.ws.aparfenov.ru/", "updateMPResponse");
    private final static QName _DeleteMP_QNAME = new QName("http://soap.ws.aparfenov.ru/", "deleteMP");
    private final static QName _GetMP_QNAME = new QName("http://soap.ws.aparfenov.ru/", "getMP");
    private final static QName _DeleteMPResponse_QNAME = new QName("http://soap.ws.aparfenov.ru/", "deleteMPResponse");
    private final static QName _GetMPResponse_QNAME = new QName("http://soap.ws.aparfenov.ru/", "getMPResponse");
    private final static QName _UpdateMP_QNAME = new QName("http://soap.ws.aparfenov.ru/", "updateMP");
    private final static QName _CreateMP_QNAME = new QName("http://soap.ws.aparfenov.ru/", "createMP");
    private final static QName _CreateMPResponse_QNAME = new QName("http://soap.ws.aparfenov.ru/", "createMPResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.aparfenov.ws.soap.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateMP }
     * 
     */
    public UpdateMP createUpdateMP() {
        return new UpdateMP();
    }

    /**
     * Create an instance of {@link GetMPResponse }
     * 
     */
    public GetMPResponse createGetMPResponse() {
        return new GetMPResponse();
    }

    /**
     * Create an instance of {@link DeleteMPResponse }
     * 
     */
    public DeleteMPResponse createDeleteMPResponse() {
        return new DeleteMPResponse();
    }

    /**
     * Create an instance of {@link GetMP }
     * 
     */
    public GetMP createGetMP() {
        return new GetMP();
    }

    /**
     * Create an instance of {@link DeleteMP }
     * 
     */
    public DeleteMP createDeleteMP() {
        return new DeleteMP();
    }

    /**
     * Create an instance of {@link UpdateMPResponse }
     * 
     */
    public UpdateMPResponse createUpdateMPResponse() {
        return new UpdateMPResponse();
    }

    /**
     * Create an instance of {@link CreateMPResponse }
     * 
     */
    public CreateMPResponse createCreateMPResponse() {
        return new CreateMPResponse();
    }

    /**
     * Create an instance of {@link CreateMP }
     * 
     */
    public CreateMP createCreateMP() {
        return new CreateMP();
    }

    /**
     * Create an instance of {@link MeetPoint }
     * 
     */
    public MeetPoint createMeetPoint() {
        return new MeetPoint();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMPResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.aparfenov.ru/", name = "updateMPResponse")
    public JAXBElement<UpdateMPResponse> createUpdateMPResponse(UpdateMPResponse value) {
        return new JAXBElement<UpdateMPResponse>(_UpdateMPResponse_QNAME, UpdateMPResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.aparfenov.ru/", name = "deleteMP")
    public JAXBElement<DeleteMP> createDeleteMP(DeleteMP value) {
        return new JAXBElement<DeleteMP>(_DeleteMP_QNAME, DeleteMP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.aparfenov.ru/", name = "getMP")
    public JAXBElement<GetMP> createGetMP(GetMP value) {
        return new JAXBElement<GetMP>(_GetMP_QNAME, GetMP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMPResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.aparfenov.ru/", name = "deleteMPResponse")
    public JAXBElement<DeleteMPResponse> createDeleteMPResponse(DeleteMPResponse value) {
        return new JAXBElement<DeleteMPResponse>(_DeleteMPResponse_QNAME, DeleteMPResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMPResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.aparfenov.ru/", name = "getMPResponse")
    public JAXBElement<GetMPResponse> createGetMPResponse(GetMPResponse value) {
        return new JAXBElement<GetMPResponse>(_GetMPResponse_QNAME, GetMPResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.aparfenov.ru/", name = "updateMP")
    public JAXBElement<UpdateMP> createUpdateMP(UpdateMP value) {
        return new JAXBElement<UpdateMP>(_UpdateMP_QNAME, UpdateMP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateMP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.aparfenov.ru/", name = "createMP")
    public JAXBElement<CreateMP> createCreateMP(CreateMP value) {
        return new JAXBElement<CreateMP>(_CreateMP_QNAME, CreateMP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateMPResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.aparfenov.ru/", name = "createMPResponse")
    public JAXBElement<CreateMPResponse> createCreateMPResponse(CreateMPResponse value) {
        return new JAXBElement<CreateMPResponse>(_CreateMPResponse_QNAME, CreateMPResponse.class, null, value);
    }

}
