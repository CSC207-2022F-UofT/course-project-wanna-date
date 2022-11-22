package Entities;

import java.util.HashMap;
import java.util.ArrayList;

public class OldUserAccount {
    /*
     * Represents a single user in the application
     * Contains this user's variables
     */

    // === Class Variables ===

    // The username of user that is unique in the application.
    private String username;

    // The real name of user.
    private String full_name;

    // The age of user.
    private int age;

    // The pronouns identified by user.
    private String pronouns;

    // The location where user lives.
    // Consists of three keys, each mapped to their own values:
    // country, province, and city.
    private HashMap location;

    // The gender identified by user.
    // 'M': male
    // 'F': female
    // 'N': non-binary
    private char gender;

    // The sexuality identified by user.
    // 'G': gay
    // 'L': lesbian
    // 'H': heterosexual
    // 'B': bisexual
    private char sexuality;

    // The list of interests by user.
    private ArrayList interests;

    // The password of user's account.
    private String password;

    // The list of usernames that this user liked.
    private ArrayList<OldUserAccount> liked_users;

    // The list of users who liked this user
    private ArrayList<OldUserAccount> liked_by_users;

    // The list of usernames that this user blocked.
    private ArrayList<OldUserAccount> blocked_users;

    // The list of users who blocked this user
    private ArrayList<OldUserAccount> blocked_by_users;

    public OldUserAccount(String username,
                          String full_name,
                          int age,
                          String pronouns,
                          String country, String province, String city,
                          char gender,
                          char sexuality,
                          ArrayList interests,
                          String password,
                          String password_hint) {
        this.username = username;
        this.full_name = full_name;
        this.age = age;
        this.pronouns = pronouns;
        HashMap location = new HashMap(3);
        location.put("country", country);
        location.put("province", province);
        location.put("city", city);
        this.gender = gender;
        this.sexuality = sexuality;
        this.interests = interests;
        this.password = password;
        ArrayList<OldUserAccount> liked_users = new ArrayList<OldUserAccount>();
        ArrayList<OldUserAccount> liked_by_users = new ArrayList<OldUserAccount>();
        ArrayList<OldUserAccount> blocked_users = new ArrayList<OldUserAccount>();
        ArrayList<OldUserAccount> blocked_by_users = new ArrayList<OldUserAccount>();
    }

    // Get functions
    public String get_username() {
        return this.username;
    }

    public String get_full_name() {
        return this.full_name;
    }

    public int get_age() {
        return this.age;
    }

    public String get_pronouns() {
        return this.pronouns;
    }

    public HashMap get_location() {
        return this.location;
    }

    public char get_gender() {
        return this.gender;
    }

    public char get_sexuality() {
        return this.sexuality;
    }

    public ArrayList<String> get_interests() {
        return this.interests;
    }

    public String get_password() {
        return this.password;
    }

    public ArrayList<OldUserAccount> get_liked_users() {
        return this.liked_users;
    }

    public ArrayList<OldUserAccount> get_blocked_users() {
        return this.blocked_users;
    }

    public ArrayList<OldUserAccount> get_liked_by_users() {
        return this.liked_users;
    }

    public ArrayList<OldUserAccount> get_blocked_by_users() {
        return this.liked_users;
    }
}