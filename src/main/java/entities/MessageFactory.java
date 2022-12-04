package entities;

/**
 * An entity interface that stores the given message.
 * It is implemented by MessageFormat.
 */

public interface MessageFactory {
    Message storeMessage(String sender, String receiver, String text);
}

