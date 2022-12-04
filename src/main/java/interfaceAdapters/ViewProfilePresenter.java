package interfaceAdapters;

import useCase.ViewProfileOutputBoundary;

import java.util.ArrayList;

/** A Presenter class that presents the ViewProfile feature.
 * This class is called when the application has to view a user's profile page.
 * */
public class ViewProfilePresenter implements ViewProfileOutputBoundary {

    public ViewProfilePresenter() {}

    /** Function that returns the user's information in the form of an ArrayList<String>
     * */
    @Override
    public ArrayList<String> getInfo(ArrayList<String> info) {
        return info;
    }
}
