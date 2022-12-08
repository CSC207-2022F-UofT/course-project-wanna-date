package interfaceAdapters;

import useCase.ViewProfileOutputBoundary;

import java.util.ArrayList;

/** A Presenter class that presents the ViewProfile feature.
 * This class is called when the application has to view a user's profile page.
 * */
public class ViewProfilePresenter implements ViewProfileOutputBoundary {

    // === Class Variables ===

    // Represents the interface for the UI ViewProfilePage class
    ViewProfileInterface viewProfileInterface;

    public ViewProfilePresenter(ViewProfileInterface viewProfileInterface) {
        this.viewProfileInterface = viewProfileInterface;
    }

    /** Function that returns the user's information in the form of an ArrayList<String> to the ViewProfilePage class
     * via the ViewProfileInterface interface.
     * */
    @Override
    public void getInfo(ArrayList<String> info) {
        viewProfileInterface.retrieveInfo(info);
    }
}
