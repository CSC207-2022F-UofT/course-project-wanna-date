package useCase;

import entities.UserAccount;

import java.util.ArrayList;

/** This is a use case class for ViewProfile feature which receives input from user.
 */
public class ViewProfileInputManager implements ViewProfileInputBoundary {

    public ViewProfileInputManager() {}

    /** Function that returns an ArrayList<String> consisting of variables of the user corresponding
     * to the username in the parameter.
     *
     * @param username  represents the username of the user.
     * */
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
