package use_case.filter;

import entities.UserAccount;

import java.util.ArrayList;
import java.util.Objects;

public class LocationFilterType implements FilterType {
    @Override
    public UserAccount[] filter() {
        // Create database and get info from the current user
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        String[] username = databaseManager.listUsername();
        ArrayList<UserAccount> match= new ArrayList<>();
        CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
        UserAccount currUser = currUserManager.getCurrUser();
        // Check the location of every user in the database, only store people who
        // in the same province or same city with the current user (same city first)
        for (String user : username) {
            UserAccount account = databaseManager.retrieveUserAccount(user);
            if (Objects.equals(account.getCountry(), currUser.getCountry()) &
                    !Objects.equals(account.getUsername(), currUser.getUsername())) {
                if (Objects.equals(account.getProvince(), currUser.getProvince())) {
                    if (Objects.equals(account.getCity(), currUser.getCity())){
                        match.add(0, account);
                    } else match.add(account);
                }
            }
        }
        int size = match.size();
        return match.toArray(new UserAccount[size]);
    }
}
