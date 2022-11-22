package UseCase;

import Entities.UserAccount;

import java.util.ArrayList;
import java.util.Objects;

public class LocationFilterType implements FilterType {
    @Override
    public UserAccount[] filter() {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        String[] username = databaseManager.list_username();
        ArrayList<UserAccount> match= new ArrayList<>();
        LoginManager loginManager = new LoginManager();
        UserAccount currUser = loginManager.getCurrUser();
        for (String user : username) {
            UserAccount account = databaseManager.retrieve_user_account(user);
            if (Objects.equals(account.get_country(), currUser.get_country())) {
                if (Objects.equals(account.get_province(), currUser.get_province())) {
                    if (Objects.equals(account.get_city(), currUser.get_city())){
                        match.add(0, account);
                    } else match.add(account);
                }
            }
        }
        int size = match.size();
        return match.toArray(new UserAccount[size]);
    }
}
