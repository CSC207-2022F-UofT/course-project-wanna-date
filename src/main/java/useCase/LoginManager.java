package useCase;

public class LoginManager implements LoginInputBoundary{

    public LoginManager() {}

    @Override
    public boolean isValidLogin(String username, String password) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        return databaseManager.isPairExist(username, password);
    }
}
