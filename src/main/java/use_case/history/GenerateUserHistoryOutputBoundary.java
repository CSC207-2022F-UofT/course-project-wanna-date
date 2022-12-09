package use_case.history;

import java.util.ArrayList;


public interface GenerateUserHistoryOutputBoundary {
    /**
     * GenerateUserHistory Output Boundary.
     */
    ArrayList<String> getUserInformation(ArrayList<String> info);

    ArrayList<String> historyConnector(ArrayList<String> info);
}