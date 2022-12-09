package use_case;

import UI.ViewProfilePage;
import entities.UserAccount;
import frameworks_drivers.DataAccess;

import interface_adapters.ViewProfilePresenter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.ArrayList;

/** Create unit test for ViewProfile useCase. No tests for input boundary and output boundary
 *  because they are interfaces.
 */
public class ViewProfileInputManagerTest {

    /** Test cases searchInfo whether it returns the correct number of elements in the ArrayList.
     * The ArrayList should return 11 variables of the user (all variables, excluding: likedUsers, likedByUsers,
     * blockedUsers, blockedByUsers)
     * */
    @Test
    public void searchInfoLength() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

        // Show that username "lov123" exists in Database
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        System.out.println(databaseManager.isUsernameExist("lov123"));

        ViewProfilePage viewProfilePage;
        try {
            viewProfilePage = new ViewProfilePage("lov123");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ViewProfileOutputBoundary viewProfileOutputBoundary = new ViewProfilePresenter(viewProfilePage);

        ViewProfileInputManager viewProfileInputManager = new ViewProfileInputManager();
        ArrayList<String> info = viewProfileInputManager.searchInfo("lov123", viewProfileOutputBoundary);

        Assertions.assertEquals(11, info.size());
    }

    /** Test cases searchInfo whether it returns the correct information of the newly added user.
     * */
    @Test
    public void searchInfoCorrect() throws IOException {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

        // Save a new user to database for the purpose of this testing
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

        ViewProfilePage viewProfilePage = new ViewProfilePage("lov456");
        ViewProfileOutputBoundary viewProfileOutputBoundary = new ViewProfilePresenter(viewProfilePage);

        ViewProfileInputManager viewProfileInputManager = new ViewProfileInputManager();
        ArrayList<String> info = viewProfileInputManager.searchInfo("lov456", viewProfileOutputBoundary);

        Assertions.assertEquals("lov456", info.get(0));
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
