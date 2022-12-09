package use_case.message;

import java.time.LocalDateTime;
import java.util.Map;

public class ReceiveMessageOD {
    Map<LocalDateTime, SendMessageDS> sent;

    public ReceiveMessageOD(Map<LocalDateTime, SendMessageDS> sent){
        this.sent = sent;
    }

    public Map<LocalDateTime, SendMessageDS> getSent() {
        return sent;
    }
}