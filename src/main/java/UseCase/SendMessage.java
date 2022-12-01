package useCase;

import Entities.Message;
import Entities.MessageFactory;
import InterfaceAdapters.MessageDSGateway;
//import Entities.MessageHistory;
//import FrameworksDrivers.MessageDatabase;
//import useCase.SendMessageID;
//import java.time.*;
//import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;

public class SendMessage implements SendMessageIB {
    // add message to message history
//    SendMessageID inputs;
//    MessageDatabase data;
//
//    @Override
//    public String storeMessage(SendMessageID inputs){
//        // find date
//        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
//        LocalDateTime currentTime = LocalDateTime.now();
//
//        MessageHistory history = new MessageHistory(inputs.sendingUser, inputs.receivingUser, inputs.text,
//                dateTime.format(currentTime));
//
//        data.saveMessages(history.getSendingUser(), history.getReceivingUser(), history.getMessage(),
//                dateTime.format(currentTime), "messages.csv");
//    }

    final MessageDSGateway messageDSGateway;
    final ReceiveMessageOB receiveMessage;
    final MessageFactory messageFactory;

    public SendMessage(MessageDSGateway messageDSGateway, ReceiveMessageOB receiveMessageOB, MessageFactory messageFactory){
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
        SendMessageDS messageDSFormat = new SendMessageDS(messages.getSender(), messages.getReceiver(),
                messages.getText(), now);
        messageDSGateway.save(messageDSFormat);

        ReceiveMessageOD messageResponse = new ReceiveMessageOD(messages.getSender(), now.toString());
        return receiveMessage.saveMessage(messageResponse);
    }

}
