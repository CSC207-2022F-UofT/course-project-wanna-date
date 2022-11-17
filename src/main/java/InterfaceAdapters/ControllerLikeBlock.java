package InterfaceAdapters;

import Entities.UserAccount;
import UseCase.ReceiveBlockInputBoundary;
import UseCase.ReceiveLikeInputBoundary;

public class ControllerLikeBlock implements ReceiveLikeInputBoundary, ReceiveBlockInputBoundary {
    ReceiveBlockInputBoundary x;
    ReceiveLikeInputBoundary y;

    public void blockController(ReceiveBlockInputBoundary y, UserAccount userblocking, UserAccount userblocked) {
        y.Block(userblocking, userblocked);
    }

    public void likeController(ReceiveLikeInputBoundary x, UserAccount userliking, UserAccount userliked){
        x.Like(userliking, userliked);
    }

}


