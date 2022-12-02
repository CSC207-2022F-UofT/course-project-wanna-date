package interfaceAdapters;

import entities.UserAccount;
import useCase.GenerateUserHistoryInputBoundary;

public class UserHistoryController implements GenerateUserHistoryInputBoundary{

    /**
    public String getUserHistory(GenerateUserHistoryInputBoundary input, UserAccount user,
                                 UserHistoryPresenter presenter) {
        String stats = input.userStats(user);
        return presenter.presenterUserHistory();
    }
     */
}
