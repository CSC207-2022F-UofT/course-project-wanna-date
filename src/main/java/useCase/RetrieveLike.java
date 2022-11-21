package useCase;
import entities.UserAccount;
import interfaceAdapters.PresenterLikeBlock;

import java.util.ArrayList;

public class RetrieveLike {
    /**Use case that is responsible to connect to the presenter.
     * Also implement mutual like for messaging feature purpose.
     */

    // Function to connect his class with ReceiveLike class
    public void connector() {
        RetrieveLikeOutputBoundary param1 = new PresenterLikeBlock();
        like_view(param1);
    }
    //calling method implemented in presenter
    public void like_view(RetrieveLikeOutputBoundary view){
        view.presenterLike();
    }
    //Determine whether the like is mutual
    public boolean mutualLike(UserAccount user1, UserAccount user2){
        ArrayList<UserAccount>users_liked_by_user1 = user1.get_liked_users();
        ArrayList<UserAccount>users_liking_user1 = user1.get_liked_by_users();
        return users_liking_user1.contains(user2) & users_liked_by_user1.contains(user2);
    }

}
