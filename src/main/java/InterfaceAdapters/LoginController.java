package InterfaceAdapters;

import Entities.UserDatabase;
import FrameworksDrivers.DataAccess;
import FrameworksDrivers.DatabaseRead;
import FrameworksDrivers.LoginPageDemo;
import UseCase.DataAccessInterface;
import UseCase.LoginInputBoundary;
import UseCase.LoginManager;

import java.util.Scanner;

public class LoginController {

    public LoginController() {}

    public void call_read_csv() {
        LoginInputBoundary loginInputBoundary = new LoginManager();
        DataAccessInterface dataAccessInterface = new DataAccess();
        String[] data_from_csv = dataAccessInterface.read_csv();
        loginInputBoundary.help_create_database(data_from_csv);
    }

    public boolean call_valid_login(String username, String password) {
        LoginInputBoundary loginInputBoundary = new LoginManager();
        UserDatabase database = new UserDatabase();
        return loginInputBoundary.is_valid_login(database, username, password);     // method in LoginManager needs param, but I can't use a UserDatabase class
                                        // in the Controller class, right?
    }

    public static void main(String[] args) {
        LoginController loginController = new LoginController();
        loginController.call_read_csv();
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
