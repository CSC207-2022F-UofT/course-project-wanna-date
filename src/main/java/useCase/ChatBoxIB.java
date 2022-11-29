package useCase;

public interface ChatBoxIB {
    default boolean mutualUsers(SendMessageID user){
        return false;
    }
}
