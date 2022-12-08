package interfaceAdapters;

import useCase.SendMessageIB;
import useCase.SendMessageID;
import useCase.ReceiveMessageOD;

public class SendMessageController {
    private final SendMessageIB messageInput;

    public SendMessageController(SendMessageIB messageInput) {
        this.messageInput = messageInput;
    }

    public ReceiveMessageOD saveMessage(SendMessageID sendMessageID) {return messageInput.sendMessage(sendMessageID);}
}
