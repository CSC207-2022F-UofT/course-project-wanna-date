package UseCase;

import Entities.ChatBox;
import UseCase.SendMessageID;
import UseCase.RetrieveLike;

public class OpenChatbox implements ChatBoxIB{
    RetrieveLike likes;
    ChatBoxOB presenter;

    @Override
    public boolean mutualUsers(SendMessageID user) {
         // check if users are mutually liked
        if (presenter.chatBoxPresenter(user.messageSender, user.messageReceiver))
        {
            // open chatbox
            return true;

        }

        else
        {
            // show message that says, can't chat just yet!
            return false;
        }
    }
}
