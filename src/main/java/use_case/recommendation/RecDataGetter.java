package use_case.recommendation;

import entities.account.UserAccount;

import java.util.HashMap;

public interface RecDataGetter {

    /**
     * Get current user which is logged in.
     * This presumes that there is already a current user to get.
     */
    default UserAccount getCurrentUser(){
        return null;
    }

    /**
     * Get database data.
     * This presumes that the database has already been loaded.
     */
    default HashMap<String, UserAccount> getDatabaseData(){
        return null;
    }
}
