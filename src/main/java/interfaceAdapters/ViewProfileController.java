package interfaceAdapters;

import entities.UserAccount;
import useCase.ViewProfileInputBoundary;
import useCase.ViewProfileInputManager;

import java.util.ArrayList;

public class ViewProfileController {

    public ViewProfileController() {}

    public ArrayList<String> callSearchInfo(String username) {
        ViewProfileInputBoundary viewProfileInputBoundary = new ViewProfileInputManager();
        return viewProfileInputBoundary.searchInfo(username);
    }

    public UserAccount callSearchUser(String username){
        ViewProfileInputBoundary viewProfileInputBoundary = new ViewProfileInputManager();
        return viewProfileInputBoundary.searchUserAccount(username);
    }

}
