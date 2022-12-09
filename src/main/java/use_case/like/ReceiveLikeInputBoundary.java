package use_case.like;
import entities.UserAccount;

public interface ReceiveLikeInputBoundary {
    /** InputBoundary for like.
     * Function with no implementation that will be overwritten in ReceiveLike class
     * @param user1 user liking
     * @param user2 user liked
     * @return return false to indicate that the correct function with implementation is not called
     */

    default boolean like(UserAccount user1, UserAccount user2){
        return false;
    }
}