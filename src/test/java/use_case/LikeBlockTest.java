package use_case;

import entities.account.UserAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import use_case.like.*;

import java.util.ArrayList;

public class LikeBlockTest {
    /** Create unit test for the use cases only expect for input and output boundary. We don't test input and output
     * boundary because it is an interface so there is no implementation of the function that can be tested. Besides
     * that, only use cases is tested because the other component mainly focuses on the program flow so error will be
     * shown when program is run.
     */

    UserAccount user1 = new UserAccount("AL", "AML", 20, "her", "CAN",
            "ON", "TOR", "F", "H","Watching", "123");
    UserAccount user2 = new UserAccount("JSmith", "Jessica Smith", 20, "her", "CAN",
            "ON", "TOR", "F", "H","Music", "124");


    @Test
    public void ReceiveLikeAddLikeUser1(){
        ReceiveLike likeTest1 = new ReceiveLike();
        likeTest1.like(user1, user2);
        ArrayList<Object> user1Like = new ArrayList<>();
        user1Like.add(user2);

        Assertions.assertEquals(user1Like,user1.getLikedUsers());
    }

    @Test
    public void ReceiveLikeAddLikedByUser2(){
        ReceiveLike likeTest1 = new ReceiveLike();
        likeTest1.like(user1, user2);
        ArrayList<Object> user2Like = new ArrayList<>();
        user2Like.add(user1);

        Assertions.assertEquals(user2Like,user2.getLikedByUsers());

    }

    @Test
    public void ReceiveBlockAddBlockUser1(){

        ReceiveBlock blockTest1 = new ReceiveBlock();
        blockTest1.block(user1, user2);
        ArrayList<Object> user1Block = new ArrayList<>();
        user1Block.add(user2);

        Assertions.assertEquals(user1Block,user1.getBlockedUsers());
    }

    @Test
    public void ReceiveBlockAddBlockByUser2(){

        ReceiveBlock blockTest1 = new ReceiveBlock();
        blockTest1.block(user1, user2);
        ArrayList<Object> user2Block = new ArrayList<>();
        user2Block.add(user1);

        Assertions.assertEquals(user2Block,user2.getBlockedByUsers());
    }

    @Test
    public void RetrieveLikeMutualLikeTrue(){

        ReceiveLike likeTest1 = new ReceiveLike();
        likeTest1.like(user1, user2);
        likeTest1.like(user2,user1);

        RetrieveLike mutualLike = new RetrieveLike();
        Assertions.assertTrue(mutualLike.mutualLike(user1, user2));
    }

    @Test
    public void RetrieveLikeMutualLikeFalse(){

        ReceiveLike likeTest1 = new ReceiveLike();
        likeTest1.like(user1, user2);

        RetrieveLike mutualLike = new RetrieveLike();
        Assertions.assertFalse(mutualLike.mutualLike(user1, user2));
    }



}
