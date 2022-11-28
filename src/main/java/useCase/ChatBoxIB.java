package useCase;

import useCase.SendMessageID;

public interface ChatBoxIB {
    public default boolean mutualUsers(SendMessageID user){
        return false;
    }
}
