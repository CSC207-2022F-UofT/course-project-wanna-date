package use_case.recommendation;

import entities.ComparingProfile;
import entities.UserAccount;

import java.util.ArrayList;

public interface RecOutputBuilder {

    /**
     * Construct the output data to the presenter.
     *
     * @param currentUser   The current user
     * @param finalUsers    A list of users to be recommended
     * @param compList      A corresponding list of ComparingProfiles
     */
    default RecommendedProfiles constructRecOutput(UserAccount currentUser, ArrayList<UserAccount> finalUsers,
                                                   ArrayList<ComparingProfile> compList){
        return null;
    }
}
