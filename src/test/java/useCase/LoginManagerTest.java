package useCase;

import interfaceAdapters.LoginController;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/** Create unit test for Login useCase. No tests for input boundary because it is an interface.
 */
public class LoginManagerTest {

    // Create Database based on CSV File so we can use
    public static void main(String[] args) {
        LoginController loginController = new LoginController();
        loginController.callCreateDatabase();
    }

    @Test
    public void isValidLoginNotValidPair() {
        LoginManager loginManager = new LoginManager();
        boolean testNotValid = loginManager.isValidLogin("lov123", "11112222");

        Assertions.assertFalse(testNotValid);
    }

    @Test
    public void isValidLoginNullInput() {
        LoginManager loginManager = new LoginManager();
        boolean testNull = loginManager.isValidLogin("", "");

        Assertions.assertFalse(testNull);
    }

}
