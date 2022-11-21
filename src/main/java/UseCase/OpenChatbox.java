package UseCase;

import Entities.ChatBox;
import UseCase.SendMessageID;
import UseCase.RetrieveLike;

public class OpenChatbox implements ChatBoxIB{
    RetrieveLike likes;

    @Override
    public boolean mutualUsers(SendMessageID sender) {
         // check if users are mutually liked
        if (likes.mutualLike(sender.messageSender, sender.messageReceiver) == false)
        {
            // show message that says, can't chat just yet!
            return false;

        }

        else
        {
            // open chatbox
            return true;
        }
    }
}
