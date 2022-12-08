package interfaceAdapters;

import useCase.GenerateUserHistoryOutputBoundary;

import java.util.ArrayList;


public class UserHistoryPresenter implements GenerateUserHistoryOutputBoundary {
    /**
     *  Presenter for the User History. Presents the results from the GenerateUserHistory use case.
     */

    @Override
    public ArrayList<String> getUserInformation(ArrayList<String> info) {
        return info;
    }

    @Override
    public ArrayList<String> historyConnector(ArrayList<String> info) {
        GenerateUserHistoryOutputBoundary generateUserHistoryOutputBoundary = new UserHistoryPresenter();
        return generateUserHistoryOutputBoundary.getUserInformation(info);
    }
}
