package useCase;

import entities.UserHistory;

public interface GenerateUserHistoryInputBoundary {

    default String userStats(UserHistory user) {
        return null;
    }

}
