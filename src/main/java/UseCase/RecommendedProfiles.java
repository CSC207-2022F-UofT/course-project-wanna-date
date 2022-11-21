package UseCase;

import java.util.List;

public class RecommendedProfiles {

    public RecOutProfile recProfileUser;
    public List<RecOutProfile> recProfileList;

    /**
     * Construct a RecommendedProfiles object, giving it the given
     * parameters of data to output.
     */
    public RecommendedProfiles(RecOutProfile centralUser, List<RecOutProfile> recommendedUsers){
        this.recProfileUser = centralUser;
        this.recProfileList = recommendedUsers;
    }

    /**
     * Get the recommended profiles for the user contained in this object.
     */
    public List<RecOutProfile> getRecProfileList() {
        return recProfileList;
    }
}
