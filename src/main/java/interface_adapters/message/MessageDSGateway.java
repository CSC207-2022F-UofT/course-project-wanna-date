package interface_adapters.message;

import use_case.SendMessageDS;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * A gateway for the message dataset.
 */

public interface MessageDSGateway {
    void save(SendMessageDS sendMessageDS);

    Map<LocalDateTime, SendMessageDS> pastMessages(SendMessageDS sendMessageDS);
}
