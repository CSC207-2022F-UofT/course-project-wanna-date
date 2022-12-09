package interface_adapters.history;

import use_case.GenerateUserHistoryInputBoundary;
import use_case.GenerateUserHistory;

import java.util.ArrayList;


public class UserHistoryController {

    public ArrayList<String> callGetUserStats(String username) {
        GenerateUserHistoryInputBoundary generateUserHistoryInputBoundary = new GenerateUserHistory();
        return generateUserHistoryInputBoundary.getUserStats(username);
    }
}