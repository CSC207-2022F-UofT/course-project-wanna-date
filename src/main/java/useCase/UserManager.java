package useCase;

import entities.UserAccount;

import java.util.ArrayList;

/** This is a use case class for UserAccount object to manage the variables in UserAccount object
 * that need modification before being used in other use cases.
 */
public class UserManager {

    // === Class Variables ===

    // Represents the UserAccount object that is being modified
    private final UserAccount account;

    public UserManager(UserAccount account) {
        this.account = account;
    }

    /** Returns the list of usernames from UserAccount variables that consist of UserAccount objects
     *  for the purpose of storing these variables in CSV File:
     *  - liked_users
     *  - liked_by_users
     *  - blocked_users
     *  - blocked_by_users
     */
    public ArrayList<String> getLikedUsernames() {
        ArrayList<String> liked_usernames = new ArrayList<>();
        for (UserAccount liked_account: this.account.getLikedUsers()) {
            liked_usernames.add(liked_account.getUsername());
        }
        return liked_usernames;
    }

    public ArrayList<String> getLikedByUsernames() {
        ArrayList<String> liked_by_usernames = new ArrayList<>();
        for (UserAccount liked_by_account: this.account.getLikedByUsers()) {
            liked_by_usernames.add(liked_by_account.getUsername());
        }
        return liked_by_usernames;
    }

    public ArrayList<String> getBlockedUsernames() {
        ArrayList<String> blocked_usernames = new ArrayList<>();
        for (UserAccount blocked_account: this.account.getBlockedUsers()) {
            blocked_usernames.add(blocked_account.getUsername());
        }
        return blocked_usernames;
    }

    public ArrayList<String> getBlockedByUsernames() {
        ArrayList<String> blocked_by_usernames = new ArrayList<>();
        for (UserAccount blocked_by_account: this.account.getBlockedByUsers()) {
            blocked_by_usernames.add(blocked_by_account.getUsername());
        }
        return blocked_by_usernames;
    }
}
