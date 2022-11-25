import entities.UserAccount;
import useCase.OpenChatbox;
import useCase.SendMessageID;
import useCase.ReceiveLike;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class OpenChatboxTest {
    ArrayList<String> interest1 = new ArrayList<>();
    ArrayList<String> interest2 = new ArrayList<>();

    SendMessageID inputs = new SendMessageID();

    UserAccount user1 = new UserAccount("JD", "Jane Doe", 22, "she/her", "CAN",
            "ON", "Toronto", 'F','H', interest1, "123", "numbers");
    UserAccount user2 = new UserAccount("JS", "John Smith", 23, "he/him", "CAN",
            "ON", "Toronto", 'M','H', interest2, "hu", "greeting");

    @Test
    public void OpenChatBoxMutual(){
        user1.set_liked_users(user2);
        user2.set_liked_users(user1);

        OpenChatbox open = new OpenChatbox();

        Assertions.assertEquals(true, open.mutualUsers(inputs));
    }

    @Test
    public void OpenChatBoxNotMutual(){
        user1.set_liked_users(user2);

        OpenChatbox open = new OpenChatbox();

        Assertions.assertEquals(false, open.mutualUsers(inputs));
    }
}
