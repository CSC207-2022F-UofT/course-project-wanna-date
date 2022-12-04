package interfaceAdapters;

import useCase.ViewProfileOutputBoundary;

import java.util.ArrayList;

public class ViewProfilePresenter implements ViewProfileOutputBoundary {

    public ViewProfilePresenter() {}

    @Override
    public ArrayList<String> getInfo(ArrayList<String> info) {
        return info;
    }
}
