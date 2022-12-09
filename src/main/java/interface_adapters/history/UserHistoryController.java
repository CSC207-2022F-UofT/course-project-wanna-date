package interface_adapters.history;

import use_case.history.GenerateUserHistoryInputBoundary;
import use_case.history.GenerateUserHistory;

import java.util.ArrayList;


public class UserHistoryController {

    public ArrayList<String> callGetUserStats(String username) {
        GenerateUserHistoryInputBoundary generateUserHistoryInputBoundary = new GenerateUserHistory();
        return generateUserHistoryInputBoundary.getUserStats(username);
    }
}