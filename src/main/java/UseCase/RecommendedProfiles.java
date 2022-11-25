package UseCase;

import Entities.UserAccount;

import java.util.List;

public class RecommendedProfiles {

    public UserAccount recProfileUser;
    public List<RecOutProfile> recProfileList;
    public List<UserAccount> recUserAcc;

    /**
     * Construct a RecommendedProfiles object, giving it the given
     * parameters of data to output.
     *
     * @param centralUser       User's account
     * @param recommendedUsers  User's recommended profiles
     * @param recUserAcc        User's recommended user accounts; parallel list to recommendedUsers
     */
    public RecommendedProfiles(UserAccount centralUser, List<RecOutProfile> recommendedUsers,
                               List<UserAccount> recUserAcc){
        this.recProfileUser = centralUser;
        this.recProfileList = recommendedUsers;
        this.recUserAcc = recUserAcc;
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
    public List<UserAccount> getRecUserAcc() {
        return recUserAcc;
    }
}
