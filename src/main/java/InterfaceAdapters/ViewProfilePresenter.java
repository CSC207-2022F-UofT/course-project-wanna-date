package InterfaceAdapters;

import UseCase.ViewProfileOutputBoundary;

import java.util.ArrayList;

public class ViewProfilePresenter implements ViewProfileOutputBoundary {

    public ViewProfilePresenter() {}

    public ArrayList getInfo(ArrayList info) {
        return info;
    }
}
