package useCase;

import entities.UserAccount;
import entities.UserDatabase;

import java.util.ArrayList;

public class ViewProfileInputManager implements ViewProfileInputBoundary {

    public ViewProfileInputManager() {}

    public ArrayList searchInfo(UserDatabase database, String username) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        UserAccount account = databaseManager.retrieve_user_account(username);

        ArrayList info = new ArrayList<>(11);
        info.add(account.get_username());
        info.add(account.get_full_name());
        info.add(account.get_age());
        info.add(account.get_pronouns());
        info.add(account.get_country());
        info.add(account.get_province());
        info.add(account.get_city());
        info.add(account.get_gender());
        info.add(account.get_sexuality());
        info.add(account.get_interests());
        info.add(account.get_password());

        ViewProfileOutputManager viewProfileOutputManager = new ViewProfileOutputManager();
        return viewProfileOutputManager.connector(info);
    }
}
