package useCase;

import entities.ChatBox;
import entities.UserAccount;

public class SendMessageID {
    ChatBox message;
    UserAccount user;
    UserAccount messageReceiver, messageSender;
    String receivingUser, sendingUser, text;

    SendMessageID(String receivingUser, String sendingUser,String text) {
//        messageReceiver = message.receiver;
//        messageSender = user;
//        receivingUser = message.receiver.get_full_name();
//        sendingUser = user.get_full_name();
//        text = message.textMessage;
        this.receivingUser = receivingUser;
        this.sendingUser = sendingUser;
        this.text = text;
    }
}
