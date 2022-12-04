package interfaceAdapters;

import useCase.SendMessageIB;
import useCase.SendMessageID;
import useCase.ReceiveMessageOD;

/**
 * A controller that calls on SendMessageIB to save the given message to the message database.
 */

public class SendMessageController {
    final SendMessageIB messageInput;

    public SendMessageController(SendMessageIB messageInput) {
        this.messageInput = messageInput;
    }

    public ReceiveMessageOD saveMessage(SendMessageID sendMessageID) {return messageInput.sendMessage(sendMessageID);}
}

