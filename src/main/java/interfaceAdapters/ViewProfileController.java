package interfaceAdapters;

import entities.UserAccount;
import useCase.ViewProfileInputBoundary;
import useCase.ViewProfileInputManager;

import java.util.ArrayList;

/** A Controller class that controls the ViewProfile feature.
 * This class is called when the application has to view a user's profile page.
 * */
public class ViewProfileController {

    public ViewProfileController() {}

    /** Function that calls the searchInfo function in the useCase ViewProfileInputManager class.
     *
     * @param username  represents the username of the user.
     * */
    public ArrayList<String> callSearchInfo(String username) {
        ViewProfileInputBoundary viewProfileInputBoundary = new ViewProfileInputManager();
        return viewProfileInputBoundary.searchInfo(username);
    }

    public UserAccount callSearchUser(String username){
        ViewProfileInputBoundary viewProfileInputBoundary = new ViewProfileInputManager();
        return viewProfileInputBoundary.searchUserAccount(username);
    }

}
