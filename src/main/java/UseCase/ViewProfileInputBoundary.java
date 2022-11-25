package UseCase;

import Entities.UserDatabase;

import java.util.ArrayList;

public interface ViewProfileInputBoundary {

    ArrayList searchInfo(UserDatabase database, String username);
}
