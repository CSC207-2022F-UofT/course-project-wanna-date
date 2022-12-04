package entities;

import java.util.HashMap;

public class UserDatabase {

    /*
     * Class represents the database while this application is running
     */

    // === Class Variables ===

    HashMap<String, UserAccount> data;

    public UserDatabase() {
        this.data = new HashMap<>();
    }

    public HashMap<String, UserAccount> getData() {
        return data;
    }

}
