package useCase;

import Entities.ChatBox;
import Entities.UserAccount;

public class SendMessageID {
    ChatBox message;
    UserAccount user;
    UserAccount messageReceiver, messageSender;
    private String receivingUser, sendingUser, text;

    SendMessageID(String receivingUser, String sendingUser, String text) {
//        messageReceiver = message.receiver;
//        receivingUser = message.receiver.get_full_name();
//        messageSender = user;
//        sendingUser = user.get_full_name();
//        text = message.textMessage;
        this.receivingUser = receivingUser;
        this.sendingUser = sendingUser;
        this.text = text;
    }

    String getSendingUser(){
        return sendingUser;
    }

    String getReceivingUser(){
        return receivingUser;
    }

    String getText(){
        return text;
    }
}
