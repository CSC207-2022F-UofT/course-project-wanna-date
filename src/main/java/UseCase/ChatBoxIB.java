package UseCase;

import UseCase.SendMessageID;

public interface ChatBoxIB {
    public default boolean mutualUsers(SendMessageID user){
        return false;
    }
}
