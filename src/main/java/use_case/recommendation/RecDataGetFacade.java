package use_case.recommendation;

import entities.account.UserAccount;
import use_case.account.*;

import java.util.HashMap;

public class RecDataGetFacade implements RecDataGetter {

    /**
     * This class implements the facade design pattern and allows
     * the Recommendation use case interactor to interact
     * with singletons. This is especially good for unit tests with Mockito.
     */
    public RecDataGetFacade(){}

    /**
     * Get current user which is logged in.
     * This presumes that there is already a current user to get.
     */
    public UserAccount getCurrentUser(){

        // Get and return the current user, presuming login is already done
        CurrUserManager singletonUserManager = CurrUserManager.getCurrUserManager();
        return singletonUserManager.getCurrUser();
    }

    /**
     * Get database data.
     * This presumes that the database has already been loaded.
     */
    public HashMap<String, UserAccount> getDatabaseData(){

        // Get and return a mapping from username to user account, presuming that this
        // has already been done
        DatabaseManager databaseRef = DatabaseManager.getDatabaseManager();
        return databaseRef.getDatabase().getData();
    }
}
