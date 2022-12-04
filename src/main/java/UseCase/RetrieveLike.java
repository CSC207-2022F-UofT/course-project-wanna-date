package UseCase;
import Entities.UserAccount;

import java.util.ArrayList;

public class RetrieveLike {
<<<<<<< HEAD:src/main/java/UseCase/RetrieveLike.java
    RetrieveLikeOutputBoundary param1;

    public RetrieveLike(RetrieveLikeOutputBoundary OB_Like){
        this.param1 = OB_Like;
    }

    public RetrieveLike(){

    }
=======
    /** RetrieveLike class that will be connected to the presenter which is responsible to update view when
     * action is given from the user.
     */
>>>>>>> 705418cb8463c0ebde7aa1e2ca88cf168bae0e37:src/main/java/useCase/RetrieveLike.java

    public void connector() {
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
