package UseCase;
import Entities.UserAccount;
public class ReceiveLike implements ReceiveLikeInputBoundary{
    UserAccount user_give_action;
    UserAccount user_receive_action;

    public void ReceiveLike(UserAccount user1, UserAccount user2){
        this.user_give_action = user1;
        this.user_receive_action = user2;
    }

    @Override
    public void Like(UserAccount user1, UserAccount user2){

    }

}
