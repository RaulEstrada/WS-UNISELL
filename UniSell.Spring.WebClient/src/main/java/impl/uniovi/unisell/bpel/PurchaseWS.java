
package impl.uniovi.unisell.bpel;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PurchaseWS", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://156.35.98.14:57898/ws/PurchaseWS.asmx?WSDL")
public class PurchaseWS
    extends Service
{

    private final static URL PURCHASEWS_WSDL_LOCATION;
    private final static WebServiceException PURCHASEWS_EXCEPTION;
    private final static QName PURCHASEWS_QNAME = new QName("http://tempuri.org/", "PurchaseWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://156.35.98.14:57898/ws/PurchaseWS.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PURCHASEWS_WSDL_LOCATION = url;
        PURCHASEWS_EXCEPTION = e;
    }

    public PurchaseWS() {
        super(__getWsdlLocation(), PURCHASEWS_QNAME);
    }

    public PurchaseWS(WebServiceFeature... features) {
        super(__getWsdlLocation(), PURCHASEWS_QNAME, features);
    }

    public PurchaseWS(URL wsdlLocation) {
        super(wsdlLocation, PURCHASEWS_QNAME);
    }

    public PurchaseWS(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PURCHASEWS_QNAME, features);
    }

    public PurchaseWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PurchaseWS(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PurchaseWSSoap
     */
    @WebEndpoint(name = "PurchaseWSSoap")
    public PurchaseWSSoap getPurchaseWSSoap() {
        return super.getPort(new QName("http://tempuri.org/", "PurchaseWSSoap"), PurchaseWSSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PurchaseWSSoap
     */
    @WebEndpoint(name = "PurchaseWSSoap")
    public PurchaseWSSoap getPurchaseWSSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "PurchaseWSSoap"), PurchaseWSSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns PurchaseWSSoap
     */
    @WebEndpoint(name = "PurchaseWSSoap12")
    public PurchaseWSSoap getPurchaseWSSoap12() {
        return super.getPort(new QName("http://tempuri.org/", "PurchaseWSSoap12"), PurchaseWSSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PurchaseWSSoap
     */
    @WebEndpoint(name = "PurchaseWSSoap12")
    public PurchaseWSSoap getPurchaseWSSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "PurchaseWSSoap12"), PurchaseWSSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PURCHASEWS_EXCEPTION!= null) {
            throw PURCHASEWS_EXCEPTION;
        }
        return PURCHASEWS_WSDL_LOCATION;
    }

}