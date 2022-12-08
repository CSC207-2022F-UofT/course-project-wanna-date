package interfaceAdapters;

import frameworksDrivers.DataAccess;
import useCase.*;

/** A Controller class that controls the Login feature.
 * This class is called when a user first logs in to the application.
 * */
public class LoginController {

    public LoginController() {}

    /** Function that helps in calling the controller DataAccess class to create the Database of the application.
     * */
    public void callCreateDatabase() {
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();
    }

    /** Function that helps in calling the useCase CurrUserManager to set the UserAccount of the current user of
     * the application.
     *
     * @param username  represents the username of the user.
     * */
    public void helpSetCurrUsername(String username) {
        CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
        currUserManager.setCurrUsername(username);
    }


    /** Function that helps in calling the useCase LoginManager class to check the validity of the username and
     * password combination that the user had given.
     *
     * @param username  represents the username of the user.
     * @param password  represents the password of the user.
     * */
    public boolean callValidLogin(String username, String password) {
        LoginInputBoundary loginInputBoundary = new LoginManager();
        return loginInputBoundary.isValidLogin(username, password);
    }
}
