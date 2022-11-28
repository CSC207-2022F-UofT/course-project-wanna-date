package UseCase;

import Entities.UserAccount;

public interface ChatBoxOB {
    default boolean chatBoxPresenter(UserAccount user1, UserAccount user2){
        return false;
    }
}
