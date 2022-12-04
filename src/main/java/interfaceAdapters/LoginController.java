package interfaceAdapters;

import frameworksDrivers.DataAccess;
import useCase.*;

public class LoginController {

    public LoginController() {}

    public void helpSetCurrUsername(String username) {
        CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
        currUserManager.setCurrUsername(username);
    }

    public void callCreateDatabase() {
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();
    }

    public boolean callValidLogin(String username, String password) {
        LoginInputBoundary loginInputBoundary = new LoginManager();
        return loginInputBoundary.isValidLogin(username, password);
    }
}
