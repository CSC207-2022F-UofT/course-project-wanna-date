package UseCase;

import Entities.UserAccount;

public class ReceiveBlock implements ReceiveBlockInputBoundary{


    @Override
    public boolean block(UserAccount user1, UserAccount user2){
        user1.set_blocked_users(user2);
        user2.set_blocked_by_users(user1);
        RetrieveBlock block1 = new RetrieveBlock();
        block1.connector();
        return true;
    }


}
