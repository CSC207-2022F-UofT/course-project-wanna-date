package Entities;

public interface MessageFactory {
    Message storeMessage(String sender, String receiver, String text);
}
