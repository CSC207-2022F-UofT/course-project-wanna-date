package InterfaceAdapters;

import UseCase.RegistrationManager;

public class RegistrationController {

    private RegistrationManager regis_manager;

    public RegistrationController(RegistrationManager regis_manager) {
        this.regis_manager = regis_manager;
    }

//    // Ask regis info
//
//    /* Ask inputs from user for registration
//    * Return a List of user's inputs (username, full_name, etc.)
//    *
//    * */
//    public List get_info() {}
//
//    /* Create user account based on user's input through RegistrationManager
//    * Return True if account is successfully created, False otherwise
//    *
//    * */
//    public boolean create_user_account() {
//
//    }
//
//    public boolean is_empty_string() {
//
//    }
//
//    public boolean is_valid_username() {
//
//    }
//
//    public boolean is_valid_pronouns() {
//
//    }
//
//    public boolean is_valid_gender() {
//
//    }
//
//    public boolean is_valid_sexuality() {
//
//    }
//
//    public boolean is_valid_password() {
//
//    }
//
//    public boolean is_valid_interests() {
//
//    }

}
