package use_case.history;

import java.util.ArrayList;


public interface GenerateUserHistoryInputBoundary {
    ArrayList<String> getUserStats(String username);
}