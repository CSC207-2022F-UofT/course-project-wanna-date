package UseCase;

import Entities.UserDatabase;

public class LoginManager implements LoginInputBoundary{

    public LoginManager() {}

    public void help_create_database(String[] data_from_csv) {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.create_database(data_from_csv);
    }

    public boolean is_valid_login(UserDatabase database, String username, String password) {
        DatabaseManager dm = new DatabaseManager();
        if (dm.is_pair_exist(database, username, password)) {
            return true;
        } else {
            return false;
        }
    }
}
