package use_case.filter;

import entities.account.UserAccount;
import use_case.account.DatabaseManager;

import java.util.ArrayList;
import java.util.Objects;

public class SexFilterFemaleType implements FilterType {
    @Override
    public UserAccount[] filter() {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        String[] username = databaseManager.listUsername();
        ArrayList<UserAccount> match= new ArrayList<>();
        for (String user : username) {
            UserAccount account = databaseManager.retrieveUserAccount(user);
            //find the female account and add to match.
            if (Objects.equals(account.getGender(), "F")) {
                match.add(account);
            }
        }
        int size = match.size();
        return match.toArray(new UserAccount[size]);
    }
}
