package useCase;

import interfaceAdapters.LoginController;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/** Create unit test for Registration useCase. No tests for input boundary because it is an interface.
 */
public class RegistrationManagerTest {

    // Create Database based on CSV File, so we can use the existing users information
    public static void main(String[] args) {
        LoginController loginController = new LoginController();
        loginController.callCreateDatabase();
    }

    @Test
    public void isValidRegistrationNullUsername() {
        RegistrationManager registrationManager = new RegistrationManager();
        boolean testNullUsername = registrationManager.isValidRegistration(
                "",
                "Lovina",
                20,
                "She/Her",
                "Indonesia",
                "West Jakarta",
                "Jakarta",
                "F",
                "H",
                "Music",
                "abcdefgh");

        Assertions.assertFalse(testNullUsername);
    }

    @Test
    public void isValidRegistrationInvalidUsername() {
        RegistrationManager registrationManager = new RegistrationManager();

        // Shows that username "lov123" already existed in Database
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        System.out.println(databaseManager.isUsernameExist("lov123"));

        boolean testInvalidUsername = registrationManager.isValidRegistration(
                "lov123",
                "Lovina",
                20,
                "She/Her",
                "Indonesia",
                "West Jakarta",
                "Jakarta",
                "F",
                "H",
                "Music",
                "abcdefgh");

        Assertions.assertFalse(testInvalidUsername);
    }

    // We can use username "lov456" again because the function above returns False and isValidRegistration
    // function does not save the new username-password pair

    @Test
    public void isValidRegistrationInvalidPronouns() {
        RegistrationManager registrationManager = new RegistrationManager();
        boolean testInvalidPronouns = registrationManager.isValidRegistration(
                "lov456",
                "Lovina",
                20,
                "Her",
                "Indonesia",
                "West Jakarta",
                "Jakarta",
                "F",
                "H",
                "Music",
                "abcdefgh");

        Assertions.assertFalse(testInvalidPronouns);
    }

    @Test
    public void isValidRegistrationNullPassword() {
        RegistrationManager registrationManager = new RegistrationManager();
        boolean testNullPassword = registrationManager.isValidRegistration(
                "lov456",
                "Lovina",
                20,
                "She/Her",
                "Indonesia",
                "West Jakarta",
                "Jakarta",
                "F",
                "H",
                "Music",
                "");

        Assertions.assertFalse(testNullPassword);
    }

    @Test
    public void isValidRegistrationInvalidPassword() {
        RegistrationManager registrationManager = new RegistrationManager();
        boolean testInvalidPassword = registrationManager.isValidRegistration(
                "lov456",
                "Lovina",
                20,
                "She/Her",
                "Indonesia",
                "West Jakarta",
                "Jakarta",
                "F",
                "H",
                "Music",
                "abc");

        Assertions.assertFalse(testInvalidPassword);
    }

}
