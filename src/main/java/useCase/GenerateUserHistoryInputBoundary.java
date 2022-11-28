package UseCase;

import Entities.UserHistory;

public interface GenerateUserHistoryInputBoundary {

    default String userStats(UserHistory user) {
        return null;
    }

}
