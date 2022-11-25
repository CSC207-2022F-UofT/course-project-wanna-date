package interfaceAdapters;

import entities.UserHistory;
import useCase.GenerateUserHistoryInputBoundary;

public class UserHistoryController implements GenerateUserHistoryInputBoundary{

    public String getUserHistory(GenerateUserHistoryInputBoundary input, UserHistory user,
                                 UserHistoryPresenter presenter) {
        String stats = input.userStats(user);
        return presenter.presenterUserHistory();
    }
}
