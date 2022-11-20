package UseCase;

import Entities.UserDatabase;

public interface LoginInputBoundary {

    void help_create_database(String[] data_from_csv);

    boolean is_valid_login(UserDatabase database, String username, String password);
}
