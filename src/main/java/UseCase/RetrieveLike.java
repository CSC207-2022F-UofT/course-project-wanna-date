package UseCase;
import Entities.UserAccount;
import InterfaceAdapters.PresenterLikeBlock;

import java.util.ArrayList;

public class RetrieveLike {

    public void connector() {
        RetrieveLikeOutputBoundary param1 = new PresenterLikeBlock();
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
