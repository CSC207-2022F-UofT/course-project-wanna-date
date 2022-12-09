package use_case.message;

/**
 * An interface that is implemented by SendMessage.
 */

public interface SendMessageIB {
    ReceiveMessageOD sendMessage(SendMessageID sendMessageID);

    String[] getLikedUsers(String username);
}