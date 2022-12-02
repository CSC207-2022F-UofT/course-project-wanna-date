package useCase;

import entities.UserAccount;

import java.util.ArrayList;
import java.util.Objects;

public class LocationFilterType implements FilterType {
    @Override
    public UserAccount[] filter() {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        String[] username = databaseManager.list_username();
        ArrayList<UserAccount> match= new ArrayList<>();
        CurrUser curr = CurrUser.getCurrUser();
        UserAccount currUser = databaseManager.retrieve_user_account(curr.getCurrUsername());
        for (String user : username) {
            UserAccount account = databaseManager.retrieve_user_account(user);
            if (Objects.equals(account.get_country(), currUser.get_country()) &
                    !Objects.equals(account.get_username(), currUser.get_username())) {
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
