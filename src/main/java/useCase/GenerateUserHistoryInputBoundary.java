package useCase;

import entities.UserAccount;


public interface GenerateUserHistoryInputBoundary {

    default String getCurrentUserStats(UserAccount user, String stat) {
        /**
        CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
        UserAccount account = currUserManager.getCurrUser();
        */

        return stat;
    }
}
