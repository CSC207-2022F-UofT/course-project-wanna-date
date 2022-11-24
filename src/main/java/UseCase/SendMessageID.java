package UseCase;

import Entities.ChatBox;
import Entities.UserAccount;

public class SendMessageID {
    ChatBox message;
    UserAccount user;
    public UserAccount messageReceiver;
    String receivingUser;
    public UserAccount messageSender;
    String sendingUser;
    String text;

    SendMessageID() {
        messageReceiver = message.receiver;
        receivingUser = message.receiver.get_full_name();
        messageSender = user;
        sendingUser = user.get_full_name();
        text = message.textMessage;
    }
}
