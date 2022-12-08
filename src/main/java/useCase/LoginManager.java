package useCase;

/** A useCase Class that manages Login feature.
 * */
public class LoginManager implements LoginInputBoundary{

    public LoginManager() {}

    /** Function that returns a boolean value of whether the username and password pair exists in the Database or not.
     * This function is called when the user first logs in to the application.
     *
     * @param username  represents the username of the user.
     * @param password  represents the password of the user.
     * */
    @Override
    public boolean isValidLogin(String username, String password) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        return databaseManager.isPairExist(username, password);
    }
}
