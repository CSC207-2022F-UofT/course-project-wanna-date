package UseCase;

import Entities.UserAccount;
import Entities.UserDatabase;
import FrameworksDrivers.DataAccess;
import FrameworksDrivers.DataExportInterface;

import java.util.Arrays;
import java.util.HashMap;

public class DatabaseManager implements DataExportInterface {

    private static DatabaseManager databaseManager;
    private UserDatabase database;
//    private static String[] dataFromCSV;

    public DatabaseManager() {
        // Note from Arist: I had to make this public so the code compiles
    }

    public static DatabaseManager getDatabaseManager() {
        if (databaseManager == null)
            databaseManager = new DatabaseManager();
        return databaseManager;
    }

//    public static String[] getDataCSV() {
//        dataFromCSV
//    }

    public UserDatabase createDatabase(String[] dataFromCSV) {
        String splitBy = ",";
        UserDatabase database = new UserDatabase();
        for (int i = 0; i < dataFromCSV.length; i++) {
            String[] data_line = dataFromCSV[i].split(splitBy);    // use comma as separator
            for (int j = 0; j < data_line.length; j++) {
                data_line[j] = data_line[j].replace("\"", "");
            }
            UserAccount curr = new UserAccount(data_line[0], data_line[1], Integer.valueOf(data_line[2]), data_line[3], data_line[4],
                    data_line[5], data_line[6], data_line[7], data_line[8], data_line[9], data_line[10]);
            database.get_data().put(data_line[0], curr);
        }
        this.database = database;
        return database;
    }

    public UserDatabase getDatabase() {
        return this.database;
    }

    public boolean saveNewUser(String username, UserAccount account) {
        HashMap<String, UserAccount> d = this.database.get_data();
        if (d.isEmpty()) {
            d.put(username, account);
            return true;
        } else {
            if (d.containsKey(username)) {
                return false;
            } else {
                d.put(username, account);
                return true;
            }
        }
    }

    public UserAccount retrieve_user_account(String username) {
        return this.database.get_data().get(username);
    }

    public boolean is_pair_exist(UserDatabase database, String username, String password) {
        if (database.get_data().containsKey(username)) {
            if (database.get_data().get(username).equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isUsernameExist(String username) {
        if (this.database.get_data().containsKey(username)) {
            return true;
        }
        return false;
    }

    public int number_user() {
        return this.database.get_data().size();
    }

    public String[] list_username() {
        return this.database.get_data().keySet().toArray(new String[0]);
    }

    public Object[][] writeDatabase() {
        Object[][] userProfile = {{}};
        String[] usernames = list_username();
        for (int i = 0; i < number_user(); i++) {
            UserAccount user = retrieve_user_account(usernames[i]);
            Object[] userProfileEach = new Object[]{user.get_username(),
                                                    user.get_full_name(),
                                                    user.get_age(),
                                                    user.get_pronouns(),
                                                    user.get_location().get("Country"),
                                                    user.get_location().get("Province"),
                                                    user.get_location().get("City"),
                                                    user.get_gender(),
                                                    user.get_sexuality(),
                                                    user.get_interests(),
                                                    user.get_password()};
            userProfile = Arrays.copyOf(userProfile, userProfile.length + 1);
            userProfile[userProfile.length - 1] = userProfileEach;
        }
        return userProfile;
    }
}
//
//    private String[] dataFromCSV;
//
//    public DatabaseManager() {
//        DataAccessInterface dataAccessInterface = new DataAccess();
//        this.dataFromCSV = dataAccessInterface.read_csv();
//    }
//
//    public UserDatabase createDatabase() {
//        String splitBy = ",";
//        UserDatabase database = new UserDatabase();
//        for (int i = 0; i < this.dataFromCSV.length; i ++) {
//            String[] data_line = this.dataFromCSV[i].split(splitBy);    // use comma as separator
//            for (int j = 0; j < data_line.length; j ++) {
//                data_line[j] = data_line[i].replace("\"", "");
//            }
//            UserAccount curr = new UserAccount(data_line[0], data_line[1], Integer.valueOf(data_line[2]), data_line[3], data_line[4],
//                    data_line[5], data_line[6], data_line[7], data_line[8], data_line[9], data_line[10]);
//            database.get_data().put(data_line[0], curr);
//        }
//        return database;
//    }
//
//    public boolean saveNewUser(UserDatabase database, String username, UserAccount account){
//        HashMap<String, UserAccount> d = database.get_data();
//        if (d.isEmpty()) {
//            d.put(username, account);
//            return true;
//        } else {
//            if (d.containsKey(username)) {
//                return false;
//            } else {
//                d.put(username, account);
//                return true;
//            }
//        }
//    }
//
//    public UserAccount retrieve_user_account(UserDatabase database, String username) {
//        return database.get_data().get(username);
//    }
//
//    public boolean is_pair_exist(UserDatabase database, String username, String password) {
//        if (database.get_data().containsKey(username)) {
//            if (database.get_data().get(username).equals(password)) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }
//
//    public boolean isUsernameExist(UserDatabase database, String username) {
//        if (database.get_data().containsKey(username)) {
//            return true;
//        } return false;
//    }
//
//    public int number_user(UserDatabase database) {
//        return database.get_data().size();
//    }
//
//    public String[] list_username(UserDatabase database) {
//        return database.get_data().keySet().toArray(new String[0]);
//    }
