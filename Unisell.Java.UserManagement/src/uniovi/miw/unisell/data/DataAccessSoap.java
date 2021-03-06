
package uniovi.miw.unisell.data;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DataAccessSoap", targetNamespace = "http://unisell.net.data/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DataAccessSoap {


    /**
     * 
     * @param security
     * @return
     *     returns int
     */
    @WebMethod(operationName = "CountUsers", action = "http://unisell.net.data/CountUsers")
    @WebResult(name = "CountUsersResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "CountUsers", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CountUsers")
    @ResponseWrapper(localName = "CountUsersResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CountUsersResponse")
    public int countUsers(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param user
     * @return
     *     returns uniovi.miw.unisell.data.User
     */
    @WebMethod(operationName = "CreateUser", action = "http://unisell.net.data/CreateUser")
    @WebResult(name = "CreateUserResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "CreateUser", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CreateUser")
    @ResponseWrapper(localName = "CreateUserResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CreateUserResponse")
    public User createUser(
        @WebParam(name = "user", targetNamespace = "http://unisell.net.data/")
        User user);

    /**
     * 
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfUser
     */
    @WebMethod(operationName = "FindAllUsers", action = "http://unisell.net.data/FindAllUsers")
    @WebResult(name = "FindAllUsersResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindAllUsers", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindAllUsers")
    @ResponseWrapper(localName = "FindAllUsersResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindAllUsersResponse")
    public ArrayOfUser findAllUsers(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param id
     * @return
     *     returns uniovi.miw.unisell.data.User
     */
    @WebMethod(operationName = "FindUser", action = "http://unisell.net.data/FindUser")
    @WebResult(name = "FindUserResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindUser", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindUser")
    @ResponseWrapper(localName = "FindUserResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindUserResponse")
    public User findUser(
        @WebParam(name = "id", targetNamespace = "http://unisell.net.data/")
        long id,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param password
     * @param rolesAllowed
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Login", action = "http://unisell.net.data/Login")
    @WebResult(name = "LoginResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "Login", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.Login")
    @ResponseWrapper(localName = "LoginResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.LoginResponse")
    public String login(
        @WebParam(name = "username", targetNamespace = "http://unisell.net.data/")
        String username,
        @WebParam(name = "password", targetNamespace = "http://unisell.net.data/")
        String password,
        @WebParam(name = "rolesAllowed", targetNamespace = "http://unisell.net.data/")
        ArrayOfUserRole rolesAllowed);

    /**
     * 
     * @param username
     * @return
     *     returns uniovi.miw.unisell.data.User
     */
    @WebMethod(operationName = "FindUserByUsername", action = "http://unisell.net.data/FindUserByUsername")
    @WebResult(name = "FindUserByUsernameResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindUserByUsername", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindUserByUsername")
    @ResponseWrapper(localName = "FindUserByUsernameResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindUserByUsernameResponse")
    public User findUserByUsername(
        @WebParam(name = "username", targetNamespace = "http://unisell.net.data/")
        String username);

    /**
     * 
     * @param security
     * @param id
     * @return
     *     returns uniovi.miw.unisell.data.User
     */
    @WebMethod(operationName = "RemoveUser", action = "http://unisell.net.data/RemoveUser")
    @WebResult(name = "RemoveUserResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "RemoveUser", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.RemoveUser")
    @ResponseWrapper(localName = "RemoveUserResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.RemoveUserResponse")
    public User removeUser(
        @WebParam(name = "id", targetNamespace = "http://unisell.net.data/")
        long id,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param user
     * @return
     *     returns uniovi.miw.unisell.data.User
     */
    @WebMethod(operationName = "UpdateUser", action = "http://unisell.net.data/UpdateUser")
    @WebResult(name = "UpdateUserResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "UpdateUser", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.UpdateUser")
    @ResponseWrapper(localName = "UpdateUserResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.UpdateUserResponse")
    public User updateUser(
        @WebParam(name = "user", targetNamespace = "http://unisell.net.data/")
        User user,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfUserAdmin
     */
    @WebMethod(operationName = "ListAllAdmins", action = "http://unisell.net.data/ListAllAdmins")
    @WebResult(name = "ListAllAdminsResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "ListAllAdmins", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.ListAllAdmins")
    @ResponseWrapper(localName = "ListAllAdminsResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.ListAllAdminsResponse")
    public ArrayOfUserAdmin listAllAdmins(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfUserSeller
     */
    @WebMethod(operationName = "ListAllSellers", action = "http://unisell.net.data/ListAllSellers")
    @WebResult(name = "ListAllSellersResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "ListAllSellers", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.ListAllSellers")
    @ResponseWrapper(localName = "ListAllSellersResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.ListAllSellersResponse")
    public ArrayOfUserSeller listAllSellers(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfUserBuyer
     */
    @WebMethod(operationName = "ListAllBuyers", action = "http://unisell.net.data/ListAllBuyers")
    @WebResult(name = "ListAllBuyersResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "ListAllBuyers", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.ListAllBuyers")
    @ResponseWrapper(localName = "ListAllBuyersResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.ListAllBuyersResponse")
    public ArrayOfUserBuyer listAllBuyers(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param id
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfUserSeller
     */
    @WebMethod(operationName = "FindSellersByCompanyId", action = "http://unisell.net.data/FindSellersByCompanyId")
    @WebResult(name = "FindSellersByCompanyIdResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindSellersByCompanyId", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindSellersByCompanyId")
    @ResponseWrapper(localName = "FindSellersByCompanyIdResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindSellersByCompanyIdResponse")
    public ArrayOfUserSeller findSellersByCompanyId(
        @WebParam(name = "id", targetNamespace = "http://unisell.net.data/")
        long id,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param filter
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfUser
     */
    @WebMethod(operationName = "FindUsersByFilter", action = "http://unisell.net.data/FindUsersByFilter")
    @WebResult(name = "FindUsersByFilterResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindUsersByFilter", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindUsersByFilter")
    @ResponseWrapper(localName = "FindUsersByFilterResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindUsersByFilterResponse")
    public ArrayOfUser findUsersByFilter(
        @WebParam(name = "filter", targetNamespace = "http://unisell.net.data/")
        UserSearchFilter filter);

    /**
     * 
     * @param security
     * @return
     *     returns int
     */
    @WebMethod(operationName = "CountCategories", action = "http://unisell.net.data/CountCategories")
    @WebResult(name = "CountCategoriesResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "CountCategories", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CountCategories")
    @ResponseWrapper(localName = "CountCategoriesResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CountCategoriesResponse")
    public int countCategories(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfCategory
     */
    @WebMethod(operationName = "FindAllCategories", action = "http://unisell.net.data/FindAllCategories")
    @WebResult(name = "FindAllCategoriesResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindAllCategories", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindAllCategories")
    @ResponseWrapper(localName = "FindAllCategoriesResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindAllCategoriesResponse")
    public ArrayOfCategory findAllCategories(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param category
     * @return
     *     returns uniovi.miw.unisell.data.Category
     */
    @WebMethod(operationName = "CreateCategory", action = "http://unisell.net.data/CreateCategory")
    @WebResult(name = "CreateCategoryResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "CreateCategory", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CreateCategory")
    @ResponseWrapper(localName = "CreateCategoryResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CreateCategoryResponse")
    public Category createCategory(
        @WebParam(name = "Category", targetNamespace = "http://unisell.net.data/")
        Category category,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param id
     * @return
     *     returns uniovi.miw.unisell.data.Category
     */
    @WebMethod(operationName = "FindCategory", action = "http://unisell.net.data/FindCategory")
    @WebResult(name = "FindCategoryResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindCategory", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindCategory")
    @ResponseWrapper(localName = "FindCategoryResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindCategoryResponse")
    public Category findCategory(
        @WebParam(name = "id", targetNamespace = "http://unisell.net.data/")
        long id,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param id
     * @return
     *     returns uniovi.miw.unisell.data.Category
     */
    @WebMethod(operationName = "RemoveCategory", action = "http://unisell.net.data/RemoveCategory")
    @WebResult(name = "RemoveCategoryResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "RemoveCategory", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.RemoveCategory")
    @ResponseWrapper(localName = "RemoveCategoryResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.RemoveCategoryResponse")
    public Category removeCategory(
        @WebParam(name = "id", targetNamespace = "http://unisell.net.data/")
        long id,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param category
     * @return
     *     returns uniovi.miw.unisell.data.Category
     */
    @WebMethod(operationName = "UpdateCategory", action = "http://unisell.net.data/UpdateCategory")
    @WebResult(name = "UpdateCategoryResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "UpdateCategory", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.UpdateCategory")
    @ResponseWrapper(localName = "UpdateCategoryResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.UpdateCategoryResponse")
    public Category updateCategory(
        @WebParam(name = "Category", targetNamespace = "http://unisell.net.data/")
        Category category,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param name
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfCategory
     */
    @WebMethod(operationName = "FindCategoriesByName", action = "http://unisell.net.data/FindCategoriesByName")
    @WebResult(name = "FindCategoriesByNameResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindCategoriesByName", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindCategoriesByName")
    @ResponseWrapper(localName = "FindCategoriesByNameResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindCategoriesByNameResponse")
    public ArrayOfCategory findCategoriesByName(
        @WebParam(name = "name", targetNamespace = "http://unisell.net.data/")
        String name);

    /**
     * 
     * @param security
     * @return
     *     returns int
     */
    @WebMethod(operationName = "CountProducts", action = "http://unisell.net.data/CountProducts")
    @WebResult(name = "CountProductsResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "CountProducts", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CountProducts")
    @ResponseWrapper(localName = "CountProductsResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CountProductsResponse")
    public int countProducts(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfProduct
     */
    @WebMethod(operationName = "FindAllProducts", action = "http://unisell.net.data/FindAllProducts")
    @WebResult(name = "FindAllProductsResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindAllProducts", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindAllProducts")
    @ResponseWrapper(localName = "FindAllProductsResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindAllProductsResponse")
    public ArrayOfProduct findAllProducts(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param product
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.Product
     */
    @WebMethod(operationName = "CreateProduct", action = "http://unisell.net.data/CreateProduct")
    @WebResult(name = "CreateProductResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "CreateProduct", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CreateProduct")
    @ResponseWrapper(localName = "CreateProductResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CreateProductResponse")
    public Product createProduct(
        @WebParam(name = "Product", targetNamespace = "http://unisell.net.data/")
        Product product,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param id
     * @return
     *     returns uniovi.miw.unisell.data.Product
     */
    @WebMethod(operationName = "FindProduct", action = "http://unisell.net.data/FindProduct")
    @WebResult(name = "FindProductResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindProduct", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindProduct")
    @ResponseWrapper(localName = "FindProductResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindProductResponse")
    public Product findProduct(
        @WebParam(name = "id", targetNamespace = "http://unisell.net.data/")
        long id,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param filter
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfProduct
     */
    @WebMethod(operationName = "FindProductsByFilter", action = "http://unisell.net.data/FindProductsByFilter")
    @WebResult(name = "FindProductsByFilterResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindProductsByFilter", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindProductsByFilter")
    @ResponseWrapper(localName = "FindProductsByFilterResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindProductsByFilterResponse")
    public ArrayOfProduct findProductsByFilter(
        @WebParam(name = "filter", targetNamespace = "http://unisell.net.data/")
        ProductSearchFilter filter,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param id
     * @return
     *     returns uniovi.miw.unisell.data.Product
     */
    @WebMethod(operationName = "RemoveProduct", action = "http://unisell.net.data/RemoveProduct")
    @WebResult(name = "RemoveProductResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "RemoveProduct", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.RemoveProduct")
    @ResponseWrapper(localName = "RemoveProductResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.RemoveProductResponse")
    public Product removeProduct(
        @WebParam(name = "id", targetNamespace = "http://unisell.net.data/")
        long id,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param product
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.Product
     */
    @WebMethod(operationName = "UpdateProduct", action = "http://unisell.net.data/UpdateProduct")
    @WebResult(name = "UpdateProductResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "UpdateProduct", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.UpdateProduct")
    @ResponseWrapper(localName = "UpdateProductResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.UpdateProductResponse")
    public Product updateProduct(
        @WebParam(name = "Product", targetNamespace = "http://unisell.net.data/")
        Product product,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @return
     *     returns int
     */
    @WebMethod(operationName = "CountOrders", action = "http://unisell.net.data/CountOrders")
    @WebResult(name = "CountOrdersResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "CountOrders", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CountOrders")
    @ResponseWrapper(localName = "CountOrdersResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CountOrdersResponse")
    public int countOrders(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfOrder
     */
    @WebMethod(operationName = "FindAllOrders", action = "http://unisell.net.data/FindAllOrders")
    @WebResult(name = "FindAllOrdersResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindAllOrders", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindAllOrders")
    @ResponseWrapper(localName = "FindAllOrdersResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindAllOrdersResponse")
    public ArrayOfOrder findAllOrders(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param username
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfOrderData
     */
    @WebMethod(operationName = "FindOrdersByUsername", action = "http://unisell.net.data/FindOrdersByUsername")
    @WebResult(name = "FindOrdersByUsernameResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindOrdersByUsername", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindOrdersByUsername")
    @ResponseWrapper(localName = "FindOrdersByUsernameResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindOrdersByUsernameResponse")
    public ArrayOfOrderData findOrdersByUsername(
        @WebParam(name = "username", targetNamespace = "http://unisell.net.data/")
        String username,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param order
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "CreateOrder", action = "http://unisell.net.data/CreateOrder")
    @WebResult(name = "CreateOrderResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "CreateOrder", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CreateOrder")
    @ResponseWrapper(localName = "CreateOrderResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CreateOrderResponse")
    public boolean createOrder(
        @WebParam(name = "Order", targetNamespace = "http://unisell.net.data/")
        Order order,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param id
     * @return
     *     returns uniovi.miw.unisell.data.Order
     */
    @WebMethod(operationName = "FindOrder", action = "http://unisell.net.data/FindOrder")
    @WebResult(name = "FindOrderResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindOrder", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindOrder")
    @ResponseWrapper(localName = "FindOrderResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindOrderResponse")
    public Order findOrder(
        @WebParam(name = "id", targetNamespace = "http://unisell.net.data/")
        long id,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param id
     * @return
     *     returns uniovi.miw.unisell.data.Order
     */
    @WebMethod(operationName = "RemoveOrder", action = "http://unisell.net.data/RemoveOrder")
    @WebResult(name = "RemoveOrderResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "RemoveOrder", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.RemoveOrder")
    @ResponseWrapper(localName = "RemoveOrderResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.RemoveOrderResponse")
    public Order removeOrder(
        @WebParam(name = "id", targetNamespace = "http://unisell.net.data/")
        long id,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param order
     * @return
     *     returns uniovi.miw.unisell.data.Order
     */
    @WebMethod(operationName = "UpdateOrder", action = "http://unisell.net.data/UpdateOrder")
    @WebResult(name = "UpdateOrderResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "UpdateOrder", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.UpdateOrder")
    @ResponseWrapper(localName = "UpdateOrderResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.UpdateOrderResponse")
    public Order updateOrder(
        @WebParam(name = "Order", targetNamespace = "http://unisell.net.data/")
        Order order,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @return
     *     returns int
     */
    @WebMethod(operationName = "CountCompanies", action = "http://unisell.net.data/CountCompanies")
    @WebResult(name = "CountCompaniesResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "CountCompanies", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CountCompanies")
    @ResponseWrapper(localName = "CountCompaniesResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CountCompaniesResponse")
    public int countCompanies(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param company
     * @return
     *     returns uniovi.miw.unisell.data.Company
     */
    @WebMethod(operationName = "CreateCompany", action = "http://unisell.net.data/CreateCompany")
    @WebResult(name = "CreateCompanyResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "CreateCompany", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CreateCompany")
    @ResponseWrapper(localName = "CreateCompanyResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.CreateCompanyResponse")
    public Company createCompany(
        @WebParam(name = "Company", targetNamespace = "http://unisell.net.data/")
        Company company,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfCompany
     */
    @WebMethod(operationName = "FindAllCompanies", action = "http://unisell.net.data/FindAllCompanies")
    @WebResult(name = "FindAllCompaniesResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindAllCompanies", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindAllCompanies")
    @ResponseWrapper(localName = "FindAllCompaniesResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindAllCompaniesResponse")
    public ArrayOfCompany findAllCompanies(
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param id
     * @return
     *     returns uniovi.miw.unisell.data.Company
     */
    @WebMethod(operationName = "FindCompany", action = "http://unisell.net.data/FindCompany")
    @WebResult(name = "FindCompanyResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindCompany", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindCompany")
    @ResponseWrapper(localName = "FindCompanyResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindCompanyResponse")
    public Company findCompany(
        @WebParam(name = "id", targetNamespace = "http://unisell.net.data/")
        long id,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param id
     * @return
     *     returns uniovi.miw.unisell.data.Company
     */
    @WebMethod(operationName = "RemoveCompany", action = "http://unisell.net.data/RemoveCompany")
    @WebResult(name = "RemoveCompanyResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "RemoveCompany", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.RemoveCompany")
    @ResponseWrapper(localName = "RemoveCompanyResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.RemoveCompanyResponse")
    public Company removeCompany(
        @WebParam(name = "id", targetNamespace = "http://unisell.net.data/")
        long id,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param security
     * @param company
     * @return
     *     returns uniovi.miw.unisell.data.Company
     */
    @WebMethod(operationName = "UpdateCompany", action = "http://unisell.net.data/UpdateCompany")
    @WebResult(name = "UpdateCompanyResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "UpdateCompany", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.UpdateCompany")
    @ResponseWrapper(localName = "UpdateCompanyResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.UpdateCompanyResponse")
    public Company updateCompany(
        @WebParam(name = "company", targetNamespace = "http://unisell.net.data/")
        Company company,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @param filter
     * @param security
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfCompany
     */
    @WebMethod(operationName = "FindCompaniesByFilter", action = "http://unisell.net.data/FindCompaniesByFilter")
    @WebResult(name = "FindCompaniesByFilterResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindCompaniesByFilter", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindCompaniesByFilter")
    @ResponseWrapper(localName = "FindCompaniesByFilterResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindCompaniesByFilterResponse")
    public ArrayOfCompany findCompaniesByFilter(
        @WebParam(name = "filter", targetNamespace = "http://unisell.net.data/")
        CompanySearchFilter filter,
        @WebParam(name = "Security", targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext", header = true, partName = "Security")
        Security security);

    /**
     * 
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfUserRole
     */
    @WebMethod(operationName = "FindUserRoles", action = "http://unisell.net.data/FindUserRoles")
    @WebResult(name = "FindUserRolesResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindUserRoles", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindUserRoles")
    @ResponseWrapper(localName = "FindUserRolesResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindUserRolesResponse")
    public ArrayOfUserRole findUserRoles();

    /**
     * 
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfPersonIdDocumentType
     */
    @WebMethod(operationName = "FindPersonIdDocumentTypes", action = "http://unisell.net.data/FindPersonIdDocumentTypes")
    @WebResult(name = "FindPersonIdDocumentTypesResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindPersonIdDocumentTypes", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindPersonIdDocumentTypes")
    @ResponseWrapper(localName = "FindPersonIdDocumentTypesResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindPersonIdDocumentTypesResponse")
    public ArrayOfPersonIdDocumentType findPersonIdDocumentTypes();

    /**
     * 
     * @return
     *     returns uniovi.miw.unisell.data.ArrayOfLegalPersonIdDocumentType
     */
    @WebMethod(operationName = "FindLegalIdDocumentTypes", action = "http://unisell.net.data/FindLegalIdDocumentTypes")
    @WebResult(name = "FindLegalIdDocumentTypesResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindLegalIdDocumentTypes", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindLegalIdDocumentTypes")
    @ResponseWrapper(localName = "FindLegalIdDocumentTypesResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindLegalIdDocumentTypesResponse")
    public ArrayOfLegalPersonIdDocumentType findLegalIdDocumentTypes();

    /**
     * 
     * @param productId
     * @return
     *     returns int
     */
    @WebMethod(operationName = "FindProductAvailability", action = "http://unisell.net.data/FindProductAvailability")
    @WebResult(name = "FindProductAvailabilityResult", targetNamespace = "http://unisell.net.data/")
    @RequestWrapper(localName = "FindProductAvailability", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindProductAvailability")
    @ResponseWrapper(localName = "FindProductAvailabilityResponse", targetNamespace = "http://unisell.net.data/", className = "uniovi.miw.unisell.data.FindProductAvailabilityResponse")
    public int findProductAvailability(
        @WebParam(name = "productId", targetNamespace = "http://unisell.net.data/")
        long productId);

}
