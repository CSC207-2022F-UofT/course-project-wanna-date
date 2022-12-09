package use_case.account;

/** InputBoundary for Login feature.
 */
public interface LoginInputBoundary {

    /** Function with no implementation that will be overwritten in LoginManager class.
     */
    boolean isValidLogin(String username, String password);
}
