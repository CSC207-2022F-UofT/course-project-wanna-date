package useCase;

import entities.UserAccount;

public class CurrUserManager {

    private static CurrUserManager currUser;
    private String username;

    private CurrUserManager() {
    }

    public static CurrUserManager getCurrUserManager() {
        if (currUser == null)
            currUser = new CurrUserManager();
        return currUser;
    }

    public void setCurrUsername(String username) {
        this.username = username;
    }

    public UserAccount getCurrUser() {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        return databaseManager.retrieveUserAccount(this.username);
    }
}
