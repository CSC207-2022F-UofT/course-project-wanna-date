package entities;

import java.util.HashMap;

/**
 * An Entity class representing the Database in the application while the application is running
 * Has one instance variable containing the user's information in the form of a HashMap
 */
public class UserDatabase {

    // === Class Variables ===

    // The variable storing the user's information in the form of a HashMap.
    // They key of HashMap is the username and the value is the corresponding UserAccount.
    HashMap<String, UserAccount> data;

    public UserDatabase() {
        this.data = new HashMap<>();
    }

    /** Get functions for instance variable data
     * */
    public HashMap<String, UserAccount> getData() {
        return data;
    }

}
