package interface_adapters.account;

import entities.account.UserAccount;
import use_case.account.ViewProfileInputBoundary;
import use_case.account.ViewProfileInputManager;
import use_case.account.ViewProfileOutputBoundary;

/** A Controller class that controls the ViewProfile feature.
 * This class is called when the application has to view a user's profile page.
 * */
public class ViewProfileController {

    public ViewProfileController() {}

    /** Function that calls the searchInfo function in the useCase ViewProfileInputManager class
     * while creating a Presenter object that will modify the ViewProfilePage UI.
     *
     * @param username              represents the username of the user.
     * @param viewProfileInterface  represents the UI ViewProfilePage class that will be modified.
     * */
    public void callSearchInfo(String username, ViewProfileInterface viewProfileInterface) {
        ViewProfileOutputBoundary viewProfileOutputBoundary = new ViewProfilePresenter(viewProfileInterface);

        ViewProfileInputBoundary viewProfileInputBoundary = new ViewProfileInputManager();
        viewProfileInputBoundary.searchInfo(username, viewProfileOutputBoundary);
    }

    public UserAccount callSearchUser(String username){
        ViewProfileInputBoundary viewProfileInputBoundary = new ViewProfileInputManager();
        return viewProfileInputBoundary.searchUserAccount(username);
    }
}
