package InterfaceAdapters;

import Entities.UserAccount;
import UseCase.ReceiveBlock;
import UseCase.ReceiveBlockInputBoundary;
import UseCase.ReceiveLike;
import UseCase.ReceiveLikeInputBoundary;

public class ControllerLikeBlock implements ReceiveLikeInputBoundary, ReceiveBlockInputBoundary {

    public String blockController(UserAccount userblocking, UserAccount userblocked) {
        ReceiveBlockInputBoundary BlockIB = new ReceiveBlock();
        boolean result = BlockIB.block(userblocking, userblocked);
        PresenterLikeBlock presenter = new PresenterLikeBlock();
        if (result){
            return presenter.presenterBlock(); //after view is done call view method that takes in string as parameter
        }
        return " ";
    }

    public String likeController(UserAccount userliking, UserAccount userliked){
        ReceiveLikeInputBoundary LikeIB = new ReceiveLike();
        PresenterLikeBlock presenter = new PresenterLikeBlock();
        boolean result = LikeIB.like(userliking, userliked);
        if(result){
            return presenter.presenterLike(); //call method in view that takes string as parameter to update view
        }
        return " ";
    }


}


