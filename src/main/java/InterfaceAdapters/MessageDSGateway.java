package InterfaceAdapters;

import useCase.SendMessageDS;

public interface MessageDSGateway {
    void save(SendMessageDS sendMessageDS);
}
