package interfaceAdapters;

import entities.UserAccount;
import useCase.ReceiveBlockInputBoundary;
import useCase.ReceiveLikeInputBoundary;

public class ControllerLikeBlock implements ReceiveLikeInputBoundary, ReceiveBlockInputBoundary {

    public String blockController(ReceiveBlockInputBoundary y, UserAccount userblocking, UserAccount userblocked,
                                   PresenterLikeBlock presenter) {
        boolean result = y.block(userblocking, userblocked);
        if (result){
            return presenter.presenterBlock(); //after view is done call view method that takes in string as parameter
        }
        return " ";
    }

    public String likeController(ReceiveLikeInputBoundary x, UserAccount userliking, UserAccount userliked,
                               PresenterLikeBlock presenter){
        boolean result = x.like(userliking, userliked);
        if(result){
            return presenter.presenterLike(); //call method in view that takes string as parameter to update view
        }
        return " ";
    }


}


