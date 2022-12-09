package use_case.account;

import entities.UserAccount;

import java.util.ArrayList;

/** This is a use case class for ViewProfile feature which receives input from user.
 */
public class ViewProfileInputManager implements ViewProfileInputBoundary {

    public ViewProfileInputManager() {}

    /** Function that searches the user's variables from database and passed down this information to the Presenter via
     * the ViewProfileOutputBoundary interface.
     * This function returns an ArrayList of the user's variables for the purpose of testing this class.
     *
     * @param username                  represents the username of the user.
     * @param viewProfileOutputBoundary represents the Presenter class that will update the ViewProfilePage UI.
     * */
    @Override
    public ArrayList<String> searchInfo(String username, ViewProfileOutputBoundary viewProfileOutputBoundary) {
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

        viewProfileOutputBoundary.getInfo(info);

        return info;
    }

    @Override
    public UserAccount searchUserAccount(String username) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        return databaseManager.retrieveUserAccount(username);
    }
}
