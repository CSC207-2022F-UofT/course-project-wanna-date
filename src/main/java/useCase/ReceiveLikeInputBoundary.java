package useCase;
import entities.UserAccount;

public interface ReceiveLikeInputBoundary {


    default boolean like(UserAccount user1, UserAccount user2){
        return false;
    }
}
