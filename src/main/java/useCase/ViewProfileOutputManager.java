package useCase;

import interfaceAdapters.ViewProfilePresenter;

import java.util.ArrayList;

public class ViewProfileOutputManager {

    public ViewProfileOutputManager() {}

    public ArrayList<String> connector(ArrayList<String> info) {
        ViewProfileOutputBoundary viewProfileOutputBoundary = new ViewProfilePresenter();
        return viewProfileOutputBoundary.getInfo(info);
    }
}