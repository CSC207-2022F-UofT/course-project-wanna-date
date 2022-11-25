package useCase;
import entities.MessageHistory;
import frameworksDrivers.MessageDatabase;
import useCase.SendMessageID;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class SendMessage implements SendMessageIB {
    // add message to message history
    SendMessageID inputs;
    MessageDatabase data;

    @Override
    public void sendMessage(){
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        LocalDateTime currentTime = LocalDateTime.now();

        MessageHistory history = new MessageHistory(inputs.sendingUser, inputs.receivingUser, inputs.text,
                dateTime.format(currentTime));

        data.saveMessages(history.getSendingUser(), history.getReceivingUser(), history.getMessage(),
                dateTime.format(currentTime), "messages.csv");
    }

}
