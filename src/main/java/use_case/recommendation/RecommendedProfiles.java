package use_case.recommendation;

import entities.account.UserAccount;

import java.util.List;

public class RecommendedProfiles {

    public String recProfileUser;
    public List<RecOutProfile> recProfileList;
    public List<String> recUserAcc;

    /**
     * Construct a RecommendedProfiles object, giving it the given
     * parameters of data to output.
     *
     * @param centralUser       User's account
     * @param recommendedUsers  User's recommended profiles
     * @param recUserAcc        User's recommended user accounts; parallel list to recommendedUsers
     */
    public RecommendedProfiles(UserAccount centralUser, List<RecOutProfile> recommendedUsers,
                               List<String> recUserAcc){
        this.recProfileUser = centralUser.getUsername();
        this.recProfileList = recommendedUsers;
        this.recUserAcc = recUserAcc;
    }

    public String getRecProfileUser() {
        return recProfileUser;
    }

    /**
     * Get the recommended profiles for the user contained in this object.
     */
    public List<RecOutProfile> getRecProfileList() {
        return recProfileList;
    }

    /**
     * Get the recommended profiles (user account version) for the user contained in this object.
     */
    public List<String> getRecUserAcc() {
        return recUserAcc;
    }
}
