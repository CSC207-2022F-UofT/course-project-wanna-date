package useCase;

import java.util.ArrayList;

public class ViewProfilePresenter2 implements ViewProfileOutputBoundary2{

    @Override
    public ArrayList<String> searchInfo(String username) {
        ViewProfileOutputManager2 viewProfileOutputManager2 = new ViewProfileOutputManager2();
        return viewProfileOutputManager2.helpSearchInfo(username);

        // How do we return the ArrayList if the class that is implementing the interface is Presenter
        // not the UseCase? and even more if the ArrayList is made by interacting with Entities class?

//        ViewProfileInputBoundary viewProfileInputBoundary = new ViewProfileInputManager();
//        return viewProfileInputBoundary.searchInfo(username);
    }
}
