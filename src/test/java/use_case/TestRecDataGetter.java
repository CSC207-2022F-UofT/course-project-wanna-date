package use_case;

import entities.account.UserAccount;
import use_case.recommendation.RecDataGetter;

import java.util.HashMap;

public class TestRecDataGetter implements RecDataGetter {
    private UserAccount dummyUser;
    private HashMap<String, UserAccount> dummyData;

    /**
     * This class is a dummy class which permits a faking of how the data
     * gets received from singleton classes in the actual recommendation use case.
     */
    public TestRecDataGetter(UserAccount dummyUser, HashMap<String, UserAccount> dummyData){
        this.dummyUser = dummyUser;
        this.dummyData = dummyData;
    }

    /**
     * Get current user which is logged in.
     * This presumes that there is already a current user to get.
     */
    public UserAccount getCurrentUser(){

        // Get and return dummy user to replace the call to the
        // current user singleton in the recommendation use case
        return this.dummyUser;
    }

    /**
     * Get database data.
     * This presumes that the database has already been loaded.
     */
    public HashMap<String, UserAccount> getDatabaseData(){

        // Get and return a mapping from username to user account, replacing the
        // database manager singleton call in the recommendation use case
        return this.dummyData;
    }
}
