package UseCase;

import Entities.UserAccount;
import Entities.UserDatabase;

public class LoginManager implements LoginInputBoundary{

    private String currentUser;
    public LoginManager() {}

    public boolean is_valid_login(UserDatabase database, String username, String password) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
//        UserDatabase database = databaseManager.getDatabase();
        if (databaseManager.is_pair_exist(database, username, password)) {
            this.currentUser = username;
            return true;
        } else {
            return false;
        }
    }

    public UserAccount currentUser(UserDatabase database) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        return databaseManager.retrieve_user_account(this.currentUser);
    }
}

