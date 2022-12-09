package use_case.like;

import entities.account.UserAccount;

public interface ReceiveBlockInputBoundary {
    /** This is the input boundary for block action. Below there is a default method without implementation that is also
     * implemented in the use case ReceiveBlock
     * @param user1 user blocking
     * @param user2 user blocked
     * @return return false to indicate that only the interface is called if result is false.
     */

    default boolean block(UserAccount user1, UserAccount user2){
        return false;
    }
}