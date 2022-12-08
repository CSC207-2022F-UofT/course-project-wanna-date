package InterfaceAdapters;

import useCase.GenerateUserHistoryInputBoundary;
import useCase.GenerateUserHistory;

import java.util.ArrayList;


public class UserHistoryController {

    public ArrayList<String> callGetUserStats(String username) {
        GenerateUserHistoryInputBoundary generateUserHistoryInputBoundary = new GenerateUserHistory();
        return generateUserHistoryInputBoundary.getUserStats(username);
    }
}