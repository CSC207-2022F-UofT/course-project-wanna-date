package InterfaceAdapters;

import Entities.ChatBox;
import Entities.UserAccount;
import UseCase.*;

public class ChatBoxPresenter implements ChatBoxOB{
    @Override
    public boolean chatBoxPresenter(UserAccount sender, UserAccount receiver) {
        // the LHS is supposed to get the output
        RetrieveLike like = new RetrieveLike();
        if (like.mutualLike(sender, receiver)) {
            ChatBox chatBox = new ChatBox();
            return true;
        }

        else {
            return false;
        }
    }

    // Note from Arist: removed the override notation since it seemed unneeded
    public String sendMessagePresenter(){
        return "Message Sent.";
    }
}
