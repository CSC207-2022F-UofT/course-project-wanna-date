package interfaceAdapters;

import frameworksDrivers.DataAccess;
import useCase.*;

public class RegistrationController {

    public RegistrationController() {}

    public void helpSetCurrUsername(String username) {
        CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
        currUserManager.setCurrUsername(username);
    }

    public void callCreateDatabase() {
        DataAccess dataAccess = new DataAccess();
        dataAccess.readCSV();
    }

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
