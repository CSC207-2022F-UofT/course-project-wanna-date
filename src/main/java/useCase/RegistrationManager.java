package useCase;

import entities.UserAccount;
import entities.UserDatabase;

import java.util.ArrayList;

public class RegistrationManager implements RegistrationInputBoundary{

    public RegistrationManager() {}

    public boolean isValidRegistration(UserDatabase database,
                                       String username,
                                       String full_name,
                                       int age,
                                       String pronouns,
                                       String country, String province, String city,
                                       String gender,
                                       String sexuality,
                                       String interest,
                                       String password) {
        if (isValidUsername(username)) {
            if (isValidPronouns(pronouns)) {
                if (isValidGender(gender)) {
                    if (isValidSexuality(sexuality)) {
                        if (isValidPassword(password)) {
                            if(isValidInterest(interest)) {
                                UserAccount new_user = new UserAccount(username, full_name, age, pronouns,
                                        country, province, city, gender, sexuality, interest, password);
                                DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
                                databaseManager.saveNewUser(username, new_user);
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isValidUsername(String username) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        if (databaseManager.isUsernameExist(username)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidPronouns(String pronouns) {
        if (pronouns.equals("He/Him") || pronouns.equals("She/Her") || pronouns.equals("They/Them")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidGender(String gender) {
        if (gender.equals("M") || gender.equals("F") || gender.equals("N")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidSexuality(String sexuality) {
        if (sexuality.equals("G") || sexuality.equals("L") || sexuality.equals("H") || sexuality.equals("B")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidPassword(String password) {
        if (password.length() >= 8 && !(password.isBlank())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidInterest(String interest) {
        ArrayList<String> list_interests = new ArrayList<String>(11);
        list_interests.add("Culinary");
        list_interests.add("Sports");
        list_interests.add("Watching");
        list_interests.add("Photography");
        list_interests.add("Travelling");
        list_interests.add("Fashion");
        list_interests.add("Music");
        list_interests.add("Exercise");
        list_interests.add("Games");
        list_interests.add("Socializing");
        list_interests.add("Others");

       return list_interests.contains(interest);
    }
}
