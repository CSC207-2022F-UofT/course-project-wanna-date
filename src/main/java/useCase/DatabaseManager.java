package useCase;

import entities.UserAccount;
import entities.UserDatabase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/** A useCase singleton Class that stores and manages the Database.
 * */
public class DatabaseManager implements DataExportInterface {

    // === Class variables ===

    // The static variable representing this very own class.
    private static DatabaseManager databaseManager;

    // The variable representing the database in the application.
    private UserDatabase database;

    /** Private constructor function so this class cannot be instantiated outside this class.
     * */
    private DatabaseManager() {
    }

    public static DatabaseManager getDatabaseManager() {
        if (databaseManager == null)
            databaseManager = new DatabaseManager();
        return databaseManager;
    }

    /** Function that is used to create Database based on input from CSV File.
     *
     * @param dataFromCSV   represents the data read from CSV File in the form of String[],
     *                      with each value is a String representing each user's information.
     * */
    public void createDatabase(String[] dataFromCSV) {
        String splitBy = ",";
        UserDatabase database = new UserDatabase();
        HashMap<String, String[][]> userAccountVariablesData = new HashMap<>();

        for (String data_each_user: dataFromCSV) {
            String[] data_line = data_each_user.split(splitBy);
            for (int j = 0; j < data_line.length; j++) {
                data_line[j] = data_line[j].replace("\"", "");
            }

            // Storing the UserAccount basic variables and insert it to Database
            UserAccount curr = new UserAccount(data_line[0], data_line[1], Integer.valueOf(data_line[2]),
                    data_line[3], data_line[4], data_line[5], data_line[6], data_line[7], data_line[8],
                    data_line[9], data_line[10]);
            database.getData().put(data_line[0], curr);

            // Storing the UserAccount variables liked_users, liked_by_users, blocked_users, blocked_by_users
            String[] liked_usernames_list;
            String[] liked_by_usernames_list;
            String[] blocked_usernames_list;
            String[] blocked_by_usernames_list;

            if (data_line[11].equals("[]")) {
                liked_usernames_list = new String[0];
            } else {
                liked_usernames_list = data_line[11].substring(1, data_line[11].length() - 1).split("; ");
            }

            if (data_line[12].equals("[]")) {
                liked_by_usernames_list = new String[0];
            } else {
                liked_by_usernames_list = data_line[12].substring(1, data_line[12].length() - 1).split("; ");
            }

            if (data_line[13].equals("[]")) {
                blocked_usernames_list = new String[0];
            } else {
                blocked_usernames_list = data_line[13].substring(1, data_line[13].length() - 1).split("; ");
            }

            if (data_line[14].equals("[]")) {
                blocked_by_usernames_list = new String[0];
            } else {
                blocked_by_usernames_list = data_line[14].substring(1, data_line[14].length() - 1).split("; ");
            }

            String[][] userAccountVariables = {liked_usernames_list, liked_by_usernames_list,
                    blocked_usernames_list, blocked_by_usernames_list};
            userAccountVariablesData.put(data_line[0], userAccountVariables);
        }
        this.database = database;
        setUserAccountVariables(userAccountVariablesData);
    }

    /** Function that helps the function createDatabase.
     * Storing the variables liked_users, liked_by_users, blocked_users, blocked_by_users in a different way
     * because these variables can only be updated after all UserAccount objects for every user had been made.
     *
     * @param userAccountVariablesData  represents the list of data read from CSV in the form of HashMap<String,
     *                                  String[][]>, where the key is the username and the value is the four variables
     *                                  (each is a String[]) stored in an outer String[] for each user.
     * */
    public void setUserAccountVariables(HashMap<String, String[][]> userAccountVariablesData) {
        Set<String> usernames_list = userAccountVariablesData.keySet();
        for (String username: usernames_list) {
            UserAccount user = retrieveUserAccount(username);
            String[][] userAccountVariables = userAccountVariablesData.get(username);
            setLikedUsers(user, userAccountVariables[0]);
            setLikedByUsers(user, userAccountVariables[1]);
            setBlockedUsers(user, userAccountVariables[2]);
            setBlockedByUsers(user, userAccountVariables[3]);
        }
    }

    public void setLikedUsers(UserAccount user, String[] liked_users_list) {
        if (liked_users_list != null && liked_users_list.length > 0) {
            for (String liked_users : liked_users_list) {
                UserAccount likedUser = retrieveUserAccount(liked_users);
                user.setLikedUsers(likedUser);
            }
        }
    }

    public void setLikedByUsers(UserAccount user, String[] liked_by_users_list) {
        if (liked_by_users_list != null && liked_by_users_list.length > 0) {
            for (String liked_by_users : liked_by_users_list) {
                UserAccount likedByUser = retrieveUserAccount(liked_by_users);
                user.setLikedByUsers(likedByUser);
            }
        }
    }

    public void setBlockedUsers(UserAccount user, String[] blocked_users_list) {
        if (blocked_users_list != null && blocked_users_list.length > 0) {
            for (String blocked_users : blocked_users_list) {
                UserAccount blockedUser = retrieveUserAccount(blocked_users);
                user.setBlockedUsers(blockedUser);
            }
        }
    }

    public void setBlockedByUsers(UserAccount user, String[] blocked_by_users_list) {
        if (blocked_by_users_list != null && blocked_by_users_list.length > 0) {
            for (String blocked_by_users : blocked_by_users_list) {
                UserAccount blockedByUser = retrieveUserAccount(blocked_by_users);
                user.setBlockedByUsers(blockedByUser);
            }
        }
    }

    /** Function that returns the Database which is stored as this class' instance variable.
     * */
    public UserDatabase getDatabase() {
        return this.database;
    }

    /** Function that saves new user to the Database.
     *
     * @param username  represents the username of new user.
     * @param account   represents the UserAccount object of new user.
     * */
    public void saveNewUser(String username, UserAccount account) {
        HashMap<String, UserAccount> d = this.database.getData();
        d.put(username, account);
    }

    /** Function that returns the UserAccount object to the username in the parameter.
     *
     * @param username  represents the username of a user.
     * */
    public UserAccount retrieveUserAccount(String username) {
        return this.database.getData().get(username);
    }

    /** Function that returns a boolean value of whether the username exists in the Database or not.
     *
     * @param username  represents the username of the user.
     * */
    public boolean isUsernameExist(String username) {
        return this.database.getData().containsKey(username);
    }

    /** Function that returns a boolean value of whether the username and password pair exists in the Database or not.
     *
     * @param username  represents the username of the user.
     * @param password  represents the password of the user.
     * */
    public boolean isPairExist(String username, String password) {
        if (isUsernameExist(username)) {
            UserAccount account = retrieveUserAccount(username);
            return account.getPassword().equals(password);
        } else {
            return false;
        }
    }

    /** Function that returns an integer representing the number of users in the Database.
     * */
    public int numberUser() {
        return this.database.getData().size();
    }

    /** Function that returns a String[] representing the list of usernames of all users in the Database.
     * */
    public String[] listUsername() {
        return this.database.getData().keySet().toArray(new String[0]);
    }

    /** Function that returns an Object[][] from the Database in order to be written to an outer CSV File.
     * */
    @Override
    public Object[][] writeDatabase() {
        Object[][] userProfile = {{}};
        String[] usernames = listUsername();
        for (int i = 0; i < numberUser(); i++) {
            UserAccount user = retrieveUserAccount(usernames[i]);
            UserManager userManager = new UserManager(user);
            Object[] userProfileEach = new Object[]{
                    user.getUsername(),
                    user.getFullName(),
                    user.getAge(),
                    user.getPronouns(),
                    user.getLocation().get("country"),
                    user.getLocation().get("province"),
                    user.getLocation().get("city"),
                    user.getGender(),
                    user.getSexuality(),
                    user.getInterest(),
                    user.getPassword(),
                    userManager.getLikedUsernames().toString().replaceAll(",", ";"),
                    userManager.getLikedByUsernames().toString().replaceAll(",", ";"),
                    userManager.getBlockedUsernames().toString().replaceAll(",", ";"),
                    userManager.getBlockedByUsernames().toString().replaceAll(",", ";")
            };
            userProfile = Arrays.copyOf(userProfile, userProfile.length + 1);
            userProfile[userProfile.length - 1] = userProfileEach;
        }
        return userProfile;
    }
}
