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


    /** Test cases isValidRegistration for invalid username.
     *  Valid username is a username that has not existed before, not blank (only white spaces), and not null.
     * */
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
    public void isValidRegistrationBlankUsername() {
        RegistrationManager registrationManager = new RegistrationManager();
        boolean testBlankUsername = registrationManager.isValidRegistration(
                "   ",
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

        Assertions.assertFalse(testBlankUsername);
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
    // function does not save the new username-password pair to the database

    /** Test case isValidRegistration for invalid pronouns.
     *  Valid pronouns is one of He/Him, She/Her, They/Them.
     * */
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

    /** Test case isValidRegistration for invalid gender.
     *  Valid pronouns is one of "M","F","N".
     * */
    @Test
    public void isValidRegistrationInvalidGender() {
        RegistrationManager registrationManager = new RegistrationManager();
        boolean testInvalidGender = registrationManager.isValidRegistration(
                "lov456",
                "Lovina",
                20,
                "She/Her",
                "Indonesia",
                "West Jakarta",
                "Jakarta",
                "Female",
                "H",
                "Music",
                "abcdefgh");

        Assertions.assertFalse(testInvalidGender);
    }

    /** Test case isValidRegistration for invalid sexuality.
     *  Valid sexuality is one of "G","L","H","B".
     * */
    @Test
    public void isValidRegistrationInvalidSexuality() {
        RegistrationManager registrationManager = new RegistrationManager();
        boolean testInvalidSexuality = registrationManager.isValidRegistration(
                "lov456",
                "Lovina",
                20,
                "She/Her",
                "Indonesia",
                "West Jakarta",
                "Jakarta",
                "F",
                "Straight",
                "Music",
                "abcdefgh");

        Assertions.assertFalse(testInvalidSexuality);
    }

    /** Test case isValidRegistration for invalid interest.
     *  In this application, user can pick one interest that suits them the most.
     *  Valid interest is one of "Culinary", "Sports", "Watching", "Photography", "Travelling",
     *  "Fashion", "Music", "Exercise", "Games", "Socializing", "Others".
     * */
    @Test
    public void isValidRegistrationInvalidInterest() {
        RegistrationManager registrationManager = new RegistrationManager();
        boolean testInvalidInterest = registrationManager.isValidRegistration(
                "lov456",
                "Lovina",
                20,
                "She/Her",
                "Indonesia",
                "West Jakarta",
                "Jakarta",
                "F",
                "H",
                "Sleeping",
                "abcdefgh");

        Assertions.assertFalse(testInvalidInterest);
    }

    /** Test cases isValidRegistration for invalid password.
     *  Valid password is a password with at least 8 characters, not blank (only white spaces), and not null.
     * */
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
    public void isValidRegistrationBlankPassword() {
        RegistrationManager registrationManager = new RegistrationManager();
        boolean testBlankPassword = registrationManager.isValidRegistration(
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
                "   ");

        Assertions.assertFalse(testBlankPassword);
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
