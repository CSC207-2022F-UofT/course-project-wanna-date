package use_case;

import entities.UserAccount;
import frameworks_drivers.DataAccess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/** Create unit test for Login useCase. No tests for input boundary because it is an interface.
 */
public class LoginManagerTest {

    /** Test cases isValidLogin for invalid pair of username and password.
     * */
    @Test
    public void isValidLoginInvalidPair() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

        // Show a correct pair of username and password
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        UserAccount user = databaseManager.retrieveUserAccount("lov123");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        LoginManager loginManager = new LoginManager();
        boolean testInvalidPair = loginManager.isValidLogin("lov123", "11112222");

        Assertions.assertFalse(testInvalidPair);
    }

    /** Test cases isValidLogin for null input for username.
     * */
    @Test
    public void isValidLoginNullUsername() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

        LoginManager loginManager = new LoginManager();
        boolean testNullUsername = loginManager.isValidLogin("", "12345678");

        Assertions.assertFalse(testNullUsername);
    }

    /** Test cases isValidLogin for null input for password.
     * */
    @Test
    public void isValidLoginNullPassword() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

        LoginManager loginManager = new LoginManager();
        boolean testNullPassword = loginManager.isValidLogin("lov123", "");

        Assertions.assertFalse(testNullPassword);
    }

    /** Test cases isValidLogin for null input for username and password.
     * */
    @Test
    public void isValidLoginNullInput() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

        LoginManager loginManager = new LoginManager();
        boolean testNullInput = loginManager.isValidLogin("", "");

        Assertions.assertFalse(testNullInput);
    }
}
