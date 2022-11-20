package UseCase;

import Entities.UserAccount;
import Entities.UserDatabase;

import java.util.HashMap;

public class DatabaseManager {

    public void create_database(String[] database_from_csv) {
        String splitBy = ",";
        UserDatabase database = new UserDatabase();
        for (int i = 0; i < database_from_csv.length; i ++) {
            String[] data_line = database_from_csv[i].split(splitBy);    // use comma as separator
            for (int j = 0; j < data_line.length; j ++) {
                data_line[j] = data_line[i].replace("\"", "");
            }
//            System.out.println("User 1 [Name=" + data_line[0] + ", Age=" + data_line[1] + ", " + "Pronouns=" + data_line[2] + ", Gender=" + data_line[3] + ", Sexuality= " + data_line[4] + ", Interest= " + data_line[5] + ", Password:" + data_line[6] + "]");
            UserAccount curr = new UserAccount(data_line[0], data_line[1], Integer.valueOf(data_line[2]), data_line[3], data_line[4],
                    data_line[5], data_line[6], data_line[7], data_line[8], data_line[9], data_line[10]);
        }
    }

    public boolean save_user_account(UserDatabase database, String username, UserAccount account){
        HashMap<String, UserAccount> d = database.get_data();
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

    public UserAccount retrieve_user_account(UserDatabase database, String username) {
        return database.get_data().get(username);
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

    public int number_user(UserDatabase database) {
        return database.get_data().size();
    }

    public String[] list_username(UserDatabase database) {
        return database.get_data().keySet().toArray(new String[0]);
    }
}
