
package uniovi.miw.unisell.data;

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
@WebServiceClient(name = "DataAccess", targetNamespace = "http://unisell.net.data/", wsdlLocation = "http://localhost:9090/WebServices/DataAccessWS.asmx?WSDL")
public class DataAccess
    extends Service
{

    private final static URL DATAACCESS_WSDL_LOCATION;
    private final static WebServiceException DATAACCESS_EXCEPTION;
    private final static QName DATAACCESS_QNAME = new QName("http://unisell.net.data/", "DataAccess");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9090/WebServices/DataAccessWS.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DATAACCESS_WSDL_LOCATION = url;
        DATAACCESS_EXCEPTION = e;
    }

    public DataAccess() {
        super(__getWsdlLocation(), DATAACCESS_QNAME);
    }

    public DataAccess(WebServiceFeature... features) {
        super(__getWsdlLocation(), DATAACCESS_QNAME, features);
    }

    public DataAccess(URL wsdlLocation) {
        super(wsdlLocation, DATAACCESS_QNAME);
    }

    public DataAccess(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DATAACCESS_QNAME, features);
    }

    public DataAccess(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DataAccess(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DataAccessSoap
     */
    @WebEndpoint(name = "DataAccessSoap")
    public DataAccessSoap getDataAccessSoap() {
        return super.getPort(new QName("http://unisell.net.data/", "DataAccessSoap"), DataAccessSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DataAccessSoap
     */
    @WebEndpoint(name = "DataAccessSoap")
    public DataAccessSoap getDataAccessSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://unisell.net.data/", "DataAccessSoap"), DataAccessSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns DataAccessSoap
     */
    @WebEndpoint(name = "DataAccessSoap12")
    public DataAccessSoap getDataAccessSoap12() {
        return super.getPort(new QName("http://unisell.net.data/", "DataAccessSoap12"), DataAccessSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DataAccessSoap
     */
    @WebEndpoint(name = "DataAccessSoap12")
    public DataAccessSoap getDataAccessSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://unisell.net.data/", "DataAccessSoap12"), DataAccessSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DATAACCESS_EXCEPTION!= null) {
            throw DATAACCESS_EXCEPTION;
        }
        return DATAACCESS_WSDL_LOCATION;
    }

}
