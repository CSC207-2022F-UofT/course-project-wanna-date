package entities.message;

/**
 * An entity class representing how a normal message will look like and the parameters they take.
 */

public class MessageFormat implements MessageFactory{
    @Override
    public Message storeMessage(String sender, String receiver, String text){
        return new MessageHistory(sender, receiver, text);
    }
}
