package interface_adapters;

import use_case.RecOutputBoundary;
import use_case.RecommendedProfiles;

public class FakeRecPresenter implements RecOutputBoundary {

    /**
     * Show recommended profiles.
     */
    public void showRecommendations(RecommendedProfiles showedProfiles){}
}
