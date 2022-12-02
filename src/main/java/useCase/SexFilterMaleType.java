package useCase;

import entities.UserAccount;

import java.util.ArrayList;
import java.util.Objects;

public class SexFilterMaleType implements FilterType {
    @Override
    public UserAccount[] filter() {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        String[] username = databaseManager.list_username();
        ArrayList<UserAccount> match= new ArrayList<>();
        for (String user : username) {
            UserAccount account = databaseManager.retrieve_user_account(user);
            if (Objects.equals(account.getGender(), "M")) {
                match.add(account);
            }
        }
        int size = match.size();
        return match.toArray(new UserAccount[size]);
    }
}
