package useCase;

import entities.Message;
import entities.MessageFactory;
import entities.MessageFormat;
import frameworksDrivers.MessageFileUser;
import interfaceAdapters.MessageDSGateway;
import interfaceAdapters.SendMessagePresenter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * A class that "sends the message" to the other user by adding it to the
 * message data set.
 */
public class SendMessage implements SendMessageIB {

    final MessageDSGateway messageDSGateway;
    final ReceiveMessageOB receiveMessage;
    final MessageFactory messageFactory;

    public SendMessage(MessageDSGateway messageDSGateway, ReceiveMessageOB receiveMessageOB,
                       MessageFactory messageFactory){
        this.messageDSGateway = messageDSGateway;
        this.receiveMessage = receiveMessageOB;
        this.messageFactory = messageFactory;
    }

    @Override
    public ReceiveMessageOD sendMessage(SendMessageID sendMessageID){
        Message messages = messageFactory.storeMessage(sendMessageID.getSendingUser(), sendMessageID.getReceivingUser(),
                sendMessageID.getText());

        // get current time
        LocalDateTime now = LocalDateTime.now();
        SendMessageDS messageDSFormat = new SendMessageDS(messages.getSendingUser(), messages.getReceivingUser(),
                messages.getMessage(), now);
        messageDSGateway.save(messageDSFormat);

        ReceiveMessageOD messageResponse = new ReceiveMessageOD(messageDSGateway.pastMessages(messageDSFormat));

        // past five messages
        return receiveMessage.saveMessage(messageResponse);
    }
}
