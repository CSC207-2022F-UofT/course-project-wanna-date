package useCase;

import entities.UserAccount;

public class ReceiveBlock implements ReceiveBlockInputBoundary{

    RetrieveBlock block1;

    public ReceiveBlock(RetrieveBlock block1){
        this.block1 = block1;
    }

    @Override
    public boolean block(UserAccount user1, UserAccount user2){
        user1.set_blocked_users(user2);
        user2.set_blocked_by_users(user1);
        block1.connector();
        return true;
    }


}
