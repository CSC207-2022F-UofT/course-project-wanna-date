package interface_adapters;

import interface_adapters.recommendation.RecShowRecBoundary;
import use_case.recommendation.*;

public class FakeRecUI implements RecShowRecBoundary {

    /**
     * Show recommendations and give some data to the controller.
     *
     * @param suggestedProfiles    A list of profiles to output
     */
    public void showRec(RecommendedProfiles suggestedProfiles){}
}
