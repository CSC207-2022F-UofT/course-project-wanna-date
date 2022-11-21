package useCase;

import entities.UserAccount;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ReceiveLikeTest {
    /** Create unit test for the use cases only expect for input and output boundary. We don't test input and output
     * boundary because it is an interface so there is no implementation of the function that can be tested. Besides
     * that, only use cases is tested because the other component mainly focuses on the program flow so error will be
     * shown when program is run.
     */
    ArrayList<String> interests1 = new ArrayList<>();

    ArrayList<String>interest2 = new ArrayList<>();

    UserAccount user1 = new UserAccount("AL", "AML", 20, "her", "CAN",
            "ON", "TOR", "Female", "Hetero",interests1, "123");
    UserAccount user2 = new UserAccount("JSmith", "Jessica Smith", 20, "her", "CAN",
            "ON", "TOR", "Female", "Hetero",interest2, "124");


    @Test
    public void ReceiveLikeAddLikeUser1(){
        interests1.add("watch");
        interest2.add("Eat");
        ReceiveLike likeTest1 = new ReceiveLike();
        likeTest1.like(user1, user2);
        ArrayList<Object> user1Like = new ArrayList<>();
        user1Like.add(user2);

        Assertions.assertEquals(user1Like,user1.get_liked_users());
    }

    @Test
    public void ReceiveLikeAddLikedByUser2(){
        interests1.add("Sleep");
        interest2.add("Dance");
        ReceiveLike likeTest1 = new ReceiveLike();
        likeTest1.like(user1, user2);
        ArrayList<Object> user2Like = new ArrayList<>();
        user2Like.add(user1);

        Assertions.assertEquals(user2Like,user2.get_liked_by_users());

    }

    @Test
    public void ReceiveBlockAddBlockUser1(){
        interests1.add("Sleep");
        interest2.add("Dance");
        ReceiveBlock blockTest1 = new ReceiveBlock();
        blockTest1.block(user1, user2);
        ArrayList<Object> user1Block = new ArrayList<>();
        user1Block.add(user2);

        Assertions.assertEquals(user1Block,user1.get_blocked_users());
    }

    @Test
    public void ReceiveBlockAddBlockByUser2(){
        interests1.add("Sleep");
        interest2.add("Dance");
        ReceiveBlock blockTest1 = new ReceiveBlock();
        blockTest1.block(user1, user2);
        ArrayList<Object> user2Block = new ArrayList<>();
        user2Block.add(user1);

        Assertions.assertEquals(user2Block,user2.get_blocked_by_users());
    }

    @Test
    public void RetrieveLikeMutualLikeTrue(){
        interests1.add("Sleep");
        interest2.add("Dance");
        ReceiveLike likeTest1 = new ReceiveLike();
        likeTest1.like(user1, user2);
        likeTest1.like(user2,user1);

        RetrieveLike mutualLike = new RetrieveLike();
        Assertions.assertTrue(mutualLike.mutualLike(user1, user2));
    }

    @Test
    public void RetrieveLikeMutualLikeFalse(){
        interests1.add("Sleep");
        interest2.add("Dance");
        ReceiveLike likeTest1 = new ReceiveLike();
        likeTest1.like(user1, user2);

        RetrieveLike mutualLike = new RetrieveLike();
        Assertions.assertFalse(mutualLike.mutualLike(user1, user2));
    }



}
