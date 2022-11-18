package UseCase;

import Entities.UserAccount;

public interface ReceiveBlockInputBoundary {
//    UserAccount user_give_action = new UserAccount();
//    UserAccount user_receive_action = new UserAccount();
//
//    public default void ReceiveBlock(UserAccount user1, UserAccount user2){
//
//    }

    default boolean block(UserAccount user1, UserAccount user2){
        return false;
    }
}
