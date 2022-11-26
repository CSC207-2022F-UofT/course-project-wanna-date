package entities;

//Import the LocalDateTime class
import java.time.LocalDateTime;

//Import the DateTimeFormatter class
import java.time.format.DateTimeFormatter;

public class MessageHistory {

    /**
     * Stores the message history between two users.
     * Stores the message, date and time, and the users.
     */

    //The username of the user who sent the message
    private String sendingUser;

    //The username of the user who received the message
    private String receivingUser;

    //The message sent by the user
    private String message;

    //The date and time of when the message was sent
    private LocalDateTime messageDateTime;

    //Format the date and time into dd-MM-yyyy HH:mm:ss
    // example: 22-12-2021 18:24:09
    DateTimeFormatter dateTimeFormat  = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String formattedMessageDateTime = messageDateTime.format(dateTimeFormat);

    public MessageHistory(String sendingUser, String receivingUser, String message, String formattedMessageDateTime) {
        this.sendingUser = sendingUser;
        this.receivingUser = receivingUser;
        this.message = message;
        this.formattedMessageDateTime = formattedMessageDateTime;
    }

    public String getSendingUser() {
        return this.sendingUser;
    }

    public String getReceivingUser() {
        return this.receivingUser;
    }

    public String getMessage() {
        return this.message;
    }

    public String getFormattedMessageDateTime() {
        return this.formattedMessageDateTime;
    }
}