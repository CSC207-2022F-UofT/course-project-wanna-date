package Entities;

import java.util.HashMap;

public class UserDatabase {

    /*
    * Class represents the database while this application is running
    */

    // === Class Variables ===

    HashMap<String, UserAccount> data;

    public UserDatabase() {
        this.data = new HashMap<String, UserAccount>();   // Does the HashMap have a maximum length?
    }

    public HashMap<String, UserAccount> get_data() {
        return data;
    }

}
