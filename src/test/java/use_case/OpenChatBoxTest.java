package use_case;


import entities.UserAccount;
import interface_adapters.ChatBoxPresenter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class OpenChatBoxTest {
    UserAccount sender = new UserAccount("AL", "AML", 20, "her", "CAN",
            "ON", "TOR", "F", "H","Watching", "123");
    UserAccount receiver = new UserAccount("JSmith", "Jessica Smith", 20, "her", "CAN",
            "ON", "TOR", "F", "H","Music", "124");

    UserAccount receiver2 = new UserAccount("LW", "Lisa Wood", 32, "her", "CAN",
            "ON", "TOR", "F", "H","Sports", "125");
    UserManager likes = new UserManager(sender);

    ChatBoxOB presenter = new ChatBoxPresenter();

    SendMessageID input1 = new SendMessageID(receiver.getUsername(), sender.getUsername(), "Hello");
    SendMessageID input2 = new SendMessageID(receiver2.getUsername(), sender.getUsername(), "Hello");

    @Test
    public void areMutualUsers(){
        sender.setLikedByUsers(receiver);
        sender.setLikedUsers(receiver);

        OpenChatbox openChat = new OpenChatbox(likes, presenter);

        ChatBoxOD chatOutput = new ChatBoxOD(likes.getLikedByUsernames().contains(sender.getUsername()));

        Assertions.assertEquals(openChat.mutualUsers(input1).isMutual(), chatOutput.isMutual());
    }

    @Test
    public void areNotMutualUsers(){
        sender.setLikedByUsers(receiver);
        sender.setLikedUsers(receiver2);

        OpenChatbox openChat2 = new OpenChatbox(likes, presenter);

        ChatBoxOD chatOutput2 = new ChatBoxOD(likes.getLikedByUsernames().contains(sender.getUsername()));

        Assertions.assertEquals(openChat2.mutualUsers(input2).isMutual(), chatOutput2.isMutual());
    }
}

