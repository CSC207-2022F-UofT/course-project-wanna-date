package use_case.message;

import java.time.LocalDateTime;

/**
 * A class that stores the information required from the message data set.
 */

public class SendMessageDS {
    private final String sender;
    private final String receiver;
    private final String message;
    private final LocalDateTime time;

    public SendMessageDS(String sender, String receiver, String message, LocalDateTime time){
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.time = time;
    }

    public String getSender(){
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
