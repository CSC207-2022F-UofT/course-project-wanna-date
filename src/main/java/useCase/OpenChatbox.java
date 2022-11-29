package useCase;

import entities.ChatBox;
import useCase.UserManager;
import useCase.SendMessageID;
import useCase.RetrieveLike;

public class OpenChatbox implements ChatBoxIB {
    UserManager likes;
    ChatBoxOB presenter;

    @Override
    public boolean mutualUsers(SendMessageID user) {
         // check if users are mutually liked
//        if (presenter.chatBoxPresenter(user.messageSender, user.messageReceiver))
        return likes.getLikedByUsernames().contains(user.sendingUser);
    }
}
