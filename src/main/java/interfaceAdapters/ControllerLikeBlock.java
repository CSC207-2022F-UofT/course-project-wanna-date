package interfaceAdapters;

import entities.UserAccount;
import useCase.ReceiveBlock;
import useCase.ReceiveBlockInputBoundary;
import useCase.ReceiveLike;
import useCase.ReceiveLikeInputBoundary;

public class ControllerLikeBlock {
    /** Controller for both like and block. There are 2 functions one for each action. Both function return String
     * that will be shown in the UI after button was clicked. Controller call the function in input boundary as
     * part of the Clean Architecture
     * @param userBlocking user doing the action
     * @param userBlocked user receiving the action
     * @return return String received from the presenter after function in presenter is called
     */

    public String blockController(String userBlocking, String userBlocked) {
        // Create new ReceiveBlockInputBoundary with specific class of ReceiveBlock so that function with implementation
        // is called.
        // This might be facade design pattern
        ReceiveBlockInputBoundary BlockIB = new ReceiveBlock();
        ViewProfileController view1 = new ViewProfileController();
        UserAccount user1 = view1.callSearchUser(userBlocking);
        UserAccount user2 = view1.callSearchUser(userBlocked);
        boolean result = BlockIB.block(user1, user2); // calling the main method
        PresenterLikeBlock presenter = new PresenterLikeBlock(); // create new presenter item to call its function later
        if (result){
            return presenter.presenterBlock(); //presenterBlock function return String which will be used in the UI
        }
        return " "; // if presenter doesn't run properly empty string is return
    }

    public String likeController(String userLiking, String userLiked){
        // Create new ReceiveLikeInputBoundary with specific class of ReceiveLike so that function with implementation
        // is called.
        ReceiveLikeInputBoundary LikeIB = new ReceiveLike();

        ViewProfileController view1 = new ViewProfileController();
        UserAccount user1 = view1.callSearchUser(userLiking);
        UserAccount user2 = view1.callSearchUser(userLiked);
        PresenterLikeBlock presenter = new PresenterLikeBlock(); // calling main method in the use case
        boolean result = LikeIB.like(user1, user2);
        if(result){
            return presenter.presenterLike(); //presenterLike function return String which will be used in the UI
        }
        return " ";
    }


}