package UseCase;
import Entities.UserAccount;

import java.util.ArrayList;

public class RetrieveLike {
    RetrieveLikeOutputBoundary param1;

    public RetrieveLike(RetrieveLikeOutputBoundary OB_Like){
        this.param1 = OB_Like;
    }

    public void connector() {
        like_view(param1);
    }

    public void like_view(RetrieveLikeOutputBoundary view){
        view.presenterLike();
    }

    public boolean mutualLike(UserAccount user1, UserAccount user2){
        ArrayList<UserAccount>users_liked_by_user1 = user1.get_liked_users();
        ArrayList<UserAccount>users_liking_user1 = user1.get_liked_by_users();
        return users_liking_user1.contains(user2) & users_liked_by_user1.contains(user2);
    }

}
