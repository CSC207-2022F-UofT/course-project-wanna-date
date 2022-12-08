package useCase;

import frameworksDrivers.DataAccess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/** Create unit test for Registration useCase. No tests for input boundary because it is an interface.
 */
public class RegistrationManagerTest {

    /** Test cases isValidRegistration for invalid username.
     *  Valid username is a username that has not existed before, not blank (only white spaces), and not null.
     * */
    @Test
    public void isValidRegistrationNullUsername() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

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

    /** Test cases isValidRegistration for blank username (only filled with white spaces).
     *  Valid username is a username that has not existed before, not blank (only white spaces), and not null.
     * */
    @Test
    public void isValidRegistrationBlankUsername() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

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

    /** Test cases isValidRegistration for username that has existed.
     *  Valid username is a username that has not existed before, not blank (only white spaces), and not null.
     * */
    @Test
    public void isValidRegistrationInvalidUsername() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

        // Shows that username "lov123" already existed in Database
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        System.out.println(databaseManager.isUsernameExist("lov123"));

        RegistrationManager registrationManager = new RegistrationManager();
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

    /** Test case isValidRegistration for invalid pronouns.
     *  Valid pronouns is one of He/Him, She/Her, They/Them.
     * */
    @Test
    public void isValidRegistrationInvalidPronouns() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

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
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

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
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

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
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

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

    /** Test cases isValidRegistration for null password.
     *  Valid password is a password with at least 8 characters, do not contain any white space, and not null.
     * */
    @Test
    public void isValidRegistrationNullPassword() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

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

    /** Test cases isValidRegistration for password that has only white space character(s).
     *  Valid password is a password with at least 8 characters, do not contain any white space, and not null.
     * */
    @Test
    public void isValidRegistrationBlankPassword() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

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

    /** Test cases isValidRegistration for password that has a white space character.
     *  Valid password is a password with at least 8 characters, do not contain any white space, and not null.
     * */
    @Test
    public void isValidRegistrationSpacedPassword() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

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
                "hello world");

        Assertions.assertFalse(testBlankPassword);
    }

    /** Test cases isValidRegistration for password that is less than 8 characters long.
     *  Valid password is a password with at least 8 characters, do not contain any white space, and not null.
     * */
    @Test
    public void isValidRegistrationInvalidPassword() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

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

    @Test
    public void isValidRegistrationTrue() {
        // Create Database from database.csv
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();

        // Shows that username "lov456" has not existed in Database
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        System.out.println(databaseManager.isUsernameExist("lov456"));

        RegistrationManager registrationManager = new RegistrationManager();
        boolean testValidRegistration = registrationManager.isValidRegistration(
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
                "12345678");

        Assertions.assertTrue(testValidRegistration);
    }
}
