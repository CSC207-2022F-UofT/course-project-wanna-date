package UseCase;

import Entities.UserAccount;

public interface ReceiveBlockInputBoundary {
    UserAccount user_give_action = new UserAccount();
    UserAccount user_receive_action = new UserAccount();

    public default void ReceiveBlock(UserAccount user1, UserAccount user2){

    }

    public default void Block(UserAccount user1, UserAccount user2){

    }
}
