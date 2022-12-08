package interface_adapters;

import useCase.RecOutputBoundary;
import useCase.RecommendedProfiles;

public class FakeRecPresenter implements RecOutputBoundary {

    /**
     * Show recommended profiles.
     */
    public void showRecommendations(RecommendedProfiles showedProfiles){}
}
