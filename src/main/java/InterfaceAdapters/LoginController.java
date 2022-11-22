package InterfaceAdapters;

import Entities.UserAccount;
import Entities.UserDatabase;
import FrameworksDrivers.DataAccess;
import UseCase.*;

public class LoginController {

    public LoginController() {}

    public UserDatabase callCreateDatabase() {

        DataAccess dataAccess = new DataAccess();
        return dataAccess.read_csv();

        //DataAccessInterface dataAccessInterface = new DataAccess();
//        String[] data_from_csv = dataAccessInterface.read_csv();

//        DatabaseInputBoundary databaseInputBoundary = new DatabaseManager();
//        return databaseInputBoundary.createDatabase();
    }

    public UserDatabase getDatabase() {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        return databaseManager.getDatabase();
    }

    public boolean call_valid_login(String username, String password) {
        LoginInputBoundary loginInputBoundary = new LoginManager();
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        return loginInputBoundary.is_valid_login(databaseManager.getDatabase(), username, password);     // method in LoginManager needs param, but I can't use a UserDatabase class
                                        // in the Controller class, right?
    }

}

//    public boolean call_valid_login(LoginInputBoundary loginInputBoundary) {
//
//        // Take username
//        Scanner prompt_username = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter username: ");
//
//        String username = prompt_username.nextLine();  // Read user input
//        System.out.println("Username is: " + username);  // Output user input
//
//        // Take password
//        Scanner prompt_password = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter password: ");
//
//        String password = prompt_password.nextLine();  // Read user input
//        System.out.println("Password is: " + password);  // Output user input
//
//        UserDatabase database = new UserDatabase();
//        return loginInputBoundary.is_valid_login(database, username, password);     // method in LoginManager needs param, but I can't use a UserDatabase class
//        // in the Controller class, right?
//    }
