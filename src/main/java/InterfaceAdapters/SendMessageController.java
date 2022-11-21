package InterfaceAdapters;

import UseCase.ChatBoxIB;
import UseCase.SendMessageID;

public class SendMessageController {

    SendMessageID user;

    public void messageController(ChatBoxIB input){
        input.mutualUsers(user);
    }
}
