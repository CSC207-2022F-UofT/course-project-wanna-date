package useCase;

import interfaceAdapters.ViewProfilePresenter;

import java.util.ArrayList;

/** This is a use case class for ViewProfile feature which returns output to user.
 */
public class ViewProfileOutputManager {

    public ViewProfileOutputManager() {}

    public ArrayList<String> connector(ArrayList<String> info) {
        ViewProfileOutputBoundary viewProfileOutputBoundary = new ViewProfilePresenter();
        return viewProfileOutputBoundary.getInfo(info);
    }
}