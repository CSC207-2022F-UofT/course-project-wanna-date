package interface_adapters.message;

import use_case.message.ReceiveMessageOD;
import use_case.message.SendMessageIB;
import use_case.message.SendMessageID;

/**
 * A controller that calls on SendMessageIB to save the given message to the message database.
 */

public class SendMessageController {
    final SendMessageIB messageInput;

    public SendMessageController(SendMessageIB messageInput) {
        this.messageInput = messageInput;
    }

    public ReceiveMessageOD saveMessage(SendMessageID sendMessageID) {return messageInput.sendMessage(sendMessageID);}

    public String[] getLikedUsers(String username) {
        return messageInput.getLikedUsers(username);
    }
}
