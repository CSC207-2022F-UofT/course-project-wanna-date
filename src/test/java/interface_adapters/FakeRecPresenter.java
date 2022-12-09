package interface_adapters;

import use_case.recommendation.*;

public class FakeRecPresenter implements RecOutputBoundary {

    /**
     * Show recommended profiles.
     */
    public void showRecommendations(RecommendedProfiles showedProfiles){}
}
