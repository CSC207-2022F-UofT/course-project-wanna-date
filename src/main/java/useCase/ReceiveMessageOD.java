package useCase;

import entities.UserAccount;
import interfaceAdapters.MessageDSGateway;

import java.time.LocalDateTime;
import java.util.Map;

public class ReceiveMessageOD {
    Map<LocalDateTime, SendMessageDS> sent;
    MessageDSGateway gateway;

    SendMessageDS data;
    SendMessageID input;

    public ReceiveMessageOD(Map<LocalDateTime, SendMessageDS> sent){
        this.sent = sent;
    }

    public Map<LocalDateTime, SendMessageDS> getSent() {
        return sent;
    }
}