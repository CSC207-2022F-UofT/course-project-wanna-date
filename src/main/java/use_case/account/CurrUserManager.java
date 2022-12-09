package use_case.account;

import entities.account.UserAccount;

/** A useCase singleton Class that stores the current user's UserAccount object.
 * */
public class CurrUserManager {

    // === Class variables ===

    // The static variable representing this very own class.
    private static CurrUserManager currUserManager;

    // The variable representing the username of the current user.
    private String username;

    /** Private constructor function so this class cannot be instantiated outside this class.
     * */
    private CurrUserManager() {}

    public static CurrUserManager getCurrUserManager() {
        if (currUserManager == null)
            currUserManager = new CurrUserManager();
        return currUserManager;
    }

    /** The function used to set the current user's username to this class's instance variable.
     *
     *  @param username  Represents the username of current user
     * */
    public void setCurrUsername(String username) {
        this.username = username;
    }

    /** The function used to get the current user's UserAccount.
     * */
    public UserAccount getCurrUser() {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        return databaseManager.retrieveUserAccount(this.username);
    }
}
