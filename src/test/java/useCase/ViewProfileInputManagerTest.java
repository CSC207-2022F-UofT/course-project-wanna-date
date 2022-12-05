package useCase;

import entities.UserAccount;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

/** Create unit test for ViewProfile useCase. No tests for input boundary and output boundary
 *  because they are interfaces.
 */
public class ViewProfileInputManagerTest {

    // Create a new UserAccount for this test and save it to Database
    public static void main(String[] args) {
        UserAccount newUser = new UserAccount(
                "lov456",
                "Lovina",
                20,
                "She/Her",
                "Indonesia",
                "West Jakarta",
                "Jakarta",
                "F",
                "H",
                "Watching",
                "12345678"
        );
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        databaseManager.saveNewUser("lov456", newUser);
    }

    @Test
    public void searchInfoLength() {
        ViewProfileInputManager viewProfileInputManager = new ViewProfileInputManager();
        ArrayList<String> info = viewProfileInputManager.searchInfo("lov456");

        Assertions.assertEquals(11, info.size());
    }

    @Test
    public void searchInfoCorrect() {
        ViewProfileInputManager viewProfileInputManager = new ViewProfileInputManager();
        ArrayList<String> info = viewProfileInputManager.searchInfo("lov456");

        Assertions.assertEquals("Lovina", info.get(1));
        Assertions.assertEquals("20", info.get(2));
        Assertions.assertEquals("She/Her", info.get(3));
        Assertions.assertEquals("Indonesia", info.get(4));
        Assertions.assertEquals("West Jakarta", info.get(5));
        Assertions.assertEquals("Jakarta", info.get(6));
        Assertions.assertEquals("F", info.get(7));
        Assertions.assertEquals("H", info.get(8));
        Assertions.assertEquals("Watching", info.get(9));
        Assertions.assertEquals("12345678", info.get(10));
    }
}
