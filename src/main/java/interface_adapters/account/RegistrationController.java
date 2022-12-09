package interface_adapters.account;

import frameworks_drivers.DataAccess;
import use_case.*;

/** A Controller class that controls the Registration feature.
 * This class is called when a user first registers to the application.
 * */
public class RegistrationController {

    public RegistrationController() {}

    /** Function that helps in calling the controller DataAccess class to create the Database of the application.
     * */
    public void callCreateDatabase() {
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();
    }

    /** Function that helps in calling the useCase CurrUserManager to set the UserAccount of the current user of
     * the application.
     *
     * @param username  represents the username of the user.
     * */
    public void helpSetCurrUsername(String username) {
        CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
        currUserManager.setCurrUsername(username);
    }

    /** Function that helps in calling the useCase RegistrationManager class to check the validity of the
     * variables combination that the user had given.
     *
     * @param username  represents the username of the user.
     * @param full_name represents the full name of the user.
     * @param age       represents the age of the user.
     * @param pronouns  represents the pronouns of the user.
     * @param country   represents the country of the user.
     * @param province  represents the province of the user.
     * @param city      represents the city of the user.
     * @param gender    represents the gender of the user.
     * @param sexuality represents the sexuality of the user.
     * @param interest  represents the interest of the user.
     * @param password  represents the password of the user.
     * */
    public boolean callIsValidRegistration(String username,
                                           String full_name,
                                           int age,
                                           String pronouns,
                                           String country, String province, String city,
                                           String gender,
                                           String sexuality,
                                           String interest,
                                           String password) {
        RegistrationInputBoundary registrationInputBoundary = new RegistrationManager();
        return registrationInputBoundary.isValidRegistration(username, full_name, age, pronouns,
                country, province, city, gender, sexuality, interest, password);
    }
}
