package entities.message;

public class MessageHistory implements Message{

    /**
     * Stores the message history between two users.
     * Stores the message and the users.
     */

    //The username of the user who sent the message
    private final String sendingUser;

    //The username of the user who received the message
    private final String receivingUser;

    //The message sent by the user
    private final String message;

    public MessageHistory(String sendingUser, String receivingUser, String message) {
        this.sendingUser = sendingUser;
        this.receivingUser = receivingUser;
        this.message = message;
    }

    @Override
    public String getSendingUser() {
        return this.sendingUser;
    }

    @Override
    public String getReceivingUser() {
        return this.receivingUser;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
