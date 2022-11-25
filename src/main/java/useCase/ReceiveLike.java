package useCase;
import entities.UserAccount;

public class ReceiveLike implements ReceiveLikeInputBoundary{
    /** Use case for like action. Add user2 to user1 liked_users entities and add user1 to user2 liked_by_users
     * entities.
     * @param user1 user liking
     * @param user2 user liked
     * @return return boolean true to indicate this version of the function is called
     */

    @Override
    //Main method to add update UserAccount liked_user and liked_by_user
    public boolean like(UserAccount user1, UserAccount user2){
        // Add user to each entity
        user1.set_liked_users(user2);
        user2.set_liked_by_users(user1);

        //Create new RetrieveLike object so that this function will call method in retrieve like which call the
        //presenter
        RetrieveLike like1 = new RetrieveLike();
        like1.connector();
        return true;
    }


}
