package useCase;
import entities.UserAccount;
import interfaceAdapters.PresenterLikeBlock;
import java.util.ArrayList;

public class RetrieveLike {
    /** RetrieveLike class that will be connected to the presenter which is responsible to update view when
     * action is given from the user.
     */

    // Function to connect his class with ReceiveLike class
    public void connector() {
        RetrieveLikeOutputBoundary param1 = new PresenterLikeBlock();
        like_view(param1);
    }

    // Function to call the presenter
    public void like_view(RetrieveLikeOutputBoundary view){

        view.presenterLike();
    }
    //Function to determine mutualLike
    public boolean mutualLike(UserAccount user1, UserAccount user2){
        ArrayList<UserAccount>users_liked_by_user1 = user1.getLikedUsers();
        ArrayList<UserAccount>users_liking_user1 = user1.getLikedByUsers();
        return users_liking_user1.contains(user2) & users_liked_by_user1.contains(user2);
    }

}
