package InterfaceAdapters;

import Entities.UserHistory;
import UseCase.GenerateUserHistoryInputBoundary;

public class UserHistoryController implements GenerateUserHistoryInputBoundary{

    public String getUserHistory(GenerateUserHistoryInputBoundary input, UserHistory user,
                                 UserHistoryPresenter presenter) {
        String stats = input.userStats(user);
        return presenter.presenterUserHistory();
    }
}
