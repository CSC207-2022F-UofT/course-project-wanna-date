package interfaceAdapters;

import useCase.SendMessageDS;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * A gateway for the message dataset.
 */

public interface MessageDSGateway {
    void save(SendMessageDS sendMessageDS);

    Map<LocalDateTime, SendMessageDS> pastMessages(SendMessageDS sendMessageDS);
}
