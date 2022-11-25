package useCase;

import entities.UserDatabase;

public interface LoginInputBoundary {

    boolean is_valid_login(UserDatabase database, String username, String password);

}
