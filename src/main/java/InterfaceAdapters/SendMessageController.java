package InterfaceAdapters;

import UseCase.ChatBoxIB;
import UseCase.SendMessageIB;
import UseCase.SendMessageID;

public class SendMessageController {

    SendMessageID user;

    public void messageController(ChatBoxIB input){
        input.mutualUsers(user);
    }

    public void sendController(SendMessageIB messageInfo){
        messageInfo.sendMessage();
    }
}
