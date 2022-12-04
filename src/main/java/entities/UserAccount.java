package entities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An Entity class representing a single user in the application
 * Contains this user's variables
 */
public class UserAccount {

    // === Class Variables ===

    // The username of user that is unique in the application.
    private final String username;

    // The real name of user.
    private final String fullName;

    // The age of user.
    private final int age;

    // The pronouns identified by user.
    private final String pronouns;

    // The location where user lives.
    // Consists of three keys, each mapped to their own values:
    // country, province, and city.
    private final HashMap<String, String> location;

    // The gender identified by user.
    // 'M': male
    // 'F': female
    // 'N': non-binary
    private final String gender;

    // The sexuality identified by user.
    // 'G': gay
    // 'L': lesbian
    // 'H': heterosexual
    // 'B': bisexual
    private final String sexuality;

    // The list of interests by user.
    // They can only name one interest most suitable to them from this list:
    // - Culinary
    // - Sports
    // - Watching
    // - Photography
    // - Travelling
    // - Fashion
    // - Music
    // - Exercise
    // - Games
    // - Socializing
    // - Others
    private final String interest;

    // The password of user's account.
    private final String password;

    // The list of usernames that this user liked.
    private ArrayList<UserAccount> likedUsers;

    // The list of users who liked this user
    private ArrayList<UserAccount> likedByUsers;

    // The list of usernames that this user blocked.
    private ArrayList<UserAccount> blockedUsers;

    // The list of users who blocked this user
    private ArrayList<UserAccount> blockedByUsers;

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
        this.fullName = full_name;
        this.age = age;
        this.pronouns = pronouns;
        HashMap<String, String> location = new HashMap<>(3);
        location.put("country", country);
        location.put("province", province);
        location.put("city", city);
        this.location = location;
        this.gender = gender;
        this.sexuality = sexuality;
        this.interest = interest;
        this.password = password;
        this.likedUsers = new ArrayList<>();
        this.likedByUsers = new ArrayList<>();
        this.blockedUsers = new ArrayList<>();
        this.blockedByUsers = new ArrayList<>();
    }

    /** Get functions for UserAccount variables
     * */
    public String getUsername() {
        return this.username;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getAge() {
        return this.age;
    }

    public String getPronouns() {
        return this.pronouns;
    }

    public HashMap<String, String> getLocation() { return this.location; }

    public String getCountry() { return this.location.get("country"); }

    public String getProvince() { return this.location.get("province"); }

    public String getCity() { return this.location.get("city"); }

    public String getGender() {
        return this.gender;
    }

    public String getSexuality() {
        return this.sexuality;
    }

    public String getInterest() {
        return this.interest;
    }

    public String getPassword() {
        return this.password;
    }

    public ArrayList<UserAccount> getLikedUsers() {
        return this.likedUsers;
    }

    public ArrayList<UserAccount> getLikedByUsers() {
        return this.likedByUsers;
    }

    public ArrayList<UserAccount> getBlockedUsers() {
        return this.blockedUsers;
    }

    public ArrayList<UserAccount> getBlockedByUsers() {
        return this.blockedByUsers;
    }

    /** Set functions for UserAccount variables that consist of UserAccount objects
     *  as these are the variables that can be changed or modify once the user registers
     * */
    public void setLikedUsers(UserAccount user){
        likedUsers.add(user);
    }

    public void setLikedByUsers(UserAccount user) {
        likedByUsers.add(user);
    }

    public void setBlockedUsers(UserAccount user){
        blockedUsers.add(user);
    }

    public void setBlockedByUsers(UserAccount user) {
        blockedByUsers.add(user);
    }
}
