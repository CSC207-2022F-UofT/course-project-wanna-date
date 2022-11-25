package useCase;

public interface ChatBoxIB {
    public default boolean mutualUsers(SendMessageID user){
        return false;
    }
}
