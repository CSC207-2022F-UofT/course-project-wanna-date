package UseCase;

import InterfaceAdapters.ViewProfilePresenter;

import java.util.ArrayList;

public class ViewProfileOutputManager {

    public ViewProfileOutputManager() {}

//    public ArrayList get_info(ViewProfileOutputBoundary viewProfileOutputBoundary, ArrayList info) {
//        return viewProfileOutputBoundary.getInfo(info);
//    }

    public ArrayList connector(ArrayList info) {
        ViewProfileOutputBoundary viewProfileOutputBoundary = new ViewProfilePresenter();
        return viewProfileOutputBoundary.getInfo(info);
    }

}
