package UseCase;
import Entities.UserAccount;
public class ReceiveLike implements ReceiveLikeInputBoundary{
    RetrieveLike like1;

    //Constructor
    public ReceiveLike(RetrieveLike like1){
        this.like1 = like1;
    }

    @Override
    //Main method to add update UserAccount liked_user and liked_by_user
    public boolean like(UserAccount user1, UserAccount user2){
        user1.set_liked_users(user2);
        user2.set_liked_by_users(user1);
        like1.connector();
        return true;
    }


}
