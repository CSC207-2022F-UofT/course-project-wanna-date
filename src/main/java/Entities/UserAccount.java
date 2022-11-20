package Entities;

import java.util.ArrayList;
import java.util.HashMap;

public class UserAccount {
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
    private String gender;

    // The sexuality identified by user.
    // 'G': gay
    // 'L': lesbian
    // 'H': heterosexual
    // 'B': bisexual
    private String sexuality;

    // The list of interests by user.
    private String interest;

    // The password of user's account.
    private String password;

    // The list of usernames that this user liked.
    private ArrayList<UserAccount> liked_users;

    // The list of users who liked this user
    private ArrayList<UserAccount> liked_by_users;

    // The list of usernames that this user blocked.
    private ArrayList<UserAccount> blocked_users;

    // The list of users who blocked this user
    private ArrayList<UserAccount> blocked_by_users;

    public UserAccount(String username,
                       String full_name,
                       int age,
                       String pronouns,
                       String country, String province, String city,
                       String gender,
                       String sexuality,
                       String interest,
                       String password) {
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
        this.interest = interest;
        this.password = password;
        ArrayList<UserAccount> liked_users = new ArrayList<UserAccount>();
        ArrayList<UserAccount> liked_by_users = new ArrayList<UserAccount>();
        ArrayList<UserAccount> blocked_users = new ArrayList<UserAccount>();
        ArrayList<UserAccount> blocked_by_users = new ArrayList<UserAccount>();
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

    public String get_gender() {
        return this.gender;
    }

    public String get_sexuality() {
        return this.sexuality;
    }

    public String get_interests() {
        return this.interest;
    }

    public String get_password() {
        return this.password;
    }

    public ArrayList<UserAccount> get_liked_users() {
        return this.liked_users;
    }

    public void set_liked_users(UserAccount user){
        liked_users.add(user);
    }

    public ArrayList<UserAccount> get_blocked_users() {
        return this.blocked_users;
    }

    public void set_blocked_users(UserAccount user){
        blocked_users.add(user);
    }

    public ArrayList<UserAccount> get_liked_by_users() {
        return this.liked_by_users;
    }

    public void set_liked_by_users(UserAccount user){
        liked_by_users.add(user);
    }

    public ArrayList<UserAccount> get_blocked_by_users() {
        return this.blocked_by_users;
    }

    public void set_blocked_by_users(UserAccount user) {
        blocked_by_users.add(user);
    }
}
