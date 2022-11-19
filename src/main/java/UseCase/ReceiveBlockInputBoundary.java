package UseCase;

import Entities.UserAccount;

public interface ReceiveBlockInputBoundary {


    default boolean block(UserAccount user1, UserAccount user2){
        return false;
    }
}
