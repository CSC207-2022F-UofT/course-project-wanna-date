package useCase;

import entities.UserAccount;

import java.util.ArrayList;

/**
 * A class that provides the variables inputted from the user.
 */

public class SendMessageID{
    private String receivingUser, sendingUser, text;

    public SendMessageID(String receivingUser, String sendingUser, String text) {
        this.receivingUser = receivingUser;
        this.sendingUser = sendingUser;
        this.text = text;
    }

    String getSendingUser(){
        return sendingUser;
    }

    String getReceivingUser(){
        return receivingUser;
    }

    String getText(){
        return text;
    }
}
