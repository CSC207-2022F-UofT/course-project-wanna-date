package UseCase;

import Entities.UserAccount;

public class ReceiveBlock implements ReceiveBlockInputBoundary{
    UserAccount user_give_action;
    UserAccount user_receive_action;

    @Override
    public void ReceiveBlock(UserAccount user1, UserAccount user2){
        this.user_give_action = user1;
        this.user_receive_action = user2;
    }

    @Override
    public void Block(UserAccount user1, UserAccount user2){

    }
}
