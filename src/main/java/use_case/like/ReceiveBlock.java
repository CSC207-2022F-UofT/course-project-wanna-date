package use_case.like;

import entities.UserAccount;

public class ReceiveBlock implements ReceiveBlockInputBoundary{
    /** This is the use case class for Block that add user2 that has been blocked to user1's blocked_users entity also
     * add user1 that is blocking to user2 blocked_by_users entity
     * @param user1 User doing the action (blocking)
     * @param user2 User blocked
     * @return returning boolean true to indicate that this function is successfully called
     */

    @Override
    public boolean block(UserAccount user1, UserAccount user2){
        //add users to the entity
        user1.setBlockedUsers(user2);
        user2.setBlockedByUsers(user1);
        //Call retrieve block so that function in presenter will be called
        RetrieveBlock block1 = new RetrieveBlock();
        block1.connector();
        return true;
    }


}