package useCase;

import entities.UserDatabase;

public class LoginManager implements LoginInputBoundary{

    public LoginManager() {}

    public boolean is_valid_login(UserDatabase database, String username, String password) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        return databaseManager.is_pair_exist(database, username, password);
    }

}

