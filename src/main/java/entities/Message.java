package entities;

/**
 * An entity interface representing the information provided by the user and the user's name.
 * It is implemented by Message History.
 */
public interface Message {

    // the message is from
    String getSendingUser();

    // the message is to
    String getReceivingUser();

    // the message
    String getMessage();
}
