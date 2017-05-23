
package uniovi.miw.unisell.data;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uniovi.miw.unisell.data package. 
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

    private final static QName _Security_QNAME = new QName("http://schemas.xmlsoap.org/ws/2002/04/secext", "Security");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uniovi.miw.unisell.data
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Security }
     * 
     */
    public Security createSecurity() {
        return new Security();
    }

    /**
     * Create an instance of {@link FindUserByUsernameResponse }
     * 
     */
    public FindUserByUsernameResponse createFindUserByUsernameResponse() {
        return new FindUserByUsernameResponse();
    }

    /**
     * Create an instance of {@link RemoveUser }
     * 
     */
    public RemoveUser createRemoveUser() {
        return new RemoveUser();
    }

    /**
     * Create an instance of {@link ListAllAdmins }
     * 
     */
    public ListAllAdmins createListAllAdmins() {
        return new ListAllAdmins();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link FindAllUsersResponse }
     * 
     */
    public FindAllUsersResponse createFindAllUsersResponse() {
        return new FindAllUsersResponse();
    }

    /**
     * Create an instance of {@link ArrayOfUser }
     * 
     */
    public ArrayOfUser createArrayOfUser() {
        return new ArrayOfUser();
    }

    /**
     * Create an instance of {@link FindAllUsers }
     * 
     */
    public FindAllUsers createFindAllUsers() {
        return new FindAllUsers();
    }

    /**
     * Create an instance of {@link CountUsers }
     * 
     */
    public CountUsers createCountUsers() {
        return new CountUsers();
    }

    /**
     * Create an instance of {@link CountUsersResponse }
     * 
     */
    public CountUsersResponse createCountUsersResponse() {
        return new CountUsersResponse();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link FindUserByUsernamePassword }
     * 
     */
    public FindUserByUsernamePassword createFindUserByUsernamePassword() {
        return new FindUserByUsernamePassword();
    }

    /**
     * Create an instance of {@link RemoveUserResponse }
     * 
     */
    public RemoveUserResponse createRemoveUserResponse() {
        return new RemoveUserResponse();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link FindUserByUsernamePasswordResponse }
     * 
     */
    public FindUserByUsernamePasswordResponse createFindUserByUsernamePasswordResponse() {
        return new FindUserByUsernamePasswordResponse();
    }

    /**
     * Create an instance of {@link FindUserByUsername }
     * 
     */
    public FindUserByUsername createFindUserByUsername() {
        return new FindUserByUsername();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link FindUser }
     * 
     */
    public FindUser createFindUser() {
        return new FindUser();
    }

    /**
     * Create an instance of {@link FindUserResponse }
     * 
     */
    public FindUserResponse createFindUserResponse() {
        return new FindUserResponse();
    }

    /**
     * Create an instance of {@link ListAllAdminsResponse }
     * 
     */
    public ListAllAdminsResponse createListAllAdminsResponse() {
        return new ListAllAdminsResponse();
    }

    /**
     * Create an instance of {@link ArrayOfUserAdmin }
     * 
     */
    public ArrayOfUserAdmin createArrayOfUserAdmin() {
        return new ArrayOfUserAdmin();
    }

    /**
     * Create an instance of {@link UserAdmin }
     * 
     */
    public UserAdmin createUserAdmin() {
        return new UserAdmin();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Security }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", name = "Security")
    public JAXBElement<Security> createSecurity(Security value) {
        return new JAXBElement<Security>(_Security_QNAME, Security.class, null, value);
    }

}
