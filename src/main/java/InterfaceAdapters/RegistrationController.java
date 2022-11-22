package InterfaceAdapters;

import Entities.UserDatabase;
import FrameworksDrivers.DataAccess;
import UseCase.*;

public class RegistrationController {

    public RegistrationController() {}

    public UserDatabase callCreateDatabase() {

//        DataAccessInterface dataAccessInterface = new DataAccess();
//        String[] data_from_csv = dataAccessInterface.read_csv();

//        DatabaseInputBoundary databaseInputBoundary = new DatabaseManager();
//        return databaseInputBoundary.createDatabase();

        DataAccess dataAccess = new DataAccess();
        return dataAccess.read_csv();
    }
    public boolean callIsValidRegistration(UserDatabase database,
                                       String username,
                                       String full_name,
                                       int age,
                                       String pronouns,
                                       String country, String province, String city,
                                       String gender,
                                       String sexuality,
                                       String interest,
                                       String password) {
        RegistrationInputBoundary registrationInputBoundary = new RegistrationManager();
        if (registrationInputBoundary.isValidRegistration(database, username, full_name, age, pronouns,
                country, province, city, gender, sexuality, interest, password)) {
            return true;
        }
        return false;
    }
}
