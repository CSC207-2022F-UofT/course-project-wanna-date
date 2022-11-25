package UseCase;

import Entities.UserAccount;
import Entities.UserDatabase;

public class LoginManager implements LoginInputBoundary{
    public UserAccount currUser;

    private String currentUser;
    public LoginManager() {}

    public void help_create_database(String[] data_from_csv) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        databaseManager.createDatabase(data_from_csv);
    }

    public boolean is_valid_login(UserDatabase database, String username, String password) {
        DatabaseManager dm = DatabaseManager.getDatabaseManager();
        if (dm.is_pair_exist(database, username, password)) {
            this.currUser = dm.retrieve_user_account(username);

            return true;
        } else {
            return false;
        }
    }

    public UserAccount getCurrUser(){return this.currUser;}

}

