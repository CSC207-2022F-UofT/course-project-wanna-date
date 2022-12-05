package useCase;

import entities.UserAccount;

import java.util.ArrayList;

public class ViewProfileInputManager implements ViewProfileInputBoundary {

    public ViewProfileInputManager() {}

    @Override
    public ArrayList<String> searchInfo(String username) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        UserAccount account = databaseManager.retrieveUserAccount(username);

        ArrayList<String> info = new ArrayList<>(11);
        info.add(account.getUsername());
        info.add(account.getFullName());
        int age = account.getAge();
        info.add(Integer.toString(age));
        info.add(account.getPronouns());
        info.add(account.getCountry());
        info.add(account.getProvince());
        info.add(account.getCity());
        info.add(account.getGender());
        info.add(account.getSexuality());
        info.add(account.getInterest());
        info.add(account.getPassword());

        ViewProfileOutputManager viewProfileOutputManager = new ViewProfileOutputManager();
        return viewProfileOutputManager.connector(info);
    }

    @Override
    public UserAccount searchUserAccount(String username) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        return databaseManager.retrieveUserAccount(username);
    }
}
