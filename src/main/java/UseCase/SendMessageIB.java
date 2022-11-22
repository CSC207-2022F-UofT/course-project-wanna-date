package UseCase;

import UseCase.SendMessageID;

public interface SendMessageIB {
    public default boolean mutualUsers(SendMessageID user){
        return false;
    }

    public default void sendMessage(){

    }
}
