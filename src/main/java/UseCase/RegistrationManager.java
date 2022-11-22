package UseCase;

import Entities.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;

public class RegistrationManager {

    String username;
    String full_name;
    int age;
    String pronouns;
    HashMap location;
    char gender;
    char sexuality;
    ArrayList interests;
    String password;
    String password_hint;
    ArrayList<String> users_liked;
    ArrayList<String> users_blocked;

    public RegistrationManager() {}

    public String get_username(String prompt) {
        this.username = prompt;
        return "username";
    }

    public boolean create_account(String username,
                                  String full_name,
                                  int age,
                                  String pronouns,
                                  String country, String province, String city,
                                  char gender,
                                  char sexuality,
                                  String interest,
                                  String password,
                                  String password_hint) {

                return true;
    }
}
