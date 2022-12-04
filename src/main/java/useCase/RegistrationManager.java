package useCase;

import entities.UserAccount;

import java.util.ArrayList;

/** A useCase Class that manages Registration feature.
 * */
public class RegistrationManager implements RegistrationInputBoundary{

    public RegistrationManager() {}

    /** Function that returns a boolean value of whether the variables given by the user is within the
     * application guideline.
     * This function is called when the user first registers to the application.
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
    @Override
    public boolean isValidRegistration(String username,
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

    /** Function that returns a boolean value of whether the username given is valid.
     * Valid username is one that has not existed before, not empty, and not consists of only white space.
     *
     * @param username  represents the username of the user.
     * */
    public boolean isValidUsername(String username) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        return (!(databaseManager.isUsernameExist(username)) && (username.length() >= 1)
        && !(username.trim().isEmpty()));
    }

    /** Function that returns a boolean value of whether the pronouns given is valid.
     * Valid pronouns is one of He/Him, She/Her, or They/Them.
     *
     * @param pronouns  represents the pronouns of the user.
     * */
    public boolean isValidPronouns(String pronouns) {
        return (pronouns.equals("He/Him") || pronouns.equals("She/Her") || pronouns.equals("They/Them"));
    }

    /** Function that returns a boolean value of whether the gender given by the user is within the
     * application guideline.
     * Valid gender is one of the 1-character String M, F, or N.
     *
     * @param gender    represents the gender of the user.
     * */
    public boolean isValidGender(String gender) {
        return (gender.equals("M") || gender.equals("F") || gender.equals("N"));
    }

    /** Function that returns a boolean value of whether the sexuality given by the user is within the
     * application guideline.
     * Valid sexuality is one of the 1-character String G, L, H, or B.
     *
     * @param sexuality     represents the sexuality of the user.
     * */
    public boolean isValidSexuality(String sexuality) {
        return (sexuality.equals("G") || sexuality.equals("L") || sexuality.equals("H") || sexuality.equals("B"));
    }

    /** Function that returns a boolean value of whether the password given by the user is within the
     * application guideline.
     * Valid password is one that contains at least 8 characters, no space, and not consists of only white space.
     *
     * @param password    represents the password of the user.
     * */
    public boolean isValidPassword(String password) {
        return (password.length() >= 8 && !(password.contains(" ")) && !(password.trim().isEmpty()));
    }

    /** Function that returns a boolean value of whether the interest given by the user is within the
     * application guideline.
     * Valid interest is one of the interest listed here: Culinary, Sports, Watching, Photography, Travelling,
     * Fashion, Music, Exercise, Games, Socializing, or Others.
     *
     * @param interest    represents the number one interest of the user.
     * */
    public boolean isValidInterest(String interest) {
        ArrayList<String> list_interests = new ArrayList<>(11);
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
