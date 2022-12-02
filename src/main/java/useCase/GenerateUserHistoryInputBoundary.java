package useCase;

import entities.UserAccount;

public interface GenerateUserHistoryInputBoundary {

    default void getCurrentUserStats(UserAccount user) {
        /**
        CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
        UserAccount account = currUserManager.getCurrUser();
         */
    }


}
