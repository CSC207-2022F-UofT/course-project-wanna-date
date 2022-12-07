package useCase;

import entities.*;
import frameworksDrivers.MessageFileUser;
import interfaceAdapters.MessageDSGateway;
import interfaceAdapters.SendMessagePresenter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import useCase.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class SendMessageTest {
    UserAccount sender = new UserAccount("LN", "Linda North", 20, "her", "CAN",
            "ON", "TOR", "F", "H","Photography", "north123");
    UserAccount receiver = new UserAccount("SM", "Simon Mint", 21, "him", "CAN",
            "ON", "TOR", "M", "H","Music", "smint123");

    // for comparison
    SendMessageDS message1 = new SendMessageDS("Simon Mint", "Linda North", "Hello",
            LocalDateTime.of(2022, 11, 29, 17, 31, 41));
    SendMessageDS message2 = new SendMessageDS("Linda North", "Simon Mint", "How are you",
            LocalDateTime.of(2022, 11, 29, 17, 41, 41));
    SendMessageDS message3 = new SendMessageDS("Simon Mint", "Linda North",
            "I'm good. How are you?",
            LocalDateTime.of(2022, 11, 29, 17, 42, 41));
    SendMessageDS message4 = new SendMessageDS("Linda North", "Simon Mint",
            "Good. What are you doing?",
            LocalDateTime.of(2022, 11, 29, 17, 43, 42));
    SendMessageDS message5 = new SendMessageDS("Simon Mint", "Linda North", "Nothing much",
            LocalDateTime.of(2022, 11, 29, 17, 44, 42));

    SendMessageDS message6 = new SendMessageDS("Linda North", "Simon Mint", "Good.",
            LocalDateTime.of(2022, 11, 29, 17, 44, 42));

    MessageDSGateway gateway = new MessageFileUser("./message.csv");
    MessageDSGateway gateway2 = new MessageFileUser("./messages2.csv");
    ReceiveMessageOB presenter = new SendMessagePresenter();
    MessageFactory messageFactory = new MessageFormat();
    SendMessageDS input = new SendMessageDS("Simon Mint", "Linda North", "Nothing much",
            LocalDateTime.now());
    SendMessageID data = new SendMessageID("Simon Mint", "Linda North", "Nothing much");
    SendMessageID data2 = new SendMessageID("Simon Mint", "Linda North", "Good.");

    @Test
    public void addMessageMoreThan4(){
        SendMessage message = new SendMessage(gateway, presenter, messageFactory);
        Map<LocalDateTime, SendMessageDS> pastFive = message.sendMessage(data).getSent();
        List<LocalDateTime> keys = new ArrayList<LocalDateTime>(pastFive.keySet());

        String[] fiveText = {"", "", "", "", ""};
        for (int i = 0; i < 5; i++){
            fiveText[i] = pastFive.get(keys.get(i)).getMessage();
        }

        // expected values
        Map<LocalDateTime, SendMessageDS> pastFiveTexts = new HashMap<LocalDateTime, SendMessageDS>();
        SendMessageDS[] messages = {message1, message2, message3, message4, message5};

        String[] matchingFive = {"", "", "", "", ""};
        for (int i = 0; i < 5; i++){
            matchingFive[i] = messages[i].getMessage();
        }

        Assertions.assertArrayEquals(matchingFive, fiveText);
    }

    @Test
    public void addMessageLessThan4(){
        SendMessage newMessage = new SendMessage(gateway2, presenter, messageFactory);
        Map<LocalDateTime, SendMessageDS> pastMessages = newMessage.sendMessage(data2).getSent();
        List<LocalDateTime> keys = new ArrayList<LocalDateTime>(pastMessages.keySet());

        String[] pastText = {"", "", "", ""};
        for (int i = 0; i < 4; i++){
            pastText[i] = pastMessages.get(keys.get(i)).getMessage();
        }

        // expected values
        Map<LocalDateTime, SendMessageDS> pastFewTexts = new HashMap<LocalDateTime, SendMessageDS>();
        SendMessageDS[] messages = {message1, message2, message3, message6};

        String[] matching = {"", "", "", ""};
        for (int i = 0; i < 4; i++){
            matching[i] = messages[i].getMessage();
        }

        Arrays.sort(matching);
        Arrays.sort(pastText);

        Assertions.assertArrayEquals(matching, pastText);
    }

    public SendMessageTest() throws IOException {

    }
}

