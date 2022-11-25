package interfaceAdapters;

import entities.UserDatabase;
import useCase.ViewProfileInputBoundary;
import useCase.ViewProfileInputManager;

import java.util.ArrayList;

public class ViewProfileController {

    public ViewProfileController() {}

    public ArrayList callSearchInfo(UserDatabase database, String username) {
        ViewProfileInputBoundary viewProfileInputBoundary = new ViewProfileInputManager();
        return viewProfileInputBoundary.searchInfo(database, username);
    }
}
